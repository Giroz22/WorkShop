package com.riwi.workShop.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.workShop.domain.entitties.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{
    
}
