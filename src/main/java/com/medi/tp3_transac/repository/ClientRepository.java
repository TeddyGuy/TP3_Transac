package com.medi.tp3_transac.repository;

import com.medi.tp3_transac.model.user.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("select c from Client c LEFT JOIN FETCH c.documentLoans dl where c.id = :clientId")
    Optional<Client> findByIdWithDocumentLoans(@Param("clientId") long clientId);
}
