package com.riwi.workShop.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.workShop.api.dto.request.ReservationRequest;
import com.riwi.workShop.api.dto.request.ReservationUpdateRequest;
import com.riwi.workShop.api.dto.response.ReservationResponse;
import com.riwi.workShop.infrastructure.services.ReservationService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "/reservations")
@AllArgsConstructor
public class ReservationController {

    @Autowired
    private ReservationService ReservationService;

    @GetMapping("")
    public ResponseEntity<Page<ReservationResponse>> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {
        return ResponseEntity.ok().body(this.ReservationService.getAll(page-1, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.ReservationService.getById(id));
    }
    
    @PostMapping("")
    public ResponseEntity<ReservationResponse> create(@RequestBody ReservationRequest request) {
        return ResponseEntity.ok().body(this.ReservationService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationResponse> create(@PathVariable Long id, @RequestBody ReservationUpdateRequest request) {
        return ResponseEntity.ok().body(this.ReservationService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id){
        this.ReservationService.delete(id);

        return ResponseEntity.noContent().build();
    }
    
}
