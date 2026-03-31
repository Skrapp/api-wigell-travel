package com.nilsson.api_wigell_travel.service;

import com.nilsson.api_wigell_travel.dto.BookingCreateDto;
import com.nilsson.api_wigell_travel.dto.BookingDto;
import com.nilsson.api_wigell_travel.dto.BookingPatchUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    /*
    User
        • Boka resa POST /api/v1/bookings
        • Boka om resa PATCH /api/v1/bookings/{bookingId} (tillåtna fält: reslängd (veckor),
        destination, hotell)
        • Se tidigare och aktiva bokningar GET /api/v1/bookings?customerId={customerId}
     */

    BookingDto create(BookingCreateDto dto);
    void patchUpdate(Long bookingId, BookingPatchUpdateDto dto);
    List<BookingDto> getCustomersBooking(Long customerId);
}
