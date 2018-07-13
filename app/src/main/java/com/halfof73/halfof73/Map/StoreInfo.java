package com.halfof73.halfof73.Map;

public class StoreInfo {
    private int storeID, storeImg;
    private String storeName,storeAddress;
    private double Latitude,Longitude;

    public StoreInfo() {
    }

    public StoreInfo(int storeID, int storeImg, String storeName, String storeAddress, double Latitude, double Longitude) {
        this.storeID = storeID;
        this.storeImg = storeImg;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public int getStoreImg() {
        return storeImg;
    }

    public void setStoreImg(int storeImg) {
        this.storeImg = storeImg;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }
}
