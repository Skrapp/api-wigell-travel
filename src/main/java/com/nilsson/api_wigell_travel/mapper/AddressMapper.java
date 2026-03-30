package com.nilsson.api_wigell_travel.mapper;

import com.nilsson.api_wigell_travel.dto.AddressCreateDto;
import com.nilsson.api_wigell_travel.dto.AddressDto;
import com.nilsson.api_wigell_travel.entity.Address;

public final class AddressMapper {
    private AddressMapper(){}

    public static Address fromCreate(AddressCreateDto dto){
        return new Address(
                dto.streetAddress(),
                dto.city(),
                dto.postalCode()
        );
    }

    public static AddressDto toDto(Address address) {
        return new AddressDto(
                address.getStreetAddress(),
                address.getCity(),
                address.getCity()
        );
    }
}
