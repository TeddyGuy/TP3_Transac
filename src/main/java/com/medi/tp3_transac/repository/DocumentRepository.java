package com.medi.tp3_transac.repository;

import com.medi.tp3_transac.model.document.Book;
import com.medi.tp3_transac.model.document.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
