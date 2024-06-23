package com.example.alpha.airport.controller;

import com.example.alpha.airport.model.AirportDTO;
import com.example.alpha.airport.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public List<AirportDTO> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/{id}")
    public AirportDTO getAirportById(@PathVariable Long id) {
        return airportService.getAirportById(id);
    }

    @PostMapping
    public AirportDTO createAirport(@RequestBody AirportDTO dto) {
        return airportService.saveAirport(dto);
    }

    @PutMapping("/{id}")
    public AirportDTO updateAirport(@PathVariable Long id, @RequestBody AirportDTO dto) {
        return airportService.updateAirport(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
    }
}