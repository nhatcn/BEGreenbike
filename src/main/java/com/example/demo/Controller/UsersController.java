// UsersController.java
package com.example.demo.Controller;

import com.example.demo.DTO.UsersDTO;
import com.example.demo.Model.Users;
import com.example.demo.Service.UsersService;
import jakarta.mail.MessagingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import jakarta.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private UsersService userService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping
    public List<UsersDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> getUserById(@PathVariable Long id) {
        Optional<UsersDTO> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody UsersDTO userDTO) {

        if (userService.getUserByUserName(userDTO.getUserName()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists.");
        }

        Users newUser = new Users();
        newUser.setName(userDTO.getName());
        newUser.setUserName(userDTO.getUserName());
        newUser.setPassword(userDTO.getPassword());
        newUser.setEmail(userDTO.getEmail());
        newUser.setPhone(userDTO.getPhone());
        newUser.setStatus(userDTO.getStatus());
        newUser.setAvatar(userDTO.getAvatar());

        try {
            userService.createUser(newUser);
            return ResponseEntity.ok("User registered successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to register user. Please try again.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UsersDTO> login(@RequestParam String userName, @RequestParam String password) {
        try {
            UsersDTO userDTO = userService.login(userName, password);
            return ResponseEntity.ok(userDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PutMapping("/forgotPassword/{id}")
    public ResponseEntity<Users> forgotPassword(@PathVariable Long id, @RequestParam String email) {
        Optional<UsersDTO> optionalUserDto = userService.getUserByEmail(email);

        if (optionalUserDto.isPresent()) {
            UsersDTO userDto = optionalUserDto.get();

            Users user = modelMapper.map(userDto, Users.class);
          String newPassword= userService.generateRandomPassword();
            user.setPassword(newPassword);

            Users updatedUser = userService.updateUser(id, user);

            if (updatedUser != null) {
                sendEmail(email,newPassword,updatedUser.getUserName());
                return ResponseEntity.ok(updatedUser);
            }
        }

        return ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users updatedUser) {
        Users user = userService.updateUser(id, updatedUser);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    public void sendEmail(String toEmail, String password, String user) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(toEmail);


            helper.setSubject("Password Reset");

            String htmlContent = "<p style=\"color: #333; font-size: 16px;\">Dear "+user+",</p>"
                    + "<p style=\"color: #333; font-size: 16px;\">Your new password is: <span style=\"font-size: 32px; background-color: #f0f0f0; padding: 5px;\">"
                    + password + "</span></p>"
                    + "<p style=\"color: #333; font-size: 16px;\">Thank you for using our service.</p>"
                    + "<p style=\"color: #333; font-size: 16px;\">Best regards,<br>Group1-SE1712</p>";

            // Set HTML content to the email body
            helper.setText(htmlContent, true);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            // Handle the exception (e.g., log it) as needed
            e.printStackTrace();
        }
    }
}
