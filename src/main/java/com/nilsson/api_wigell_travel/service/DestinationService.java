package com.nilsson.api_wigell_travel.service;

import com.nilsson.api_wigell_travel.dto.DestinationCreateDto;
import com.nilsson.api_wigell_travel.dto.DestinationDto;
import com.nilsson.api_wigell_travel.dto.DestinationPutUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DestinationService {
    List<DestinationDto> listAll();
    DestinationDto create(DestinationCreateDto dto);
    void delete(Long id);
    DestinationDto putUpdate(Long id, DestinationPutUpdateDto dto);

}
