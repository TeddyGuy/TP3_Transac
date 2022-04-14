package com.medi.tp3_transac.repository;
import com.medi.tp3_transac.model.document.DVD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DVDRepository extends JpaRepository<DVD, Long> {
    @Query("select dvd " +
            "from DVD dvd " +
            "where LOWER(dvd.title) like lower(concat('%', :titleSearch,'%')) " +
            "and LOWER(dvd.author) like lower(concat('%', :authorSearch,'%')) " +
            "and LOWER(dvd.genre)like lower(concat('%', :genreSearch,'%')) " +
            "and dvd.publicationYear = :publicationYearSearch")
    List<DVD> findAllByTitleAndAuthorAndGenreAndPublicationYear(@Param("titleSearch") String titleSearch,
                                                                @Param("authorSearch") String author,
                                                                @Param("genreSearch") String genre,
                                                                @Param("publicationYearSearch") int publicationYear);
}
