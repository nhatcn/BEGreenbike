package com.example.demo.Service;

import com.example.demo.DTO.FeedbacksDTO;
import com.example.demo.Model.Feedbacks;
import com.example.demo.Repository.FeedbackRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackService {
    @Autowired
    FeedbackRepository feedbackRopository;
    @Autowired
    ModelMapper modelMapper;

    private FeedbacksDTO convertToDTO(Feedbacks feedbacks) {
        return modelMapper.map(feedbacks, FeedbacksDTO.class);
    }
//    public List<UsersDTO> getAllUsers() {
//        return userRepository.findAll().stream()
//                .map(user -> convertToDTO(user))
//                .collect(Collectors.toList());
//    }
    public List<FeedbacksDTO> getAllFeedbacks(){
        return feedbackRopository.findAll().stream()
                .map(feedbacks -> convertToDTO(feedbacks))
                .collect(Collectors.toList());
    }
    public List<FeedbacksDTO> getAllFeedbacksByUserName(String userName){
        return feedbackRopository.findByUserName(userName).stream()
                .map(feedbacks -> convertToDTO(feedbacks))
                .collect(Collectors.toList());
    }
    public List<FeedbacksDTO> getAllFeedbacksByTourName(String tourName){
        return feedbackRopository.findByTourName(tourName).stream()
                .map(feedbacks -> convertToDTO(feedbacks))
                .collect(Collectors.toList());
    }

}
