package com.halfof73.halfof73.team;


import java.io.Serializable;

class Team implements Serializable {
    private int imageId;
    private String name;
    private String price;
    private String history;

    public Team(int imageId, String name, String price, String history) {
        this.imageId = imageId;
        this.name = name;
        this.price = price;
        this.history = history;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {this.price = price;}
}

