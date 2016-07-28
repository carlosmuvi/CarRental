package com.carlosmuvi.carrental.rentalcarlist.usecases;

import com.carlosmuvi.carrental.data.repository.carrental.CarRentalRepository;
import com.carlosmuvi.carrental.data.repository.carrental.specification.CarsByLocationAndDatetimeSpecification;
import com.carlosmuvi.carrental.data.repository.error.RepositoryException;
import com.carlosmuvi.carrental.domain.SimpleListener;
import com.carlosmuvi.carrental.domain.UseCase;
import com.carlosmuvi.carrental.domain.model.Car;
import com.carlosmuvi.carrental.domain.threading.Executor;
import com.carlosmuvi.carrental.domain.threading.MainThread;
import java.util.List;
import javax.inject.Inject;
import org.joda.time.DateTime;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class GetAvailableCars extends UseCase {

    private final CarRentalRepository carRentalRepository;
    private DateTime pickup;
    private DateTime dropoff;
    private String location;
    private SimpleListener<List<Car>> listener;

    @Inject
    public GetAvailableCars(Executor threadExecutor, MainThread mainThread, CarRentalRepository carRentalRepository) {
        super(threadExecutor, mainThread);
        this.carRentalRepository = carRentalRepository;
    }

    public void execute(DateTime pickup, DateTime dropoff, String location, SimpleListener<List<Car>> listener) {
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.location = location;
        this.listener = listener;
        threadExecutor.run(this);
    }

    @Override public void run() {
        try {
            List<Car> carList =
                carRentalRepository.query(new CarsByLocationAndDatetimeSpecification(pickup, dropoff, location));
            mainThread.post(() -> listener.onSuccess(carList));
        } catch (RepositoryException e) {
            mainThread.post(() -> listener.onError(e));
        }
    }
}
