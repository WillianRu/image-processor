package com.ikno.application.service;


import com.ikno.domain.model.Image;
import com.ikno.domain.model.ImageFormat;
import com.ikno.domain.service.ImageConverterService;


public class ImageProcessingService {
    private final ImageConverterService imageConverter;

    public ImageProcessingService(ImageConverterService imageConverter) {
        this.imageConverter = imageConverter;
    }

    public Image processImage(byte[] imageData, String targetFormat) {
        ImageFormat format;
        if ("PNG".equalsIgnoreCase(targetFormat)) {
            format = ImageFormat.png();
        } else if ("JPEG".equalsIgnoreCase(targetFormat)) {
            format = ImageFormat.jpeg();
        } else {
            throw new IllegalArgumentException("Unsupported target format: " + targetFormat);
        }

        Image image = new Image(imageData, ImageFormat.jpeg(), "originalImage");

        return imageConverter.convertToFormat(image, format);
    }
}
