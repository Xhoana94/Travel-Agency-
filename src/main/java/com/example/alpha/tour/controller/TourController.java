package com.example.alpha.tour.controller;


import com.example.alpha.tour.model.TourDTO;
import com.example.alpha.tour.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourController {

    @Autowired
    private TourService tourService;
    @GetMapping
    public ResponseEntity<List<TourDTO>> getAllTours() {
        List<TourDTO> tours = tourService.getAllTours();
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TourDTO> getTourById(@PathVariable Long id) {
        TourDTO tour = tourService.getTourById(id);
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TourDTO> createTour(@RequestBody TourDTO tourDTO) {
        TourDTO createdTour = tourService.createTour(tourDTO);
        return new ResponseEntity<>(createdTour, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TourDTO> updateTour(@PathVariable Long id, @RequestBody TourDTO tourDTO) {
        TourDTO updatedTour = tourService.updateTour(id, tourDTO);
        return new ResponseEntity<>(updatedTour, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable Long id) {
        tourService.deleteTour(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}