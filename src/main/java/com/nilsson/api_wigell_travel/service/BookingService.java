package com.nilsson.api_wigell_travel.service;

import com.nilsson.api_wigell_travel.dto.BookingCreateDto;
import com.nilsson.api_wigell_travel.dto.BookingDto;
import com.nilsson.api_wigell_travel.dto.BookingPatchUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    BookingDto create(BookingCreateDto dto);
    BookingDto patchUpdate(Long bookingId, BookingPatchUpdateDto dto);
    List<BookingDto> getCustomersBooking(Long customerId);
}
