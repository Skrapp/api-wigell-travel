package com.nilsson.api_wigell_travel.service;

import com.nilsson.api_wigell_travel.dto.DestinationCreateDto;
import com.nilsson.api_wigell_travel.dto.DestinationDto;
import com.nilsson.api_wigell_travel.dto.DestinationPutUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DestinationService {
    /*
    User
        • Lista resmål GET /api/v1/destinations
    Admin
        • Lägga till resmål POST /api/v1/destinations
        • Ta bort resmål DELETE /api/v1/destinations/{destinationId}
        • Uppdatera resmål PUT /api/v1/destinations/{destinationId}
        • Lista resmål GET /api/v1/destinations
     */
    List<DestinationDto> listAll();
    DestinationDto create(DestinationCreateDto dto);
    void delete(Long id);
    DestinationDto putUpdate(Long id, DestinationPutUpdateDto dto);

}
