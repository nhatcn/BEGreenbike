package com.example.demo.Service;

import com.example.demo.Model.Users;
import com.example.demo.DTO.UsersDTO;
import com.example.demo.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UsersService {
    @Autowired
    private UsersRepository userRepository;

    private UsersDTO convertToDTO(Users user, boolean includePassword) {
        if (includePassword) {
            return new UsersDTO(
                    user.getUserId(),
                    user.getUserName(),
                    user.getName(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getStatus(), user.getPassword(), user.getAvatar()
            );
        } else {
            UsersDTO dto = new UsersDTO(
                    user.getUserId(),
                    user.getUserName(),
                    user.getName(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getStatus(),user.getAvatar()
            );
            dto.setPassword(null);
            return dto;
        }
    }

    public List<UsersDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> convertToDTO(user, false))
                .collect(Collectors.toList());
    }

    public Optional<UsersDTO> getUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> convertToDTO(user, false));
    }

    public Optional<UsersDTO> getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(user -> convertToDTO(user, false));
    }

    public Optional<UsersDTO> getUserByUserName(String userName) {
        return userRepository.findByUserName(userName)
                .map(user -> convertToDTO(user, false));
    }

    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    public Users updateUser(Long id, Users updatedUser) {
        Optional<Users> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            Users existingUser = userOptional.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPhone(updatedUser.getPhone());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setStatus(updatedUser.getStatus());
            existingUser.setRole(updatedUser.getRole());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UsersDTO login(String userName, String password) {
        Optional<Users> userOptional = userRepository.findByUserName(userName);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return convertToDTO(user, true);
            } else {
                throw new IllegalArgumentException("Invalid password");
            }
        } else {
            throw new IllegalArgumentException("Invalid user name or password");
        }
    }

    public static String generateRandomPassword() {
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            password.append(random.nextInt(10));
        }
        return password.toString();
    }
}
