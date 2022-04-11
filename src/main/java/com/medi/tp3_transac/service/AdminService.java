package com.medi.tp3_transac.service;

import com.medi.tp3_transac.model.document.Book;
import com.medi.tp3_transac.model.document.CD;
import com.medi.tp3_transac.model.document.DVD;
import com.medi.tp3_transac.model.document.Document;
import com.medi.tp3_transac.model.user.Client;
import com.medi.tp3_transac.repository.ClientRepository;
import com.medi.tp3_transac.repository.DocumentLoanRepository;
import com.medi.tp3_transac.repository.DocumentRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdminService {
    private ClientRepository clientRepository;
    private DocumentRepository documentRepository;
    private DocumentLoanRepository documentLoanRepository;

    public AdminService(ClientRepository clientRepository,
                        DocumentRepository documentRepository,
                        DocumentLoanRepository documentLoanRepository) {
        this.clientRepository = clientRepository;
        this.documentRepository = documentRepository;
        this.documentLoanRepository = documentLoanRepository;
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

    public long saveClient(String username, String password){
        return this.clientRepository.save(new Client(username, password)).getId();
    }
}
