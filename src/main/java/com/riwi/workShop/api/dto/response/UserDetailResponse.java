package com.riwi.workShop.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDetailResponse {
    private String id;
    private String username;
    private String email;
    private String fullName;
    private String role;
    private List<LoanToUserResponse> loans;
    private List<ReservationToUserResponse> reservations;
}
