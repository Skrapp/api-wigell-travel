package com.nilsson.api_wigell_travel.mapper;

import com.nilsson.api_wigell_travel.dto.BookingCreateDto;
import com.nilsson.api_wigell_travel.dto.BookingDto;
import com.nilsson.api_wigell_travel.dto.BookingPatchUpdateDto;
import com.nilsson.api_wigell_travel.entity.Booking;

import java.time.LocalDate;

public final class BookingMapper {
    private BookingMapper() {
    }

    public static Booking fromCreate(BookingCreateDto dto, Long customerId, double weeklyRate) {
        LocalDate returnDate = dto.departureDate().plusWeeks(dto.numberOfWeeks());
        double totalPrice = weeklyRate * dto.numberOfWeeks();
        
        return new Booking(
                customerId,
                dto.destinationId(),
                dto.hotelName(),
                dto.departureDate(),
                returnDate,
                totalPrice
        );
    }

    public static BookingDto toDto(Booking booking) {
        return new BookingDto(
                booking.getDestinationId(),
                booking.getHotelName(),
                booking.getDepartureDate(),
                booking.getReturnDate(),
                booking.getTotalPrice()
        );
    }

    public static void applyPatchUpdate(Booking booking, BookingPatchUpdateDto dto, double weeklyRate) {
        if (dto.destinationId() != null) {
            booking.setDestinationId(dto.destinationId());
        }
        if (dto.hotelName() != null) {
            booking.setHotelName(dto.hotelName());
        }
        if (dto.numberOfWeeks() != null && dto.numberOfWeeks() > 0) {
            LocalDate newReturnDate = booking.getDepartureDate().plusWeeks(dto.numberOfWeeks());
            booking.setReturnDate(newReturnDate);
            
            double newTotalPrice = weeklyRate * dto.numberOfWeeks();
            booking.setTotalPrice(newTotalPrice);
        }
    }
}
