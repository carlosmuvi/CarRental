package com.carlosmuvi.carrental.domain.model;

/**
 * Created by carlosmuvi on 28/07/16.
 */
public class CarType {
    private String carTypeCode;
    private String size;
    private String possibleFeatures;
    private String possibleModels;

    public CarType(String carTypeCode, String size, String possibleFeatures, String possibleModels) {
        this.carTypeCode = carTypeCode;
        this.size = size;
        this.possibleFeatures = possibleFeatures;
        this.possibleModels = possibleModels;
    }

    public String getCode() {
        return carTypeCode;
    }

    public String getSize() {
        return size;
    }

    public String getPossibleModels() {
        return possibleModels;
    }
}
