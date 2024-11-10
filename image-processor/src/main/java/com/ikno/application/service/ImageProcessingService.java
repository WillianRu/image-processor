package com.ikno.application.service;

import com.ikno.domain.model.Image;
import com.ikno.domain.model.ImageFormat;
import com.ikno.domain.service.ImageConverterService;

public record ImageProcessingService(ImageConverterService imageConverter ) {
    public Image processImage(Image image, ImageFormat targetFormat) {
        return imageConverter.convertToFormat(image, targetFormat);
    }
}
