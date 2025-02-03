package com.example.demo.Controller;

import com.example.demo.Model.Tours;
import com.example.demo.Service.ToursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping("api/tours")
@Controller
public class ToursController {
    @Autowired
    ToursService toursService;
    @GetMapping("")
    ResponseEntity<List<Tours>> getAllTours(){
        return ResponseEntity.ok(toursService.getAllTour());
    }
}
