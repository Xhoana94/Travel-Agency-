package com.example.alpha.tour.service;

import com.example.alpha.tour.mapper.TourMapper;
import com.example.alpha.tour.model.Tour;
import com.example.alpha.tour.model.TourDTO;
import com.example.alpha.tour.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRepository;

    public List<TourDTO> getAllTours() {
        List<Tour> tours = tourRepository.findAll();
        return tours.stream()
                .map(TourMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TourDTO getTourById(Long id) {
        Optional<Tour> tourOptional = tourRepository.findById(id);
        if (tourOptional.isPresent()) {
            return TourMapper.toDTO(tourOptional.get());
        } else {
            throw new RuntimeException("Tour not found with id: " + id);
        }
    }

    public TourDTO saveTour(TourDTO dto) {
        Tour tour = TourMapper.toEntity(dto);
        tour = tourRepository.save(tour);
        return TourMapper.toDTO(tour);
    }

    public TourDTO updateTour(Long id, TourDTO dto) {
        Optional<Tour> tourOptional = tourRepository.findById(id);
        if (tourOptional.isPresent()) {
            Tour tour = tourOptional.get();
            tour.setName(dto.getName());
            tour.setPricePerAdult(dto.getPricePerAdult());
            tour.setPricePerChild(dto.getPricePerChild());
            tour.setAdultSeatsAvailable(dto.getAdultSeatAvailable());
            tour.setChildPlacesAvailable(dto.getChildPlacesAvailable());
            tour.setPrice(dto.getPrice());

            tour = tourRepository.save(tour);
            return TourMapper.toDTO(tour);
        } else {
            throw new RuntimeException("Tour not found with id: " + id);
        }
    }

    public void deleteTour(Long id) {
        Optional<Tour> tourOptional = tourRepository.findById(id);
        if (tourOptional.isPresent()) {
            tourRepository.delete(tourOptional.get());
        } else {
            throw new RuntimeException("Tour not found with id: " + id);
        }
    }
}