package com.nilsson.api_wigell_travel.mapper;

import com.nilsson.api_wigell_travel.dto.DestinationCreateDto;
import com.nilsson.api_wigell_travel.dto.DestinationDto;
import com.nilsson.api_wigell_travel.dto.DestinationPutUpdateDto;
import com.nilsson.api_wigell_travel.entity.Destination;

public final class DestinationMapper {
    private DestinationMapper() {
    }
    
    public static Destination fromCreate(DestinationCreateDto dto){
        return new Destination(dto.weeklyRate(), dto.hotelName(), dto.city(), dto.country());
    }

    public static DestinationDto toDto(Destination d){
        return new DestinationDto(d.getWeeklyRate(), d.getHotelName(), d.getCity(), d.getCountry());
    }

    public static void applyPutUpdate(Destination d, DestinationPutUpdateDto dto){
        d.setWeeklyRate(dto.weeklyRate());
        d.setHotelName(dto.hotelName());
        d.setCity(dto.city());
        d.setCountry(dto.city());
    }
}
