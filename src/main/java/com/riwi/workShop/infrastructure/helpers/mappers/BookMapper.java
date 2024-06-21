package com.riwi.workShop.infrastructure.helpers.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.riwi.workShop.api.dto.request.BookRequest;
import com.riwi.workShop.api.dto.request.BookUpdateRequest;
import com.riwi.workShop.api.dto.response.BookResponse;
import com.riwi.workShop.domain.entitties.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    
    BookResponse ToResponse(Book entity);
    
    @InheritInverseConfiguration
    Book ToEntity(BookRequest request);

    @InheritInverseConfiguration
    Book ToEntity(BookUpdateRequest request);
    
}
