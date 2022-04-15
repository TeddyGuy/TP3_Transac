package com.medi.tp3_transac.dto;
import com.medi.tp3_transac.model.document.CD;
import com.medi.tp3_transac.model.document.DVD;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscEditForm {
    String title;
    String author;
    String genre;
    int publicationYear;
    int copies;

    public DiscEditForm(CD cd){
        this.title = cd.getTitle();
        this.author = cd.getAuthor();
        this.genre = cd.getGenre();
        this.publicationYear = cd.getPublicationYear();
        this.copies = cd.getCopies();
    }

    public DiscEditForm(DVD dvd){
        this.title = dvd.getTitle();
        this.author = dvd.getAuthor();
        this.genre = dvd.getGenre();
        this.publicationYear = dvd.getPublicationYear();
        this.copies = dvd.getCopies();
    }

}
