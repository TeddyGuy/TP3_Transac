package com.medi.tp3_transac.model;

import com.medi.tp3_transac.model.document.Book;
import com.medi.tp3_transac.model.document.CD;
import com.medi.tp3_transac.model.document.DVD;
import com.medi.tp3_transac.model.document.Document;
import com.medi.tp3_transac.model.user.Client;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor

public class DocumentLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "document_id")
    @ToString.Exclude
    private Document document;
    private LocalDate lendingDate;
    private LocalDate expectedReturnDate;
    private LocalDate actualReturnDate;
    @ManyToOne
    @JoinColumn(name = "client_id")
    @ToString.Exclude
    private Client client;

    public DocumentLoan(Document document, Client client) {
        this.document = document;
        this.client = client;
        this.lendingDate = LocalDate.now();
        if (document instanceof Book){
            this.expectedReturnDate = lendingDate.plusWeeks(Book.BORROW_TIME_IN_WEEKS);
        }
        else if (document instanceof DVD){
            this.expectedReturnDate = lendingDate.plusWeeks(DVD.BORROW_TIME_IN_WEEK);
        }
        else {
            this.expectedReturnDate = lendingDate.plusWeeks(CD.BORROW_TIME_IN_WEEK);
        }
    }
}
