package com.riwi.workShop.infrastructure.helpers.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import com.riwi.workShop.api.dto.request.ReservationRequest;
import com.riwi.workShop.api.dto.request.ReservationUpdateRequest;
import com.riwi.workShop.api.dto.response.ReservationResponse;
import com.riwi.workShop.api.dto.response.ReservationToBookResponse;
import com.riwi.workShop.api.dto.response.ReservationToUserResponse;
import com.riwi.workShop.domain.entitties.Book;
import com.riwi.workShop.domain.entitties.Reservation;
import com.riwi.workShop.domain.entitties.User;
import com.riwi.workShop.domain.repositories.BookRepository;
import com.riwi.workShop.domain.repositories.UserRepository;
import com.riwi.workShop.util.enums.ReservationStatus;
import com.riwi.workShop.util.exceptions.IdNotFoundException;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ReservationMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;
    
    public abstract ReservationResponse ToResponse(Reservation entity);
    
    
    public Reservation ToEntity(ReservationRequest request){
        Reservation reservation = this.ToBasicEntity(request);

        User user = this.userRepository.findById(request.getUserId()).orElseThrow( ()-> new IdNotFoundException("User"));
        reservation.setUser( user );

        Book book = this.bookRepository.findById(request.getBookId()).orElseThrow(()-> new IdNotFoundException("Book"));
        reservation.setBook(book);

        reservation.setStatus(ReservationStatus.pending);

        return reservation;
    }

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(
            source = "reservationDate", target = "reservationDate",
            dateFormat = "dd-MM-yyy")
    })
    public abstract Reservation ToEntity(ReservationUpdateRequest request);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(
            source = "reservationDate", target = "reservationDate",
            dateFormat = "dd-MM-yyy")
    })
    public abstract Reservation ToBasicEntity(ReservationRequest request);

    public abstract List<ReservationToUserResponse> ToEntityToUserResponseList(List<Reservation> reservations);
    
    public abstract List<ReservationToBookResponse> ToEntityToBookResponseList(List<Reservation> reservations);
    
}
