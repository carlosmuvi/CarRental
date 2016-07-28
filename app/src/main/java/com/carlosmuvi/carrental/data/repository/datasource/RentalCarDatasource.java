package com.carlosmuvi.carrental.data.repository.datasource;

import com.carlosmuvi.carrental.domain.model.Car;
import java.util.List;
import org.joda.time.DateTime;

/**
 * Created by carlosmuvi on 28/07/16.
 */
public interface RentalCarDatasource {

    List<Car> searchCars(DateTime pickupDate, DateTime dropoffDate, String location);
}
