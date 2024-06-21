package com.riwi.workShop.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoanRequest {
    private String userId;
    private String bookId;
    private String loanDate;
    private String returnDate;
}
