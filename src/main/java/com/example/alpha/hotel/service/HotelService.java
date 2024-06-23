package com.example.alpha.hotel.service;

import com.example.alpha.hotel.mapper.HotelMapper;
import com.example.alpha.hotel.model.Hotel;
import com.example.alpha.hotel.model.HotelDTO;
import com.example.alpha.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<HotelDTO> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .map(HotelMapper::toDTO)
                .collect(Collectors.toList());
    }

    public HotelDTO getHotelById(Long id) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);
        if (hotelOptional.isPresent()) {
            return HotelMapper.toDTO(hotelOptional.get());
        } else {
            throw new RuntimeException("Hotel not found with id: " + id);
        }
    }

    public HotelDTO saveHotel(HotelDTO dto) {
        Hotel hotel = HotelMapper.toEntity(dto);
        hotel = hotelRepository.save(hotel);
        return HotelMapper.toDTO(hotel);
    }


    public HotelDTO updateHotel(Long id, HotelDTO dtoHotel) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);
        if (hotelOptional.isPresent()) {
            Hotel hotel = hotelOptional.get();
            hotel.setName(dtoHotel.getName());
            hotel.setDescription(dtoHotel.getDescription());
            hotel.setStandard(dtoHotel.getStandard());
            hotel = hotelRepository.save(hotel);
            return HotelMapper.toDTO(hotel);
        } else {
            throw new RuntimeException("Hotel not found with id: " + id);
        }
    }

    public void deleteHotel(Long id) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);
        if (hotelOptional.isPresent()) {
            hotelRepository.delete(hotelOptional.get());
        } else {
            throw new RuntimeException("Hotel not found with id: " + id);
        }
    }
}