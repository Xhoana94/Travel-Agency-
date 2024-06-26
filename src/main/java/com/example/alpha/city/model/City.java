package com.example.alpha.city.model;

import com.example.alpha.airport.model.Airport;
import com.example.alpha.hotel.model.Hotel;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nationality;

    @OneToMany(mappedBy = "city")
    private List<Hotel> hotels;

    @OneToMany(mappedBy = "city")
    private List<Airport> airports;

    public City() {
    }

    public City(Long id, String name, String nationality) {

        this.id = id;
        this.name = name;
        this.nationality = nationality;

    }

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
}
