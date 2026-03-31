package com.nilsson.api_wigell_travel.mapper;

import com.nilsson.api_wigell_travel.dto.*;
import com.nilsson.api_wigell_travel.entity.Address;
import com.nilsson.api_wigell_travel.entity.Customer;

import java.util.List;

public final class CustomerMapper {
    private CustomerMapper(){}

    public static Customer fromCreate(CustomerWithAccountCreateDto dto){
        return new Customer(
                dto.firstName(),
                dto.lastName(),
                dto.dateOfBirth(),
                dto.email(),
                dto.phoneNumber(),
                dto.username()
        );
    }

    public static CustomerDto toDto(Customer customer) {
        List<AddressDto> addresses = customer.getAddresses().stream()
                .map(AddressMapper::toDto)
                .toList();

        return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                addresses,
                customer.getDateOfBirth(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );
    }

    public static void applyPutUpdate(Customer customer, CustomerPutUpdateDto dto){
        customer.setFirstName(dto.firstName());
        customer.setLastName(dto.lastName());
        customer.setEmail(dto.email());
        customer.setPhoneNumber(dto.phoneNumber());
    }

    public static void applyPatchUpdate(Customer customer, CustomerPatchUpdateDto dto){
        if(dto.firstName() != null){
            customer.setFirstName(dto.firstName());
        }
        if(dto.lastName() != null){
            customer.setLastName(dto.lastName());
        }
        if(dto.email() != null){
            customer.setEmail(dto.email());
        }
        if(dto.phoneNumber() != null){
            customer.setPhoneNumber(dto.phoneNumber());
        }
    }
}
