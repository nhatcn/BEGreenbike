package com.example.demo.Controller;

import com.example.demo.DTO.FeedbacksDTO;
import com.example.demo.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/feedback")
public class FeedbacksController {

    @Autowired
    FeedbackService feedbackService;

    @GetMapping("/list")
    public ResponseEntity<?> listFeedback() {
        try {
            List<FeedbacksDTO> feedbacks = feedbackService.getAllFeedbacks();
            if (feedbacks.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No feedbacks found.");
            }
            return ResponseEntity.ok(feedbacks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching feedbacks: " + e.getMessage());
        }
    }

    @GetMapping("search/{userName}")
    public ResponseEntity<?> listFeedbacksOfUser(@PathVariable String userName) {
        try {
            List<FeedbacksDTO> userFeedbacks = feedbackService.getAllFeedbacksByUserName(userName);
            if (userFeedbacks.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No feedbacks found for user: " + userName);
            }
            return ResponseEntity.ok(userFeedbacks);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching feedbacks for user: " + e.getMessage());
        }
    }
}
