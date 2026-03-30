package com.nilsson.api_wigell_travel.mapper;

import com.nilsson.api_wigell_travel.dto.*;
import com.nilsson.api_wigell_travel.entity.Address;
import com.nilsson.api_wigell_travel.entity.Customer;

public final class CustomerMapper {
    private CustomerMapper(){}

    public static Customer fromCreate(CustomerCreateDto dto){
        Address address = AddressMapper.fromCreate(dto.address());

        return new Customer(
                dto.firstName(),
                dto.lastName(),
                address,
                dto.email(),
                dto.phoneNumber()
        );
    }

    public static CustomerDto toDto(Customer customer) {
        AddressDto addressDto = AddressMapper.toDto(customer.getAddress());

        return new CustomerDto(
                customer.getFirstName(),
                customer.getLastName(),
                addressDto,
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
