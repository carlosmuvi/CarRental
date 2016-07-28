package com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire;

import com.annimon.stream.Stream;
import com.carlosmuvi.carrental.domain.model.Car;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class HotWireModelMapper {

    @Inject public HotWireModelMapper() {
    }

    List<Car> map(HotWireApiCarModel.Result model) {
        Car[] array = (Car[]) Stream.of(model).map(result -> {
            String carTypeCode = result.carTypeCode;
            double price = Double.parseDouble(result.totalPrice);
            return new Car(carTypeCode, carTypeCode, price);
        }).toArray();

        return Arrays.asList(array);
    }
}
