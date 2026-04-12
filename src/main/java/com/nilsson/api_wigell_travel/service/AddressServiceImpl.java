package com.nilsson.api_wigell_travel.service;

import com.nilsson.api_wigell_travel.dto.AddressCreateDto;
import com.nilsson.api_wigell_travel.entity.Address;
import com.nilsson.api_wigell_travel.mapper.AddressMapper;
import com.nilsson.api_wigell_travel.repo.AddressRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressServiceImpl implements AddressService{
    private final AddressRepo addressRepo;

    public AddressServiceImpl(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Transactional
    @Override
    public Address getOrCreate(AddressCreateDto dto) {
        //se ifall address redan finns
        Address address = addressRepo
                .findAddressByStreetAddressAndPostalCodeAndCity(
                        dto.streetAddress(),
                        dto.postalCode(),
                        dto.city())
                .orElseGet(() -> addressRepo.save(AddressMapper.fromCreate(dto))
                );
        return address;
    }


}
