package com.carlosmuvi.carrental.rentalcarlist.usecases;

import com.carlosmuvi.carrental.domain.SimpleListener;
import com.carlosmuvi.carrental.domain.UseCase;
import com.carlosmuvi.carrental.domain.model.Car;
import com.carlosmuvi.carrental.domain.threading.Executor;
import com.carlosmuvi.carrental.domain.threading.MainThread;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class GetAvailableCars extends UseCase {

    private SimpleListener<List<Car>> listener;

    @Inject public GetAvailableCars(Executor threadExecutor, MainThread mainThread) {
        super(threadExecutor, mainThread);
    }

    public void execute(SimpleListener<List<Car>> listener) {
        this.listener = listener;
        threadExecutor.run(this);
    }

    @Override public void run() {
        //TODO run here.
        Car car = new Car("A", "B", 0.0);
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car);
        mainThread.post(() -> listener.onSuccess(cars));
    }
}
