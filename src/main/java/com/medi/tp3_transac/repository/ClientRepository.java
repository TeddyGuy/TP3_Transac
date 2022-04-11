package com.medi.tp3_transac.repository;

import com.medi.tp3_transac.model.user.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
