package com.riwi.workShop.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReservationToBookResponse {
    private String reservationDate;
    private String status;
    private UserResponse user;
}
