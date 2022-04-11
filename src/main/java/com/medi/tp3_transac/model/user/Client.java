package com.medi.tp3_transac.model.user;

import com.medi.tp3_transac.model.DocumentLoan;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Client extends User {

    @OneToMany(mappedBy = "client")
    private List<DocumentLoan> documentLoans;
}
