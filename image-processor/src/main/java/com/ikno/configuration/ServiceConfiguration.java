package com.ikno.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ikno.application.service.ImageProcessingService;
import com.ikno.domain.service.ImageConverterService;

@Configuration
public class ServiceConfiguration {
    @Bean
    public ImageProcessingService imageProcessingService(ImageConverterService imageConverterService) {
        return new ImageProcessingService(imageConverterService);
    }
}
