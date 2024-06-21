package com.riwi.workShop.infrastructure.abstract_services;

import com.riwi.workShop.api.dto.request.LoanRequest;
import com.riwi.workShop.api.dto.request.LoanUpdateRequest;
import com.riwi.workShop.api.dto.response.LoanResponse;

public interface ILoanService extends IBaseService<LoanRequest, LoanUpdateRequest, LoanResponse, Long>{
    
}
