package com.medi.tp3_transac.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentLoanForm {
    private long documentId;
    private long clientId;
}
