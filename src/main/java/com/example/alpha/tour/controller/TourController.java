package com.example.alpha.tour.controller;

import com.example.alpha.tour.model.TourDTO;
import com.example.alpha.tour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping
    public List<TourDTO> getAllTours() {
        return tourService.getAllTours();
    }

    @GetMapping("/{id}")
    public TourDTO getTourById(@PathVariable Long id) {
        return tourService.getTourById(id);
    }

    @PostMapping
    public TourDTO createTour(@RequestBody TourDTO dto) {
        return tourService.saveTour(dto);
    }

    @PutMapping("/{id}")
    public TourDTO updateTour(@PathVariable Long id, @RequestBody TourDTO dto) {
        return tourService.updateTour(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTour(@PathVariable Long id) {
        tourService.deleteTour(id);
    }
}