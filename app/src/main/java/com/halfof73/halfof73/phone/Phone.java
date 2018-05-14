package com.halfof73.halfof73.phone;

import java.io.Serializable;

class Phone implements Serializable {
    private int imageId;
    private String name;
    private String ms;

    public Phone(int imageId, String name, String ms) {
        this.imageId = imageId;
        this.name = name;
        this.ms = ms;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getMs() {
        return ms;
    }
}
