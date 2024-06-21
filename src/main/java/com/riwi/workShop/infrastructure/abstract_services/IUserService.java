package com.riwi.workShop.infrastructure.abstract_services;

import com.riwi.workShop.api.dto.request.UserRequest;
import com.riwi.workShop.api.dto.request.UserUpdateRequest;
import com.riwi.workShop.api.dto.response.UserResponse;

public interface IUserService extends IBaseService<UserRequest, UserUpdateRequest, UserResponse, Long>{
    
}
