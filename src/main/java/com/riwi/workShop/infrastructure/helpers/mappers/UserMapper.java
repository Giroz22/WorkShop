package com.riwi.workShop.infrastructure.helpers.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.riwi.workShop.api.dto.request.UserRequest;
import com.riwi.workShop.api.dto.request.UserUpdateRequest;
import com.riwi.workShop.api.dto.response.UserDetailResponse;
import com.riwi.workShop.api.dto.response.UserResponse;
import com.riwi.workShop.domain.entitties.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    
    UserResponse ToResponse(User entity);

    UserDetailResponse ToDetailResponse(User entity);
    
    @InheritInverseConfiguration
    User ToEntity(UserRequest request);

    @InheritInverseConfiguration
    User ToEntity(UserUpdateRequest request);
    
}
