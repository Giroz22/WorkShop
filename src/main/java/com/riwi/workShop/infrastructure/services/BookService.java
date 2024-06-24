package com.riwi.workShop.infrastructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.workShop.api.dto.request.BookRequest;
import com.riwi.workShop.api.dto.request.BookUpdateRequest;
import com.riwi.workShop.api.dto.response.BookResponse;
import com.riwi.workShop.api.dto.response.ReservationToBookResponse;
import com.riwi.workShop.domain.entitties.Book;
import com.riwi.workShop.domain.entitties.Reservation;
import com.riwi.workShop.domain.repositories.BookRepository;

import lombok.AllArgsConstructor;
import com.riwi.workShop.infrastructure.abstract_services.IBookService;
import com.riwi.workShop.infrastructure.helpers.mappers.BookMapper;
import com.riwi.workShop.infrastructure.helpers.mappers.ReservationMapper;
import com.riwi.workShop.util.exceptions.IdNotFoundException;

@Service
@AllArgsConstructor
public class BookService implements IBookService {

    @Autowired
    private BookRepository  bookRepository;

    @Autowired
    private BookMapper bookMapper;

    private ReservationMapper reservationMapper;

    @Override
    public Page<BookResponse> getAll(int page, int size) {
        if(page<0) page  = 0;
        
        PageRequest pagination =  PageRequest.of(page, size);

        return this.bookRepository.findAll(pagination).map( book -> this.bookMapper.ToResponse(book));
    }

    @Override
    public BookResponse getById(Long id) {
        Book book =  this.find(id);

        return this.bookMapper.ToResponse(book);
    }

    @Override
    public BookResponse create(BookRequest request) {
        Book book = this.bookMapper.ToEntity(request);

        Book saved = this.bookRepository.save(book);

        return this.bookMapper.ToResponse(saved);
    }

    @Override
    public BookResponse update(Long id, BookUpdateRequest request) {
        Book book = find(id);
        Book bookUpdate = this.bookMapper.ToEntity(request);

        bookUpdate.setId(book.getId());

        Book bookUpdated = this.bookRepository.save(bookUpdate);

        System.out.println(bookUpdate.toString());

        return this.bookMapper.ToResponse(bookUpdated);
    }

    @Override
    public void delete(Long id) {
        Book book =  this.find(id);

        this.bookRepository.delete(book);
    }
    
    private Book find(Long id){
        return this.bookRepository.findById(id).orElseThrow( ()-> new IdNotFoundException("Book"));
    }

    public List<ReservationToBookResponse> getAllReservation(Long id){
        Book book = this.find(id);

        List<Reservation> reservations =  book.getReservations();

        List<ReservationToBookResponse> reservationsToBookResponse = this.reservationMapper.ToEntityToBookResponseList(reservations);

        return reservationsToBookResponse;
    }
}
