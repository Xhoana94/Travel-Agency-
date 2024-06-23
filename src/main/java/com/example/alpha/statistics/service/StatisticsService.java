package com.example.alpha.statistics.service;

import com.example.alpha.booking.model.Booking;
import com.example.alpha.booking.repository.BookingRepository;
import com.example.alpha.tour.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatisticsService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TourRepository tourRepository;

    public long getBookingsCountByStatusInMonth(String status, int year, int month) {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream()
                .filter(booking -> {
                    LocalDate bookingDate = booking.getBooking_date().toInstant()
                            .atZone(ZoneId.systemDefault()).toLocalDate();
                    return bookingDate.getYear() == year && bookingDate.getMonthValue() == month
                            && booking.getStatus().name().equalsIgnoreCase(status);
                })
                .count();
    }

    public Map<String, Long> getMostSelectedTours(int year, int month) {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream()
                .filter(booking -> {
                    LocalDate bookingDate = booking.getBooking_date().toInstant()
                            .atZone(ZoneId.systemDefault()).toLocalDate();
                    return bookingDate.getYear() == year && bookingDate.getMonthValue() == month;
                })
                .collect(Collectors.groupingBy(booking -> booking.getTour().getName(), Collectors.counting()));
    }
    public Map<String, Map<String, Long>> getTourPopularityTrends() {
        Map<String, Map<String, Long>> tourPopularityTrends = new HashMap<>();

        List<Booking> bookings = bookingRepository.findAll();

        for (Booking booking : bookings) {
            String tourName = booking.getTour().getName();
            String monthYear = getMonthYear(booking.getBookingDate());

            // Update the popularity count for the tour in the respective month
            tourPopularityTrends.computeIfAbsent(tourName, k -> new HashMap<>())
                    .merge(monthYear, 1L, Long::sum);
        }

        return tourPopularityTrends;
    }

    private String getMonthYear(Date date) {
        // Format the date to "YYYY-MM" for grouping by month
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        return dateFormat.format(date);
    }
}

