package com.riwi.workShop.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.workShop.api.dto.request.ReservationRequest;
import com.riwi.workShop.api.dto.request.ReservationUpdateRequest;
import com.riwi.workShop.api.dto.response.ReservationResponse;
import com.riwi.workShop.domain.entitties.Reservation;
import com.riwi.workShop.domain.repositories.ReservationRepository;

import lombok.AllArgsConstructor;
import com.riwi.workShop.infrastructure.abstract_services.IReservationService;
import com.riwi.workShop.infrastructure.helpers.mappers.ReservationMapper;
import com.riwi.workShop.util.exceptions.IdNotFoundException;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    @Autowired
    private ReservationRepository  ReservationRepository;

    @Autowired
    private ReservationMapper ReservationMapper;

    @Override
    public Page<ReservationResponse> getAll(int page, int size) {
        if(page<0) page  = 0;
        
        PageRequest pagination =  PageRequest.of(page, size);

        return this.ReservationRepository.findAll(pagination).map( Reservation -> this.ReservationMapper.ToResponse(Reservation));
    }

    @Override
    public ReservationResponse getById(Long id) {
        Reservation Reservation =  this.find(id);

        return this.ReservationMapper.ToResponse(Reservation);
    }

    @Override
    public ReservationResponse create(ReservationRequest request) {
        Reservation Reservation = this.ReservationMapper.ToEntity(request);

        Reservation saved = this.ReservationRepository.save(Reservation);

        return this.ReservationMapper.ToResponse(saved);
    }

    @Override
    public ReservationResponse update(Long id, ReservationUpdateRequest request) {
        Reservation Reservation = find(id);
        Reservation ReservationUpdate = this.ReservationMapper.ToEntity(request);

        ReservationUpdate.setId(Reservation.getId());

        Reservation ReservationUpdated = this.ReservationRepository.save(ReservationUpdate);

        System.out.println(ReservationUpdate.toString());

        return this.ReservationMapper.ToResponse(ReservationUpdated);
    }

    @Override
    public void delete(Long id) {
        Reservation Reservation =  this.find(id);

        this.ReservationRepository.delete(Reservation);
    }
    
    private Reservation find(Long id){
        return this.ReservationRepository.findById(id).orElseThrow( ()-> new IdNotFoundException("Reservation"));
    }
}
