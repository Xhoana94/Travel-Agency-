package com.example.alpha.booking.mapper;

import com.example.alpha.booking.model.Booking;
import com.example.alpha.booking.model.BookingDTO;
import com.example.alpha.hotel.mapper.HotelMapper;
import com.example.alpha.tour.mapper.TourMapper;

public class BookingMapper {

    public static BookingDTO toDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setBookingId(booking.getBookingId());
        dto.setAdults(booking.getAdults());
        dto.setChildren(booking.getChildren());
        dto.setAmount(booking.getAmount());
        dto.setBookingDate(booking.getBookingDate());
        dto.setStatus(booking.getStatus());
        dto.setTour(TourMapper.toDTO(booking.getTour()));
        dto.setHotel(HotelMapper.toDTO(booking.getHotel()));
        return dto;
    }

    public static Booking toEntity(BookingDTO dto) {
        Booking booking = new Booking();
        booking.setBookingId(dto.getBookingId());
        booking.setAdults(dto.getAdults());
        booking.setChildren(dto.getChildren());
        booking.setAmount(dto.getAmount());
        booking.setBookingDate(dto.getBookingDate());
        booking.setStatus(dto.getStatus());
        booking.setTour(TourMapper.toEntity(dto.getTour()));
        booking.setHotel(HotelMapper.toEntity(dto.getHotel()));
        return booking;
    }
}