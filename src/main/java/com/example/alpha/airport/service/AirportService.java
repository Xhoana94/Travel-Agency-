package com.example.alpha.airport.service;


import com.example.alpha.airport.dto.AirportDto;
import com.example.alpha.airport.model.Airport;
import com.example.alpha.city.model.City;
import com.example.alpha.airport.repository.AirportRepository;
import com.example.alpha.city.repository.CityRepository;
import com.example.alpha.airport.mapper.AirportMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;


    @Autowired
    private AirportMapper airportMapper;

    public List<AirportDto> getAllAirports() {
        List<Airport> airports = airportRepository.findAll();
        return airports.stream()
                .map(airportMapper::toDTO)
                .collect(Collectors.toList());
    }



    public AirportDto getAirportById(Long id) {
        Airport airport = airportRepository.findById(id).orElse(null);
        if (airport != null) {
            return airportMapper.toDTO(airport);
        } else {
            // Handle case where airport is not found
            return null;
        }
    }

    public AirportDto createAirport(AirportDto airportDto) {
        Airport airport = airportMapper.toEntity(airportDto);
        Airport savedAirport = airportRepository.save(airport);
        return airportMapper.toDTO(savedAirport);
    }

    public AirportDto updateAirport(Long id, AirportDto airportDto) {
        Airport existingAirport = airportRepository.findById(id).orElse(null);
        if (existingAirport != null) {
            Airport updatedAirport = airportMapper.toEntity(airportDto);
            updatedAirport.setId(id); // Ensure ID consistency
            Airport savedAirport = airportRepository.save(updatedAirport);
            return airportMapper.toDTO(savedAirport);
        } else {
            // Handle case where airport is not found
            return null;
        }
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }}