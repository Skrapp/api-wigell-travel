package com.nilsson.api_wigell_travel.service;

import com.nilsson.api_wigell_travel.dto.AddressCreateDto;
import com.nilsson.api_wigell_travel.entity.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    Address getOrCreate(AddressCreateDto dto);
}
