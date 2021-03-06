package com.medi.tp3_transac.service;

import com.medi.tp3_transac.dto.BookEditForm;
import com.medi.tp3_transac.dto.DiscEditForm;
import com.medi.tp3_transac.model.DocumentLoan;
import com.medi.tp3_transac.model.document.Book;
import com.medi.tp3_transac.model.document.CD;
import com.medi.tp3_transac.model.document.DVD;
import com.medi.tp3_transac.model.document.Document;
import com.medi.tp3_transac.model.user.Client;
import com.medi.tp3_transac.repository.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class AdminService {
    private ClientRepository clientRepository;
    private DocumentRepository documentRepository;
    private DocumentLoanRepository documentLoanRepository;
    private BookRepository bookRepository;
    private CDRepository cdRepository;
    private DVDRepository dvdRepository;

    public AdminService(ClientRepository clientRepository,
                        DocumentRepository documentRepository,
                        DocumentLoanRepository documentLoanRepository,
                        BookRepository bookRepository,
                        CDRepository cdRepository,
                        DVDRepository dvdRepository) {
        this.cdRepository = cdRepository;
        this.clientRepository = clientRepository;
        this.documentRepository = documentRepository;
        this.documentLoanRepository = documentLoanRepository;
        this.bookRepository = bookRepository;
        this.dvdRepository = dvdRepository;
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

    public List<Book> findAllBooks(){
        return this.bookRepository.findAll();
    }

    public void editBookById(long id, BookEditForm bookEditForm){
        Book book = this.bookRepository.findById(id).get();
        book.setTitle(bookEditForm.getTitle());
        book.setAuthor(bookEditForm.getAuthor());
        book.setGenre(bookEditForm.getGenre());
        book.setPublicationYear(bookEditForm.getPublicationYear());
        book.setPublisher(bookEditForm.getPublisher());
        book.setPages(bookEditForm.getPages());
        book.setCopies(bookEditForm.getCopies());
        this.bookRepository.save(book);
    }

    public Book findBookById(long id){
        return this.bookRepository.findById(id).get();
    }

    public List<CD> findAllCDs(){ return this.cdRepository.findAll();}

    public CD findCDById(long id){
        return this.cdRepository.findById(id).get();
    }

    public void editCDById(long id, DiscEditForm discEditForm){
        CD cd = this.cdRepository.findById(id).get();
        cd.setTitle(discEditForm.getTitle());
        cd.setAuthor(discEditForm.getAuthor());
        cd.setGenre(discEditForm.getGenre());
        cd.setPublicationYear(discEditForm.getPublicationYear());
        cd.setCopies(discEditForm.getCopies());
        this.cdRepository.save(cd);
    }

    public List<DVD> findAllDVDs(){return this.dvdRepository.findAll();}

    public DVD findDVDById(long id){
        return this.dvdRepository.findById(id).get();
    }

    public void editDVDById(long id, DiscEditForm discEditForm){
        DVD dvd = this.dvdRepository.findById(id).get();
        dvd.setTitle(discEditForm.getTitle());
        dvd.setAuthor(discEditForm.getAuthor());
        dvd.setGenre(discEditForm.getGenre());
        dvd.setPublicationYear(discEditForm.getPublicationYear());
        dvd.setCopies(discEditForm.getCopies());
        this.dvdRepository.save(dvd);
    }

    public List<Book> bookSearch(String title, String author, String genre, int publicationYear){
        return this.bookRepository.findAllByTitleAndAuthorAndGenreAndPublicationYear(title,author,genre,publicationYear);
    }

    public List<CD> cdSearch(String title, String author, String genre, int publicationYear){
        return this.cdRepository.findAllByTitleAndAuthorAndGenreAndPublicationYear(title,author,genre,publicationYear);
    }

    public List<DVD> dvdSearch(String title, String author, String genre, int publicationYear){
        return this.dvdRepository.findAllByTitleAndAuthorAndGenreAndPublicationYear(title,author,genre,publicationYear);
    }

    public Document findDocumentById(long id){
        return this.documentRepository.findById(id).get();
    }

    public Client findClientByIdWithBorrowingHistory(long id){
        Client client = this.clientRepository.findById(id).get();

        return client;
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

    public DocumentLoan findDocumentLoanById(long id){
        return this.documentLoanRepository.findById(id).get();
    }

    public void returnDocument(long documentLoanId){
        DocumentLoan documentLoan = this.documentLoanRepository.findById(documentLoanId).get();
        Document document = documentLoan.getDocument();
        document.setCopies(document.getCopies() + 1);
        documentLoan.setActualReturnDate(LocalDate.now());
        this.documentLoanRepository.save(documentLoan);
        this.documentRepository.save(document);
    }

    public boolean clientExistsById(long id){
        return this.clientRepository.existsById(id);
    }

    public boolean documentExistsById(long id){
        return this.documentRepository.existsById(id);
    }
}
