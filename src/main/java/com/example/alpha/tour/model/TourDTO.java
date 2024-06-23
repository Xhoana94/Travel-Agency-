package com.example.alpha.tour.model;

import com.example.alpha.hotel.model.HotelDTO;

public class TourDTO {
    private Long id;
    private String name;
    private double pricePerAdult;
    private double pricePerChild;
    private int adultSeatAvailable;
    private int childPlacesAvailable;
    private double price;
    private HotelDTO hotel;

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

    public double getPricePerAdult() {
        return pricePerAdult;
    }

    public void setPricePerAdult(double pricePerAdult) {
        this.pricePerAdult = pricePerAdult;
    }

    public double getPricePerChild() {
        return pricePerChild;
    }

    public void setPricePerChild(double pricePerChild) {
        this.pricePerChild = pricePerChild;
    }

    public int getAdultSeatAvailable() {
        return adultSeatAvailable;
    }

    public void setAdultSeatAvailable(int adultSeatAvailable) {
        this.adultSeatAvailable = adultSeatAvailable;
    }

    public int getChildPlacesAvailable() {
        return childPlacesAvailable;
    }

    public void setChildPlacesAvailable(int childPlacesAvailable) {
        this.childPlacesAvailable = childPlacesAvailable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public HotelDTO getHotel() {
        return hotel;
    }

    public void setHotel(HotelDTO hotel) {
        this.hotel = hotel;
    }
}