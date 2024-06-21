package com.riwi.workShop.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.workShop.api.dto.request.LoanRequest;
import com.riwi.workShop.api.dto.request.LoanUpdateRequest;
import com.riwi.workShop.api.dto.response.LoanResponse;
import com.riwi.workShop.infrastructure.services.LoanService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "/loans")
@AllArgsConstructor
public class LoanController {

    @Autowired
    private LoanService LoanService;

    @GetMapping("")
    public ResponseEntity<Page<LoanResponse>> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {
        return ResponseEntity.ok().body(this.LoanService.getAll(page-1, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.LoanService.getById(id));
    }
    
    @PostMapping("")
    public ResponseEntity<LoanResponse> create(@RequestBody LoanRequest request) {
        return ResponseEntity.ok().body(this.LoanService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanResponse> create(@PathVariable Long id, @RequestBody LoanUpdateRequest request) {
        return ResponseEntity.ok().body(this.LoanService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id){
        this.LoanService.delete(id);

        return ResponseEntity.noContent().build();
    }
    
}
