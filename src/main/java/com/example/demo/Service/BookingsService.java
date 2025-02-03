package com.example.demo.Service;

import com.example.demo.DTO.BookingsDTO;
import com.example.demo.Model.Bookings;
import com.example.demo.Repository.BookingsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingsService {
    @Autowired
    private BookingsRepository bookingsRepository;
    @Autowired
    private ModelMapper modelMapper;

//    public List<BookingsDTO> searchByUsername(String username) {
//        List<Bookings> bookingsList = bookingsRepository.findByUsername(username);
//        return bookingsList.stream()
//                .map(booking -> modelMapper.map(booking, BookingsDTO.class))
//                .collect(Collectors.toList());
//    }
    public List<BookingsDTO> getAll(){
        List<Bookings> bookingsList = bookingsRepository.findAll();
        return bookingsList.stream().map(bookings -> modelMapper.map(bookings, BookingsDTO.class)).collect(Collectors.toList());
    }
    public List<BookingsDTO> searchByTourName(String tourName){
        List<Bookings> bookingsList = bookingsRepository.findByTourName(tourName);
        return bookingsList.stream().map(bookings -> modelMapper.map(bookings, BookingsDTO.class)).collect(Collectors.toList());
    }
    public List<BookingsDTO> searchByUserName(String name){
        List<Bookings> bookingsList = bookingsRepository.findByUserName(name);
        return bookingsList.stream().map(bookings -> modelMapper.map(bookings, BookingsDTO.class)).collect(Collectors.toList());
    }

}
