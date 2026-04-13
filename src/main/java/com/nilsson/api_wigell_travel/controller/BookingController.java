package com.nilsson.api_wigell_travel.controller;

import com.nilsson.api_wigell_travel.dto.BookingCreateDto;
import com.nilsson.api_wigell_travel.dto.BookingDto;
import com.nilsson.api_wigell_travel.dto.BookingPatchUpdateDto;
import com.nilsson.api_wigell_travel.service.BookingService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingDto> create(@RequestBody @Valid BookingCreateDto dto) {
        BookingDto saved = bookingService.create(dto);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{bookingId}").buildAndExpand(saved.bookingId())
                .toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @PatchMapping("/{bookingId}")
    public ResponseEntity<BookingDto> patchUpdate(@PathVariable Long bookingId, @RequestBody @Valid BookingPatchUpdateDto dto) {
        BookingDto saved = bookingService.patchUpdate(bookingId, dto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<BookingDto> get(@PathParam("customerId") Long customerId) {
        return bookingService.getCustomersBooking(customerId);
    }
}
