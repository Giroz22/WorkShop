package com.riwi.workShop.api.controllers;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.workShop.api.dto.request.UserRequest;
import com.riwi.workShop.api.dto.request.UserUpdateRequest;
import com.riwi.workShop.api.dto.response.ReservationToUserResponse;
import com.riwi.workShop.api.dto.response.UserDetailResponse;
import com.riwi.workShop.api.dto.response.UserResponse;
import com.riwi.workShop.infrastructure.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService UserService;

    // @GetMapping("")
    // public ResponseEntity<Page<UserResponse>> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {
    //     return ResponseEntity.ok().body(this.UserService.getAll(page-1, size));
    // }

    @GetMapping("/{id}")
    @Operation(
        summary = "Find user by ID",
        responses = {
            @ApiResponse(description = "The user", content = @Content(
                schema = @Schema(implementation = UserResponse.class)
            )),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied")
        }    
    )
    public ResponseEntity<UserDetailResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.UserService.getById(id));
    }
    
    @Operation(
        summary = "Create user",
        responses = {
            @ApiResponse(description = "The user", content = @Content(
                schema = @Schema(implementation = User.class)
            )),
            @ApiResponse(responseCode = "400", description = "Invalid username, password, email, fullName")
        }    
    )
    @PostMapping("")
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        return ResponseEntity.ok().body(this.UserService.create(request));
    }

    @Operation(
        summary = "Update user",
        responses = {
            @ApiResponse(description = "The user", content = @Content(
                schema = @Schema(implementation = User.class)
            )),
            @ApiResponse(responseCode = "400", description = "Invalid username, password, email, fullName"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied")
        }    
    )
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id, @RequestBody UserUpdateRequest request) {
        return ResponseEntity.ok().body(this.UserService.update(id, request));
    }

    @Operation(
        summary = "Delete user by ID",
        responses = {
            @ApiResponse(description = "The user", content = @Content(
                schema = @Schema(implementation = User.class)
            )),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied")
        }    
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id){
        this.UserService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @Operation(
        summary = "Get all the reservations of a usuario",
        responses = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied")
        }
    )
    @GetMapping("/{id}/reservations")
    public ResponseEntity<List<ReservationToUserResponse>> getAllReservations(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.UserService.getAllReservations(id));
    }
    
    
}
