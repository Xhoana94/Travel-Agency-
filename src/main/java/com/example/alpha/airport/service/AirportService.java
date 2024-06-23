package com.example.alpha.airport.service;

import com.example.alpha.airport.mapper.AirportMapper;
import com.example.alpha.airport.model.Airport;
import com.example.alpha.airport.model.AirportDTO;
import com.example.alpha.airport.repository.AirportRepository;
import com.example.alpha.city.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<AirportDTO> getAllAirports() {
        List<Airport> airports = airportRepository.findAll();
        return airports.stream()
                .map(AirportMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AirportDTO getAirportById(Long id) {
        Optional<Airport> airportOptional = airportRepository.findById(id);
        if (airportOptional.isPresent()) {
            return AirportMapper.toDTO(airportOptional.get());
        } else {
            throw new RuntimeException("Airport not found with id: " + id);
        }
    }

    public AirportDTO saveAirport(AirportDTO dto) {
        Airport airport = AirportMapper.toEntity(dto);
        airport = airportRepository.save(airport);
        return AirportMapper.toDTO(airport);
    }

    public AirportDTO updateAirport(Long id, AirportDTO dto) {
        Optional<Airport> airportOptional = airportRepository.findById(id);
        if (airportOptional.isPresent()) {
            Airport airport = airportOptional.get();
            airport.setName(dto.getName());
            airport.setCity(CityMapper.toEntity(dto.getCity()));
            airport = airportRepository.save(airport);
            return AirportMapper.toDTO(airport);
        } else {
            throw new RuntimeException("Airport not found with id: " + id);
        }
    }

    public void deleteAirport(Long id) {
        Optional<Airport> airportOptional = airportRepository.findById(id);
        if (airportOptional.isPresent()) {
            airportRepository.delete(airportOptional.get());
        } else {
            throw new RuntimeException("Airport not found with id: " + id);
        }
    }
}