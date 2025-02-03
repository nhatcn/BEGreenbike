package com.example.demo.Repository;

import com.example.demo.Model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Long> {
    List<Bookings> findByUserName(String name);
    List<Bookings> findByTourName(String tourName);

}
