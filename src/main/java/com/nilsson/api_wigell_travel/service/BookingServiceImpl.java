package com.nilsson.api_wigell_travel.service;

import com.nilsson.api_wigell_travel.dto.BookingCreateDto;
import com.nilsson.api_wigell_travel.dto.BookingDto;
import com.nilsson.api_wigell_travel.dto.BookingPatchUpdateDto;
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

        return null;
    }

    @Override
    public void patchUpdate(Long bookingId, BookingPatchUpdateDto dto) {

    }

    @Override
    public List<BookingDto> getCustomersBooking(Long customerId) {
        return List.of();
    }
}
