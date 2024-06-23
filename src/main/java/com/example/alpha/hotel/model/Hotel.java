package com.example.alpha.hotel.model;

import com.example.alpha.booking.model.Booking;
import com.example.alpha.city.model.City;
import com.example.alpha.city.model.CityDTO;
import com.example.alpha.tour.model.Tour;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String standard;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "hotel")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "hotel")
    private List<Tour> tours;

    public Hotel() {
    }
    public Hotel(String name, String description, String standard) {
        this.name = name;
        this.description = description;
        this.standard = standard;

    } // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;

    }

    public String getStandard() {
        return standard;
    }
    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }




}

