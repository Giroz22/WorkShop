package com.riwi.workShop.infrastructure.helpers.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.riwi.workShop.api.dto.request.ReservationRequest;
import com.riwi.workShop.api.dto.request.ReservationUpdateRequest;
import com.riwi.workShop.api.dto.response.ReservationResponse;
import com.riwi.workShop.domain.entitties.Reservation;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {
    
    ReservationResponse ToResponse(Reservation entity);
    
    @InheritInverseConfiguration
    Reservation ToEntity(ReservationRequest request);

    @InheritInverseConfiguration
    Reservation ToEntity(ReservationUpdateRequest request);
    
}
