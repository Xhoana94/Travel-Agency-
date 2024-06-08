package com.example.alpha.airport.mapper;

import com.example.alpha.airport.dto.AirportDto;
import com.example.alpha.airport.model.Airport;

import com.example.alpha.city.model.City;
import org.springframework.stereotype.Component;

@Component

public class AirportMapper {
    public AirportDto toDTO(Airport airport) {
        AirportDto DTO = new AirportDto();
        DTO.setId(airport.getId());
        DTO.setName(airport.getName());
        return DTO;
    }

    public static Airport toEntity(AirportDto DTO) {
        Airport airport = new Airport();
        airport.setId(DTO.getId());
        airport.setName(DTO.getName());
        return airport;
    }
}