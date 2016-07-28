package com.carlosmuvi.carrental.domain.model;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class Car {
    private Price price;
    private CarType carType;

    public Car(Price price, CarType carType) {
        this.price = price;
        this.carType = carType;
    }

    public String getModel() {
        return carType.getCode();
    }
}
