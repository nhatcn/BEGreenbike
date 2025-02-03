package com.example.demo.Controller;

import com.example.demo.DTO.BicyclesDTO;
import com.example.demo.Service.BicyclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/bicycles")
public class BicyclesController {
    @Autowired
    BicyclesService bicyclesService;

    @GetMapping("list")
    public ResponseEntity<List<BicyclesDTO>> getAllBicycles(){
        return ResponseEntity.ok(bicyclesService.getAllBicycles());
    }
}
