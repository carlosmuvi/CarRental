package com.carlosmuvi.carrental.domain.model;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class Car {
    private Price price;
    private CarType carType;
    private String rentalPeriod;

    public Car(Price price, CarType carType, String rentalPeriod) {
        this.price = price;
        this.carType = carType;
        this.rentalPeriod = rentalPeriod;
    }

    public String getModel() {
        return carType.getPossibleModels();
    }

    public String getPrice() {
        return price.toString();
    }

    public String getSize() {
        return carType.getSize();
    }

    public String getRentalPeriod() {
        return rentalPeriod;
    }
}
