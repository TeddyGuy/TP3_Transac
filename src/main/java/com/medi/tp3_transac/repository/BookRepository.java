package com.medi.tp3_transac.repository;

import com.medi.tp3_transac.model.document.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
