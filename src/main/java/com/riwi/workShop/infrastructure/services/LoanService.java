package com.riwi.workShop.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.workShop.api.dto.request.LoanRequest;
import com.riwi.workShop.api.dto.request.LoanUpdateRequest;
import com.riwi.workShop.api.dto.response.LoanResponse;
import com.riwi.workShop.domain.entitties.Loan;
import com.riwi.workShop.domain.repositories.LoanRepository;

import lombok.AllArgsConstructor;
import com.riwi.workShop.infrastructure.abstract_services.ILoanService;
import com.riwi.workShop.infrastructure.helpers.mappers.LoanMapper;
import com.riwi.workShop.util.exceptions.IdNotFoundException;

@Service
@AllArgsConstructor
public class LoanService implements ILoanService {

    @Autowired
    private LoanRepository  LoanRepository;

    @Autowired
    private LoanMapper LoanMapper;

    @Override
    public Page<LoanResponse> getAll(int page, int size) {
        if(page<0) page  = 0;
        
        PageRequest pagination =  PageRequest.of(page, size);

        return this.LoanRepository.findAll(pagination).map( Loan -> this.LoanMapper.ToResponse(Loan));
    }

    @Override
    public LoanResponse getById(Long id) {
        Loan Loan =  this.find(id);

        return this.LoanMapper.ToResponse(Loan);
    }

    @Override
    public LoanResponse create(LoanRequest request) {
        Loan Loan = this.LoanMapper.ToEntity(request);

        Loan saved = this.LoanRepository.save(Loan);

        return this.LoanMapper.ToResponse(saved);
    }

    @Override
    public LoanResponse update(Long id, LoanUpdateRequest request) {
        Loan Loan = find(id);
        Loan LoanUpdate = this.LoanMapper.ToEntity(request);

        LoanUpdate.setId(Loan.getId());

        Loan LoanUpdated = this.LoanRepository.save(LoanUpdate);

        System.out.println(LoanUpdate.toString());

        return this.LoanMapper.ToResponse(LoanUpdated);
    }

    @Override
    public void delete(Long id) {
        Loan Loan =  this.find(id);

        this.LoanRepository.delete(Loan);
    }
    
    private Loan find(Long id){
        return this.LoanRepository.findById(id).orElseThrow( ()-> new IdNotFoundException("Loan"));
    }
}
