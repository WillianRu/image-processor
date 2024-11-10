package com.ikno.adapter.in;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ikno.application.service.ImageProcessingService;
import com.ikno.domain.model.Image;
import com.ikno.domain.model.ImageFormat;

@RestController
@RequestMapping("/api/images")
public record HttpController(ImageProcessingService imageProcessingService) {
    @PostMapping("/convert")
    public ResponseEntity<String> convertImage(
            @RequestBody byte[] imageData,
            @RequestParam String targetFormat) {
        Image originalImage = new Image(imageData, ImageFormat.jpeg(), "imagenOriginal");

        ImageFormat format;
        if ("PNG".equalsIgnoreCase(targetFormat)) {
            format = ImageFormat.png();
        } else if ("JPEG".equalsIgnoreCase(targetFormat)) {
            format = ImageFormat.jpeg();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Formato de destino no soportado");
        }

        Image convertedImage = imageProcessingService.processImage(originalImage, format);

        return ResponseEntity.ok("Imagen convertida a formato: " + convertedImage.getFormat());
    }
}
