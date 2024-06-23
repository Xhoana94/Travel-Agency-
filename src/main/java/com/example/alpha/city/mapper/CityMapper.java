package com.example.alpha.city.mapper;

import com.example.alpha.airport.mapper.AirportMapper;
import com.example.alpha.city.model.City;
import com.example.alpha.city.model.CityDTO;
import com.example.alpha.hotel.mapper.HotelMapper;

import java.util.stream.Collectors;

public class CityMapper {

    public static CityDTO toDTO(City city) {
        CityDTO dto = new CityDTO();
        dto.setId(city.getId());
        dto.setName(city.getName());
        dto.setNationality(city.getNationality());

        return dto;
    }

    public static City toEntity(CityDTO dto) {
        City city = new City();
        city.setId(dto.getId());
        city.setName(dto.getName());
        city.setNationality(dto.getNationality());
        // Setting hotels and airports is omitted as it would be a complex operation
        return city;
    }
}