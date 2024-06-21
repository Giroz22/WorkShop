package com.riwi.workShop.infrastructure.abstract_services;

import com.riwi.workShop.api.dto.request.BookRequest;
import com.riwi.workShop.api.dto.request.BookUpdateRequest;
import com.riwi.workShop.api.dto.response.BookResponse;

public interface IBookService extends IBaseService<BookRequest, BookUpdateRequest, BookResponse, Long>{
    
}
