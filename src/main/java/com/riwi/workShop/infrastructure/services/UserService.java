package com.riwi.workShop.infrastructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.workShop.api.dto.request.UserRequest;
import com.riwi.workShop.api.dto.request.UserUpdateRequest;
import com.riwi.workShop.api.dto.response.ReservationToUserResponse;
import com.riwi.workShop.api.dto.response.UserDetailResponse;
import com.riwi.workShop.api.dto.response.UserResponse;
import com.riwi.workShop.domain.entitties.Reservation;
import com.riwi.workShop.domain.entitties.User;
import com.riwi.workShop.domain.repositories.UserRepository;

import lombok.AllArgsConstructor;
import com.riwi.workShop.infrastructure.abstract_services.IUserService;
import com.riwi.workShop.infrastructure.helpers.mappers.ReservationMapper;
import com.riwi.workShop.infrastructure.helpers.mappers.UserMapper;
import com.riwi.workShop.util.exceptions.IdNotFoundException;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private UserRepository  UserRepository;

    @Autowired
    private UserMapper UserMapper;

    @Autowired
    private ReservationMapper reservationMapper;


    public Page<UserResponse> getAll(int page, int size) {
        if(page<0) page  = 0;
        
        PageRequest pagination =  PageRequest.of(page, size);

        return this.UserRepository.findAll(pagination).map( User -> this.UserMapper.ToResponse(User));
    }

    
    public UserDetailResponse getById(Long id) {
        User User =  this.find(id);

        return this.UserMapper.ToDetailResponse(User);
    }

    public UserResponse create(UserRequest request) {
        User User = this.UserMapper.ToEntity(request);

        User saved = this.UserRepository.save(User);

        return this.UserMapper.ToResponse(saved);
    }

    
    public UserResponse update(Long id, UserUpdateRequest request) {
        User User = find(id);
        User UserUpdate = this.UserMapper.ToEntity(request);

        UserUpdate.setId(User.getId());

        User UserUpdated = this.UserRepository.save(UserUpdate);

        System.out.println(UserUpdate.toString());

        return this.UserMapper.ToResponse(UserUpdated);
    }

    
    public void delete(Long id) {
        User User =  this.find(id);

        this.UserRepository.delete(User);
    }
    
    private User find(Long id){
        return this.UserRepository.findById(id).orElseThrow( ()-> new IdNotFoundException("User"));
    }

    public List<ReservationToUserResponse> getAllReservations(Long id){
        User user = this.find(id);
        
        List<Reservation> reservations = user.getReservations();

        List<ReservationToUserResponse> reservationsResponse = this.reservationMapper.ToEntityToUserResponseList(reservations);
        
        return reservationsResponse;
    }
}
