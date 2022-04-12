package com.medi.tp3_transac.model.user;

import com.medi.tp3_transac.model.DocumentLoan;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Client extends User {
    private String email;
    @OneToMany(mappedBy = "client")
    private List<DocumentLoan> documentLoans = new ArrayList<>();

    public Client(String username, String password, String email) {
        super(username, password);
        this.email = email;
    }
}
