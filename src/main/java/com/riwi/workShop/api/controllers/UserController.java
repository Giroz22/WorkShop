package com.riwi.workShop.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.workShop.api.dto.request.UserRequest;
import com.riwi.workShop.api.dto.request.UserUpdateRequest;
import com.riwi.workShop.api.dto.response.UserResponse;
import com.riwi.workShop.infrastructure.services.UserService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService UserService;

    @GetMapping("")
    public ResponseEntity<Page<UserResponse>> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {
        return ResponseEntity.ok().body(this.UserService.getAll(page-1, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.UserService.getById(id));
    }
    
    @PostMapping("")
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        return ResponseEntity.ok().body(this.UserService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> create(@PathVariable Long id, @RequestBody UserUpdateRequest request) {
        return ResponseEntity.ok().body(this.UserService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id){
        this.UserService.delete(id);

        return ResponseEntity.noContent().build();
    }
    
}
