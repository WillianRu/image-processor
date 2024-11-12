package com.ikno.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ImageFormat {
    private final String format;

    public static ImageFormat png() {
        return new ImageFormat("PNG");
    }

    public static ImageFormat jpeg() {
        return new ImageFormat("JPEG");
    }

    public static ImageFormat fromString(String format) {
        return new ImageFormat(format.toUpperCase());
    }
}
