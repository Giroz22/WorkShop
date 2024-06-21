package com.riwi.workShop.infrastructure.abstract_services;

import com.riwi.workShop.api.dto.request.ReservationRequest;
import com.riwi.workShop.api.dto.request.ReservationUpdateRequest;
import com.riwi.workShop.api.dto.response.ReservationResponse;

public interface IReservationService extends IBaseService<ReservationRequest, ReservationUpdateRequest, ReservationResponse, Long>{
    
    
}
