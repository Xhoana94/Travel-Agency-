package com.example.alpha.tour.mapper;

import com.example.alpha.hotel.mapper.HotelMapper;
import com.example.alpha.tour.model.Tour;
import com.example.alpha.tour.model.TourDTO;

public class TourMapper {

    public static TourDTO toDTO(Tour tour) {
        TourDTO dto = new TourDTO();
        dto.setId(tour.getId());
        dto.setName(tour.getName());
        dto.setPricePerAdult(tour.getPricePerAdult());
        dto.setPricePerChild(tour.getPricePerChild());
        dto.setAdultSeatAvailable(tour.getAdultSeatsAvailable());
        dto.setChildPlacesAvailable(tour.getChildPlacesAvailable());
        dto.setPrice(tour.getPrice());
        return dto;
    }

    public static Tour toEntity(TourDTO dto) {
        Tour tour = new Tour();
        tour.setId(dto.getId());
        tour.setName(dto.getName());
        tour.setPricePerAdult(dto.getPricePerAdult());
        tour.setPricePerChild(dto.getPricePerChild());
        tour.setAdultSeatsAvailable(dto.getAdultSeatAvailable());
        tour.setChildPlacesAvailable(dto.getChildPlacesAvailable());
        tour.setPrice(dto.getPrice());
        return tour;
    }
}