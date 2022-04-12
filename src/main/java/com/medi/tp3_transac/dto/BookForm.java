package com.medi.tp3_transac.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookForm {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private String publisher;
    private int pages;
}
