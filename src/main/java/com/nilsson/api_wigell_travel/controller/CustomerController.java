package com.nilsson.api_wigell_travel.controller;

import com.nilsson.api_wigell_travel.dto.*;
import com.nilsson.api_wigell_travel.service.CustomerService;
import com.nilsson.api_wigell_travel.service.CustomerServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    /*
    Admin
        • Lista kunder GET /api/v1/customers
        • Lägga till kund POST /api/v1/customers
        • Ta bort kund DELETE /api/v1/customers/{customerId}
        • Uppdatera kund PUT /api/v1/customers/{customerId}
        • Lägga till adress POST /api/v1/customers/{customerId}/addresses
        • Ta bort adress DELETE /api/v1/customers/{customerId}/addresses/{addressId}
     */

    private final CustomerService customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDto> listAll(){
        return customerService.listAll();
    }

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody @Valid CustomerWithAccountCreateDto dto){
        CustomerDto saved = customerService.createCustomerWithAccount(dto);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{customerId}").buildAndExpand(saved.id())
                .toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> putUpdate(@PathVariable Long customerId, @RequestBody @Valid CustomerPutUpdateDto dto){
        CustomerDto saved = customerService.putUpdateCustomer(customerId, dto);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> remove(@PathVariable Long customerId){
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{customerId}/addresses")
    public ResponseEntity<CustomerDto> addAddress(@PathVariable Long customerId, @RequestBody @Valid AddressCreateDto dto){
        CustomerDto saved = customerService.addAddressToCustomer(customerId, dto);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{customerId}/addresses/{addressId}")
    public ResponseEntity<CustomerDto> removeAddress(@PathVariable Long customerId, @PathVariable Long addressId){
        CustomerDto saved = customerService.deleteAddressFromCustomer(customerId, addressId);
        return ResponseEntity.ok(saved);
    }
}
