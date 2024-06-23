package com.example.alpha.hotel.mapper;

import com.example.alpha.city.mapper.CityMapper;
import com.example.alpha.hotel.model.Hotel;
import com.example.alpha.hotel.model.HotelDTO;

public class HotelMapper {

    public static HotelDTO toDTO(Hotel hotel) {
        HotelDTO dto = new HotelDTO();
        dto.setId(hotel.getId());
        dto.setName(hotel.getName());
        dto.setDescription(hotel.getDescription());
        dto.setStandard(hotel.getStandard());
        return dto;
    }

    public static Hotel toEntity(HotelDTO dto) {
        Hotel hotel = new Hotel();
        hotel.setId(dto.getId());
        hotel.setName(dto.getName());
        hotel.setDescription(dto.getDescription());
        hotel.setStandard(dto.getStandard());

        return hotel;
    }
}