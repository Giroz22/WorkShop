package com.riwi.workShop.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.workShop.domain.entitties.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    
}
