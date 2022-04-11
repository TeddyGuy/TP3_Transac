package com.medi.tp3_transac.model.document;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Book")
public class Book extends Document{
    public final static int BORROW_TIME_IN_WEEKS = 3;
    private String publisher;
    private int pages;
}
