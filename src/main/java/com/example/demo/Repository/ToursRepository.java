package com.example.demo.Repository;

import com.example.demo.Model.Tours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToursRepository extends JpaRepository<Tours, Long> {

}
