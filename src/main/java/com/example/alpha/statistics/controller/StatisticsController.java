package com.example.alpha.statistics.controller;

import com.example.alpha.statistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/bookings")
    public long getBookingsCountByStatusInMonth(
            @RequestParam String status,
            @RequestParam int year,
            @RequestParam int month) {
        return statisticsService.getBookingsCountByStatusInMonth(status, year, month);
    }

    @GetMapping("/most-selected-tours")
    public Map<String, Long> getMostSelectedTours(
            @RequestParam int year,
            @RequestParam int month) {
        return statisticsService.getMostSelectedTours(year, month);
    }
}