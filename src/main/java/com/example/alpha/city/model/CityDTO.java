package com.example.alpha.city.model;

import com.example.alpha.airport.model.AirportDTO;
import com.example.alpha.hotel.model.HotelDTO;

import java.util.List;

public class CityDTO {
    private Long id;
    private String name;
    private String nationality;
    private List<HotelDTO> hotels;
    private List<AirportDTO> airports;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<HotelDTO> getHotels() {
        return hotels;
    }

    public void setHotels(List<HotelDTO> hotels) {
        this.hotels = hotels;
    }

    public List<AirportDTO> getAirports() {
        return airports;
    }

    public void setAirports(List<AirportDTO> airports) {
        this.airports = airports;
    }
}