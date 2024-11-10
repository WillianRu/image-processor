package com.ikno.domain.service;

import com.ikno.domain.model.Image;
import com.ikno.domain.model.ImageFormat;

public interface ImageConverterService {
        Image convertToFormat(Image image, ImageFormat targetFormat);
}
