package com.carlosmuvi.carrental.data.repository.carrental;

import com.carlosmuvi.carrental.data.repository.base.ReadableRepository;
import com.carlosmuvi.carrental.data.repository.carrental.datasource.CarRentalDatasource;
import com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.error.APIException;
import com.carlosmuvi.carrental.data.repository.carrental.specification.CarRentalSpecification;
import com.carlosmuvi.carrental.data.repository.error.RepositoryException;
import com.carlosmuvi.carrental.domain.model.Car;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class CarRentalRepository implements ReadableRepository<Car, CarRentalSpecification> {

    private CarRentalDatasource carRentalDatasource;

    @Inject public CarRentalRepository(CarRentalDatasource carRentalDatasource) {
        this.carRentalDatasource = carRentalDatasource;
    }

    @Override public List<Car> query(CarRentalSpecification specification) throws RepositoryException {
        try {
            //TODO select data from different datasources (just one available yet).
            return carRentalDatasource.query(specification);
        } catch (APIException e) {
            throw new RepositoryException(e.getMessage());
        }
    }
}
