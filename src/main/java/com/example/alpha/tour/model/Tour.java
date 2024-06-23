package com.example.alpha.tour.model;

import com.example.alpha.booking.model.Booking;
import com.example.alpha.hotel.model.Hotel;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double pricePerAdult;
    private double pricePerChild;
    private int adultSeatAvailable;
    private int childPlacesAvailable;

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "tour")
    private List<Booking> bookings;

    // Constructors


    public Tour(Long id, String name,Double price , double pricePerAdult, double pricePerChild, int adultSeatAvailable, int childPlacesAvailable, Hotel hotel, List<Booking> bookings) {
        this.id = id;
        this.name = name;
        this.pricePerAdult = pricePerAdult;
        this.pricePerChild = pricePerChild;
        this.adultSeatAvailable = adultSeatAvailable;
        this.childPlacesAvailable = childPlacesAvailable;
        this.hotel = hotel;
        this.bookings = bookings;
        this.price = price ;

    }

    public Tour() {

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


    public int getAdultSeatsAvailable() {
        return adultSeatAvailable;
    }

    public void setAdultSeatsAvailable(int adultSeatsAvailable) {
        this.adultSeatAvailable = adultSeatsAvailable;
    }

    public int getChildPlacesAvailable() {
        return childPlacesAvailable;
    }

    public void setChildPlacesAvailable(int childPlacesAvailable) {
        this.childPlacesAvailable = childPlacesAvailable;
    }

    public double getPricePerAdult() {
        return pricePerAdult;
    }

    public void setPricePerAdult(Double pricePerAdult) {
        this.pricePerAdult = pricePerAdult;
    }

    public double getPricePerChild() {
        return pricePerChild;
    }

    public void setPricePerChild(Double pricePerChild) {
        this.pricePerChild = pricePerChild;
    }

    public double calculatePrice(Long tourId, int adults, int children) {
        Tour tour = getTourById(tourId);
        if (tour == null) {
            throw new IllegalArgumentException("Invalid tour ID");
        }

        // Define the pricing logic
        double basePrice = tour.getPrice();
        double adultPrice = basePrice * adults;
        double childDiscount = 0.5; // Assuming children get a 50% discount
        double childPrice = (basePrice * childDiscount) * children;

        // Calculate the total price
        double totalPrice = adultPrice + childPrice;

        // Return the total price rounded to two decimal places
        return BigDecimal.valueOf(totalPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    private Tour getTourById(Long tourId) {
        return null;
    }


}