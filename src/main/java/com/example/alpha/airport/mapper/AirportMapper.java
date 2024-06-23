package com.example.alpha.airport.mapper;

import com.example.alpha.airport.model.Airport;
import com.example.alpha.airport.model.AirportDTO;
import com.example.alpha.city.mapper.CityMapper;

public class AirportMapper {

    public static AirportDTO toDTO(Airport airport) {
        AirportDTO dto = new AirportDTO();
        dto.setId(airport.getId());
        dto.setName(airport.getName());
        dto.setCity(CityMapper.toDTO(airport.getCity()));
        return dto;
    }

    public static Airport toEntity(AirportDTO dto) {
        Airport airport = new Airport();
        airport.setId(dto.getId());
        airport.setName(dto.getName());
        airport.setCity(CityMapper.toEntity(dto.getCity()));
        return airport;
    }
}