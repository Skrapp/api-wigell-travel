package com.nilsson.api_wigell_travel.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    /*
    User
        • Boka resa POST /api/v1/bookings
        • Boka om resa PATCH /api/v1/bookings/{bookingId} (tillåtna fält: reslängd (veckor),
        destination, hotell)
        • Se tidigare och aktiva bokningar GET /api/v1/bookings?customerId={customerId}
     */
}
