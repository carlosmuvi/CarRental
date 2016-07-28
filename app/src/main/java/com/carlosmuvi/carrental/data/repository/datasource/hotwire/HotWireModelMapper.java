package com.carlosmuvi.carrental.data.repository.datasource.hotwire;

import com.annimon.stream.Stream;
import com.annimon.stream.function.Function;
import com.carlosmuvi.carrental.domain.model.Car;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class HotWireModelMapper {

    public void map(HotWireApiCarModel.Result model) {
        Stream.of(model).map(new Function<HotWireApiCarModel.Result, Car>() {
            @Override public Car apply(HotWireApiCarModel.Result result) {
                String model = result.carTypeCode;
                double price = Double.parseDouble(result.totalPrice);
                return new Car(model, model, price);
            }
        });
    }
}
