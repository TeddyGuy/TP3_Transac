package com.medi.tp3_transac.repository;

import com.medi.tp3_transac.model.document.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    @Query("select d " +
            "from Document d " +
            "where LOWER(d.title) like %:titleSearch% " +
            "and d.author like %:authorSearch% " +
            "and d.genre like %:genreSearch% " +
            "and d.publicationYear = :publicationYearSearch")
    List<Document> findByTitleAndAuthorAndGenreAndPublicationYear(@Param("titleSearch") String titleSearch,
                                                                  @Param("authorSearch") String author,
                                                                  @Param("genreSearch") String genre,
                                                                  @Param("publicationYearSearch") int publicationYear);
}
