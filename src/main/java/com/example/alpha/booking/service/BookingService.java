package com.example.alpha.booking.service;

import com.example.alpha.booking.mapper.BookingMapper;
import com.example.alpha.booking.model.Booking;
import com.example.alpha.booking.model.BookingDTO;
import com.example.alpha.booking.repository.BookingRepository;
import com.example.alpha.hotel.mapper.HotelMapper;
import com.example.alpha.tour.mapper.TourMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<BookingDTO> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream()
                .map(BookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BookingDTO getBookingById(Long id) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent()) {
            return BookingMapper.toDTO(bookingOptional.get());
        } else {
            throw new RuntimeException("Booking not found with id: " + id);
        }
    }

    public BookingDTO saveBooking(BookingDTO dto) {
        Booking booking = BookingMapper.toEntity(dto);
        booking.setBookingDate(new Date());

        booking = bookingRepository.save(booking);
        return BookingMapper.toDTO(booking);
    }

    public BookingDTO updateBooking(Long id, BookingDTO dto) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setAdults(dto.getAdults());
            booking.setChildren(dto.getChildren());
            booking.setAmount(dto.getAmount());
            booking.setBookingDate(dto.getBookingDate());
            booking.setStatus(dto.getStatus());
            booking.setTour(TourMapper.toEntity(dto.getTour()));
            booking.setHotel(HotelMapper.toEntity(dto.getHotel()));
            booking = bookingRepository.save(booking);
            return BookingMapper.toDTO(booking);
        } else {
            throw new RuntimeException("Booking not found with id: " + id);
        }
    }

    public void deleteBooking(Long id) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent()) {
            bookingRepository.delete(bookingOptional.get());
        } else {
            throw new RuntimeException("Booking not found with id: " + id);
        }
    }
}