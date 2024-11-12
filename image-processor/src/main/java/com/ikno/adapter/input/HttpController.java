package com.ikno.adapter.input;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ikno.application.service.ImageProcessingService;
import com.ikno.domain.model.Image;

@RestController
@RequestMapping("/api/images")
public record HttpController(ImageProcessingService imageProcessingService) {

    @PostMapping("/convert")
    public ResponseEntity<?> convertImage(
            @RequestBody byte[] imageData,
            @RequestParam String targetFormat) {

        // Pasa los datos en crudo al servicio de aplicación
        Image convertedImage = imageProcessingService.processImage(imageData, targetFormat);

        return ResponseEntity.ok("Imagen convertida a formato: " + convertedImage.getFormat());
    }
}
