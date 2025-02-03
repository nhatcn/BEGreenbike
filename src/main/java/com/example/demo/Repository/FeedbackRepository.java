package com.example.demo.Repository;

import com.example.demo.Model.Feedbacks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedbacks, Long> {
    Optional<Feedbacks> findByUserName(String userName);
    Optional<Feedbacks> findByTourName(String tourName);
}
