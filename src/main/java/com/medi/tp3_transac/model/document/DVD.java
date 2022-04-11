package com.medi.tp3_transac.model.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("DVD")
public class DVD extends Document{
    public final static int BORROW_TIME_IN_WEEK = 2;

    public DVD(String title, String author, String genre, int publicationYear) {
        super(title, author, genre, publicationYear);
    }
}
