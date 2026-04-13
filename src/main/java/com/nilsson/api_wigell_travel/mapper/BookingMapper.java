package com.nilsson.api_wigell_travel.mapper;

import com.nilsson.api_wigell_travel.dto.BookingCreateDto;
import com.nilsson.api_wigell_travel.dto.BookingDto;
import com.nilsson.api_wigell_travel.dto.BookingPatchUpdateDto;
import com.nilsson.api_wigell_travel.entity.Booking;
import com.nilsson.api_wigell_travel.entity.Customer;
import com.nilsson.api_wigell_travel.entity.Destination;

import java.time.LocalDate;

public final class BookingMapper {
    private BookingMapper() {
    }

    public static Booking fromCreate(BookingCreateDto dto, Customer customer, Destination destination) {
        LocalDate returnDate = dto.departureDate().plusWeeks(dto.numberOfWeeks());
        double totalPriceSek = destination.getWeeklyRate() * dto.numberOfWeeks();
        double totalPricePln = totalPriceSek * 0.39; //TODO change to converter
        String hotelName = dto.hotelName() == null ? destination.getHotelName() : dto.hotelName();
        
        return new Booking(
                customer,
                destination,
                hotelName,
                dto.departureDate(),
                returnDate,
                totalPriceSek,
                totalPricePln
        );
    }

    public static BookingDto toDto(Booking booking) {
        Long destinationId = booking.getDestination() != null ? booking.getDestination().getId() : null;

        return new BookingDto(
                booking.getId(),
                destinationId,
                booking.getHotelName(),
                booking.getDepartureDate(),
                booking.getReturnDate(),
                booking.getTotalPriceSek()
        );
    }

    public static void applyPatchUpdate(Booking booking, BookingPatchUpdateDto dto, Destination destination) {
        if (dto.destinationId() != null) {
            booking.setDestination(destination);
        }
        if (dto.hotelName() != null) {
            booking.setHotelName(dto.hotelName());
        }
        if (dto.numberOfWeeks() != null && dto.numberOfWeeks() > 0) {
            LocalDate newReturnDate = booking.getDepartureDate().plusWeeks(dto.numberOfWeeks());
            booking.setReturnDate(newReturnDate);
            
            double newTotalPrice = booking.getDestination().getWeeklyRate() * dto.numberOfWeeks();
            booking.setTotalPriceSek(newTotalPrice);
        }
    }
}
