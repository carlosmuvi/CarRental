package com.carlosmuvi.carrental.domain.model;

/**
 * Created by carlosmuvi on 28/07/16.
 */
public class Price {
    private double subTotal;
    private String currency;

    public Price(double subTotal, String currency) {
        this.subTotal = subTotal;
        this.currency = currency;
    }

    @Override public String toString() {
        return String.valueOf(subTotal) + " " + currency;
    }
}
