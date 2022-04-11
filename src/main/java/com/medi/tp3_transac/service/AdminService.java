package com.medi.tp3_transac.service;

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
}
