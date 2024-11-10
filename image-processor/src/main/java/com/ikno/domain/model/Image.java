package com.ikno.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Image {
    private final byte[] data;
    private ImageFormat format;
    private final String name;

    public void changeFormat(ImageFormat newFormat) {
        this.format = newFormat;
    }
}
