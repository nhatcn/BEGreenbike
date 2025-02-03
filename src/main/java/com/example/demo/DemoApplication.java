package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("DATABASE_USER: " + System.getenv("DATABASE_USER"));
        System.out.println("DATABASE_PASSWORD: " + System.getenv("DATABASE_PASSWORD"));
        System.out.println("DATABASE_URL: " + System.getenv("DATABASE_URL"));
        SpringApplication.run(DemoApplication.class, args);
    }


}
