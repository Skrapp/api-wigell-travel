package com.nilsson.api_wigell_travel.service;

import com.nilsson.api_wigell_travel.dto.BookingCreateDto;
import com.nilsson.api_wigell_travel.dto.BookingDto;
import com.nilsson.api_wigell_travel.dto.BookingPatchUpdateDto;
import com.nilsson.api_wigell_travel.entity.Booking;
import com.nilsson.api_wigell_travel.entity.Customer;
import com.nilsson.api_wigell_travel.entity.Destination;
import com.nilsson.api_wigell_travel.exception.BookingNotFoundException;
import com.nilsson.api_wigell_travel.exception.CustomerNotFoundException;
import com.nilsson.api_wigell_travel.exception.DestinationNotFoundException;
import com.nilsson.api_wigell_travel.mapper.BookingMapper;
import com.nilsson.api_wigell_travel.repo.BookingRepo;
import com.nilsson.api_wigell_travel.repo.CustomerRepo;
import com.nilsson.api_wigell_travel.repo.DestinationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{
    private final BookingRepo bookingRepo;
    private final CustomerRepo customerRepo;
    private final DestinationRepo destinationRepo;

    public BookingServiceImpl(BookingRepo bookingRepo, CustomerRepo customerRepo, DestinationRepo destinationRepo) {
        this.bookingRepo = bookingRepo;
        this.customerRepo = customerRepo;
        this.destinationRepo = destinationRepo;
    }

    @Override
    public BookingDto create(BookingCreateDto dto) {
        Destination destination = destinationRepo.findById(dto.destinationId())
                .orElseThrow(() -> new DestinationNotFoundException(dto.destinationId()));

        //TODO Ändra till customer kopplad till currentUser?
        //var currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Customer customer = customerRepo.findById(dto.customerId())
                .orElseThrow(() -> new CustomerNotFoundException(dto.customerId()));



        Booking saved = bookingRepo.save(BookingMapper.fromCreate(dto, customer, destination));
        return BookingMapper.toDto(saved);
    }

    @Override
    public BookingDto patchUpdate(Long bookingId, BookingPatchUpdateDto dto) {
        if(dto.numberOfWeeks() != null && dto.numberOfWeeks() <= 0)
            throw new IllegalArgumentException("Antal veckor kan inte vara 0 eller lägre");

        Destination destination = null;
        if(dto.destinationId() != null && dto.destinationId() > 0) {
            destination = destinationRepo.findById(dto.destinationId())
                    .orElseThrow(() -> new DestinationNotFoundException(dto.destinationId()));
        }

        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException(bookingId));

        BookingMapper.applyPatchUpdate(booking, dto, destination);

        Booking saved = bookingRepo.save(booking);
        return BookingMapper.toDto(saved);
    }

    @Override
    public List<BookingDto> getCustomersBooking(Long customerId) {
        if(!customerRepo.existsById(customerId))
            throw new CustomerNotFoundException(customerId);

        List<Booking> bookings = bookingRepo.findAllByCustomer_Id(customerId);
        return bookings.stream()
                .map(BookingMapper::toDto)
                .toList();
    }
}
