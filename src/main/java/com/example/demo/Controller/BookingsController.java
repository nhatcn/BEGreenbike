package com.example.demo.Controller;

import com.example.demo.DTO.BookingsDTO;
import com.example.demo.Repository.BookingsRepository;
import com.example.demo.Service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingsController {
    @Autowired
    private BookingsService bookingsService;
    @Autowired
    private BookingsRepository bookingsRepository;
    @GetMapping("lists")
    public ResponseEntity<List<BookingsDTO>> getAll(){
      return ResponseEntity.ok(bookingsService.getAll());
    }
    @GetMapping("tourSearch/{name}")
    public ResponseEntity<List<BookingsDTO>> searchByTourName(@PathVariable String name){
        return ResponseEntity.ok(bookingsService.searchByTourName(name));

    }
    @GetMapping("userSearch/{name}")
    public ResponseEntity<List<BookingsDTO>> searchByUserName(@PathVariable String name){
        return ResponseEntity.ok(bookingsService.searchByUserName(name));
    }

}
