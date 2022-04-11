package com.medi.tp3_transac.service;

import com.medi.tp3_transac.model.document.Book;
import com.medi.tp3_transac.model.document.CD;
import com.medi.tp3_transac.model.document.DVD;
import com.medi.tp3_transac.repository.ClientRepository;
import com.medi.tp3_transac.repository.DocumentLoanRepository;
import com.medi.tp3_transac.repository.DocumentRepository;
import org.springframework.stereotype.Component;

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
}
