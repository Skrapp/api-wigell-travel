package com.nilsson.api_wigell_travel.controller;

import com.nilsson.api_wigell_travel.dto.DestinationCreateDto;
import com.nilsson.api_wigell_travel.dto.DestinationDto;
import com.nilsson.api_wigell_travel.service.DestinationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/destinations")
public class DestinationController {
    /*
    User
        • Lista resmål GET /api/v1/destinations
    Admin
        • Lägga till resmål POST /api/v1/destinations
        • Ta bort resmål DELETE /api/v1/destinations/{destinationId}
        • Uppdatera resmål PUT /api/v1/destinations/{destinationId}
        • Lista resmål GET /api/v1/destinations
     */

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping
    public List<DestinationDto> listAll(){
        return destinationService.listAll();
    }

    /*@PostMapping
    public ResponseEntity<DestinationDto> create(@RequestBody @Valid DestinationCreateDto dto){
        //TODO Fortsätt
    }*/
}
