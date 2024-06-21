package com.riwi.workShop.infrastructure.helpers.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.riwi.workShop.api.dto.request.LoanRequest;
import com.riwi.workShop.api.dto.request.LoanUpdateRequest;
import com.riwi.workShop.api.dto.response.LoanResponse;
import com.riwi.workShop.domain.entitties.Loan;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanMapper {
    
    LoanResponse ToResponse(Loan entity);
    
    @InheritInverseConfiguration
    Loan ToEntity(LoanRequest request);

    @InheritInverseConfiguration
    Loan ToEntity(LoanUpdateRequest request);
    
}
