package com.example.demo.Service;

import com.example.demo.Model.Tours;
import com.example.demo.Repository.ToursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToursService {
    @Autowired
    ToursRepository toursRepository;

    public List<Tours> getAllTour(){
        return toursRepository.findAll();
    }

}
