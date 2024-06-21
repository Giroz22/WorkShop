package com.riwi.workShop.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.workShop.api.dto.request.BookRequest;
import com.riwi.workShop.api.dto.request.BookUpdateRequest;
import com.riwi.workShop.api.dto.response.BookResponse;
import com.riwi.workShop.infrastructure.services.BookService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "/books")
@AllArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public ResponseEntity<Page<BookResponse>> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {
        return ResponseEntity.ok().body(this.bookService.getAll(page-1, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.bookService.getById(id));
    }
    
    @PostMapping("")
    public ResponseEntity<BookResponse> create(@RequestBody BookRequest request) {
        return ResponseEntity.ok().body(this.bookService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> create(@PathVariable Long id, @RequestBody BookUpdateRequest request) {
        return ResponseEntity.ok().body(this.bookService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id){
        this.bookService.delete(id);

        return ResponseEntity.noContent().build();
    }
    
}
