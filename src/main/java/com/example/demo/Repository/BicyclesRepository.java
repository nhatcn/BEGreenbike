package com.example.demo.Repository;

import com.example.demo.Model.Bicycles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BicyclesRepository extends JpaRepository<Bicycles, Long> {

}
