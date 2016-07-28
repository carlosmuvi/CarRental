package com.carlosmuvi.carrental.data.repository.carrental.datasource;

import com.carlosmuvi.carrental.data.repository.carrental.specification.CarRentalSpecification;
import com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.error.APIException;
import com.carlosmuvi.carrental.domain.model.Car;
import java.util.List;

/**
 * Created by carlosmuvi on 28/07/16.
 */
public interface CarRentalDatasource {

    List<Car> query(CarRentalSpecification specification) throws APIException;
}
