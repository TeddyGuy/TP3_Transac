package com.medi.tp3_transac.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentSearchForm {
    String title;
    String author;
    String genre;
    int publicationYear;
}
