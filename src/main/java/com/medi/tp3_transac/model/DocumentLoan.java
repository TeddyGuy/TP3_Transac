package com.medi.tp3_transac.model;

import com.medi.tp3_transac.model.document.Document;
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
    //@ManyToOne
    //@JoinColumn(name = "client_id")
    //@ToString.Exclude
    //private Client client;
}
