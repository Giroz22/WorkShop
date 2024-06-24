package com.riwi.workShop.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoanToUserResponse {
    private String loanDate;
    private String returnDate;
    private String status;
    private BookResponse book;
}
