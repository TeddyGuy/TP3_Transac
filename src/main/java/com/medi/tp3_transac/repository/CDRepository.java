package com.medi.tp3_transac.repository;

import com.medi.tp3_transac.model.document.CD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CDRepository extends JpaRepository<CD, Long> {
    @Query("select cd " +
            "from CD cd " +
            "where LOWER(cd.title) like lower(concat('%', :titleSearch,'%')) " +
            "and LOWER(cd.author) like lower(concat('%', :authorSearch,'%')) " +
            "and LOWER(cd.genre)like lower(concat('%', :genreSearch,'%')) " +
            "and cd.publicationYear = :publicationYearSearch")
    List<CD> findAllByTitleAndAuthorAndGenreAndPublicationYear(@Param("titleSearch") String titleSearch,
                                                               @Param("authorSearch") String author,
                                                               @Param("genreSearch") String genre,
                                                               @Param("publicationYearSearch") int publicationYear);
}
