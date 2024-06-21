package com.riwi.workShop.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.workShop.domain.entitties.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
