package com.medi.tp3_transac.dto;

import com.medi.tp3_transac.model.user.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientForm {
    private String username;
    private String password;
    private String email;

    public Client toClient(){
        return new Client(this.username,this.password,this.email);
    }
}
