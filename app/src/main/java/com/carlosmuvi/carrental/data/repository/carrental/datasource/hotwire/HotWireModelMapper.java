package com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire;

import android.support.annotation.NonNull;
import com.annimon.stream.Optional;
import com.annimon.stream.Stream;
import com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.model.MetaData;
import com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.model.Result;
import com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.model.Type;
import com.carlosmuvi.carrental.domain.model.Car;
import com.carlosmuvi.carrental.domain.model.CarType;
import com.carlosmuvi.carrental.domain.model.Price;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class HotWireModelMapper {

    @Inject public HotWireModelMapper() {
    }

    List<Car> map(List<Result> model, MetaData carMetadata) {

        List<Car> cars = new ArrayList<>();

        for (Result result : model) {
            String carTypeCode = result.carTypeCode;
            Price price = mapPrice(result);
            CarType carType = mapCarType(result, carMetadata);
            String rentalPeriod = mapRentalPeriod(result);
            cars.add(new Car(price, carType, rentalPeriod));
        }

        return cars;
    }

    private String mapRentalPeriod(Result result) {
        return "from "
            + result.pickupDay
            + " "
            + result.pickupTime
            + " to "
            + result.dropoffDay
            + " "
            + result.dropoffTime;
    }

    private CarType mapCarType(Result result, MetaData carMetadata) {
        Optional<Type> currentCarType = Stream.of(carMetadata.carMetaData.carTypes)
            .filter(value -> value.carTypeCode.equalsIgnoreCase(result.carTypeCode))
            .findFirst();

        if (currentCarType.isPresent()) {
            Type type = currentCarType.get();
            return new CarType(type.carTypeCode, type.typicalSeating, type.possibleFeatures, type.possibleModels);
        } else {
            return new CarType("Unknown", "Unknown", "Unknown", "Unknown");
        }
    }

    @NonNull private Price mapPrice(Result result) {
        return new Price(Double.parseDouble(result.totalPrice), result.currencyCode);
    }
}
