package com.medi.tp3_transac.dto;

import com.medi.tp3_transac.model.document.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEditForm {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private String publisher;
    private int pages;
    private int copies;

    public BookEditForm(Book book){
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.genre = book.getGenre();
        this.publicationYear = book.getPublicationYear();
        this.publisher = book.getPublisher();
        this.pages = book.getPages();
        this.copies = book.getCopies();
    }
}
