package com.example.demo.Service;

import com.example.demo.DTO.BicyclesDTO;
import com.example.demo.DTO.FeedbacksDTO;

import com.example.demo.Model.Bicycles;
import com.example.demo.Repository.BicyclesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BicyclesService {
    @Autowired
    private BicyclesRepository bicyclesRepository;
    @Autowired
    ModelMapper modelMapper;

    //    public List<UsersDTO> getAllUsers() {
//        return userRepository.findAll().stream()
//                .map(user -> convertToDTO(user, false))
//                .collect(Collectors.toList());
//    }
    private BicyclesDTO convertToDTO(Bicycles bicycles) {
        return modelMapper.map(bicycles, BicyclesDTO.class);
    }

    public List<BicyclesDTO> getAllBicycles() {
        return bicyclesRepository.findAll().stream().map(bicycles -> convertToDTO(bicycles)).collect(Collectors.toList());
    }
}
