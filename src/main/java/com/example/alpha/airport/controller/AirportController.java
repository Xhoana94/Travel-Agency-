package com.example.alpha.airport.controller;



import com.example.alpha.airport.dto.AirportDto;
import com.example.alpha.airport.service.AirportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping
    public ResponseEntity<List<AirportDto>> getAllAirports() {
        List<AirportDto> airports = airportService.getAllAirports();
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportDto> getAirportById(@PathVariable Long id) {
        AirportDto airport = airportService.getAirportById(id);
        return new ResponseEntity<>(airport, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AirportDto> createAirport(@RequestBody AirportDto airportDTO) {
        AirportDto createAirport = airportService.createAirport(airportDTO);
        return new ResponseEntity<>(createAirport, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportDto> updateAirport(@PathVariable Long id, @RequestBody AirportDto airportDTO) {
        AirportDto updateAirport = airportService.updateAirport(id, airportDTO);
        return new ResponseEntity<>(updateAirport, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}