package com.example.alpha.airport.model;

import com.example.alpha.city.model.CityDTO;

public class AirportDTO {
    private Long id;
    private String name;
    private CityDTO city;

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

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }
}