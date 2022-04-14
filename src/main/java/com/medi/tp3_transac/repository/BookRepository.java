package com.medi.tp3_transac.repository;

import com.medi.tp3_transac.model.document.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select b " +
            "from Book b " +
            "where LOWER(b.title) like lower(concat('%', :titleSearch,'%')) " +
            "and LOWER(b.author) like lower(concat('%', :authorSearch,'%')) " +
            "and LOWER(b.genre)like lower(concat('%', :genreSearch,'%')) " +
            "and b.publicationYear = :publicationYearSearch")
    List<Book> findAllByTitleAndAuthorAndGenreAndPublicationYear(@Param("titleSearch") String titleSearch,
                                                                 @Param("authorSearch") String authorSearch,
                                                                 @Param("genreSearch") String genreSearch,
                                                                 @Param("publicationYearSearch") int publicationYearSearch);
}
