package com.carlosmuvi.carrental.domain.model;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class Car {
    private String model;
    private String brand;
    private double price;
    private String pictureUrl;

    public Car(String model, String brand, double price, String pictureUrl) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }

    public String getModel() {
        return model;
    }
}
