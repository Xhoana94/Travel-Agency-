package com.example.alpha.city.service;

import com.example.alpha.city.mapper.CityMapper;
import com.example.alpha.city.model.City;
import com.example.alpha.city.model.CityDTO;
import com.example.alpha.city.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<CityDTO> getAllCities() {
        List<City> cities = cityRepository.findAll();
        return cities.stream().map(CityMapper::toDTO).collect(Collectors.toList());
    }

    public CityDTO getCityById(Long id) {
        Optional<City> cityOptional = cityRepository.findById(id);
        if (cityOptional.isPresent()) {
            return CityMapper.toDTO(cityOptional.get());
        } else {
            throw new RuntimeException("City not found with id: " + id);
        }
    }

    public CityDTO saveCity(CityDTO dto) {
        City city = CityMapper.toEntity(dto);
        city = cityRepository.save(city);
        return CityMapper.toDTO(city);
    }

    public CityDTO updateCity(Long id, CityDTO dto) {
        Optional<City> cityOptional = cityRepository.findById(id);
        if (cityOptional.isPresent()) {
            City city = cityOptional.get();
            city.setName(dto.getName());
            city.setNationality(dto.getNationality());
            city = cityRepository.save(city);
            return CityMapper.toDTO(city);
        } else {
            throw new RuntimeException("City not found with id: " + id);
        }
    }

    public void deleteCity(Long id) {
        Optional<City> cityOptional = cityRepository.findById(id);
        if (cityOptional.isPresent()) {
            cityRepository.delete(cityOptional.get());
        } else {
            throw new RuntimeException("City not found with id: " + id);
        }
    }
}