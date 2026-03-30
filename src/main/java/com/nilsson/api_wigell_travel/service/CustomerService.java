package com.nilsson.api_wigell_travel.service;

import com.nilsson.api_wigell_travel.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    /*
    Admin
        • Lista kunder GET /api/v1/customers
        • Lägga till kund POST /api/v1/customers
        • Ta bort kund DELETE /api/v1/customers/{customerId}
        • Uppdatera kund PUT /api/v1/customers/{customerId}
        • Lägga till adress POST /api/v1/customers/{customerId}/addresses
        • Ta bort adress DELETE /api/v1/customers/{customerId}/addresses/{addressId}
     */
    List<CustomerDto> listAll();
    List
}
