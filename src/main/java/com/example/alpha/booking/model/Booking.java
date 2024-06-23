package com.example.alpha.booking.model;

import com.example.alpha.hotel.model.Hotel;
import com.example.alpha.tour.model.Tour;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private int adults;
    private int children;
    private double amount;
    private Date bookingDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Booking(Long bookingId, int adults, int children, double amount, Date bookingDate, BookingStatus status, Tour tour, Hotel hotel) {
        this.bookingId = bookingId;
        this.adults = adults;
        this.children = children;
        this.amount = amount;
        this.bookingDate = bookingDate;
        this.status = status;
        this.tour = tour;
        this.hotel = hotel;
    }

    public Booking (){

    }

    public Long getBookingId() {
        return bookingId;
    }

    public int getAdults() {
        return adults;
    }

    public int getChildren() {
        return children;
    }

    public double getAmount() {
        return amount;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Tour getTour() {
        return tour;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Date getBooking_date() {
        return  bookingDate ;
    }
}