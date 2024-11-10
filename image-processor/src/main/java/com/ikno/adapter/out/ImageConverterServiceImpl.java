package com.ikno.adapter.out;

import com.ikno.domain.model.Image;
import com.ikno.domain.model.ImageFormat;
import com.ikno.domain.service.ImageConverterService;

public class ImageConverterServiceImpl implements ImageConverterService{
    @Override
    public Image convertToFormat(Image image, ImageFormat targetFormat) {
        System.out.println("Convirtiendo imagen a formato " + targetFormat.getFormat());
        
        byte[] convertedData = image.getData();  

        return new Image(convertedData, targetFormat, image.getName());
    }
}
