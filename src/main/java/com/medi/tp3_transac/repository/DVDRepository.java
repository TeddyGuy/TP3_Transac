package com.medi.tp3_transac.repository;
import com.medi.tp3_transac.model.document.DVD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DVDRepository extends JpaRepository<DVD, Long> {
}
