package com.example.demo.Config;

import org.modelmapper.ModelMapper;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Converter để ánh xạ từ String sang Timestamp với microseconds
        Converter<String, Timestamp> stringToTimestampConverter = new Converter<>() {
            @Override
            public Timestamp convert(MappingContext<String, Timestamp> context) {
                if (context.getSource() == null || context.getSource().isEmpty()) {
                    return null;
                }
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
                    LocalDateTime localDateTime = LocalDateTime.parse(context.getSource(), formatter);
                    return Timestamp.valueOf(localDateTime);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Invalid date format: " + context.getSource());
                }
            }
        };

        modelMapper.addConverter(stringToTimestampConverter);
        return modelMapper;
    }
}
