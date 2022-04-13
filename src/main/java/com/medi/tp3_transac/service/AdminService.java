package com.medi.tp3_transac.service;

import com.medi.tp3_transac.model.DocumentLoan;
import com.medi.tp3_transac.model.document.Book;
import com.medi.tp3_transac.model.document.CD;
import com.medi.tp3_transac.model.document.DVD;
import com.medi.tp3_transac.model.document.Document;
import com.medi.tp3_transac.model.user.Client;
import com.medi.tp3_transac.repository.BookRepository;
import com.medi.tp3_transac.repository.ClientRepository;
import com.medi.tp3_transac.repository.DocumentLoanRepository;
import com.medi.tp3_transac.repository.DocumentRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AdminService {
    private ClientRepository clientRepository;
    private DocumentRepository documentRepository;
    private DocumentLoanRepository documentLoanRepository;
    private BookRepository bookRepository;

    public AdminService(ClientRepository clientRepository,
                        DocumentRepository documentRepository,
                        DocumentLoanRepository documentLoanRepository,
                        BookRepository bookRepository) {
        this.clientRepository = clientRepository;
        this.documentRepository = documentRepository;
        this.documentLoanRepository = documentLoanRepository;
        this.bookRepository = bookRepository;
    }

    public long saveBook(String title, String author, String genre, int publicationYear, String publisher, int pages){
        return this.documentRepository.save(new Book(title,author,genre,publicationYear,publisher,pages)).getId();
    }

    public long saveCD(String title, String author, String genre, int publicationYear){
        return this.documentRepository.save(new CD(title,author,genre,publicationYear)).getId();
    }

    public long saveDVD(String title, String author, String genre, int publicationYear){
        return this.documentRepository.save(new DVD(title,author,genre,publicationYear)).getId();
    }

    public List<Document> findAllDocuments(){
        return this.documentRepository.findAll();
    }

    public List<Book> findAllBooks(){
        return this.bookRepository.findAll();
    }

    public Optional<Client> findClientById(long id){
        return this.clientRepository.findById(id);
    }

    public Client findClientByIdWithBorrowingHistory(long id){
        Client client = this.clientRepository.findById(id).get();

        System.out.println(client.getDocumentLoans());

        return client;
    }

    public int addCopiesToDocumentWithId(int nbCopies, long documentId){
        Optional<Document> potentialDocument = this.documentRepository.findById(documentId);
        if(potentialDocument.isPresent()){
            Document document;
            document = potentialDocument.get();
            document.setCopies(document.getCopies() + nbCopies);
            return this.documentRepository.save(document).getCopies();
        }
        return -1;
    }

    public void lendDocumentByIdToClientById(long documentId, long clientId){
        Document document = this.documentRepository.findById(documentId).get();
        Client client = this.clientRepository.findByIdWithDocumentLoans(clientId).get();
        DocumentLoan documentLoan = new DocumentLoan(document,client);
        if(document.getCopies() > 0){
            client.getDocumentLoans().add(documentLoan);
            document.setCopies(document.getCopies() - 1);
            this.clientRepository.save(client);
            this.documentLoanRepository.save(documentLoan);
            this.documentRepository.save(document);
        }

    }

    public long saveClient(String username, String password, String email){
        return this.clientRepository.save(new Client(username, password, email)).getId();
    }

    public List<Client> findAllClients(){
        return this.clientRepository.findAll();
    }
}
