package com.medi.tp3_transac.repository;

import com.medi.tp3_transac.model.document.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
