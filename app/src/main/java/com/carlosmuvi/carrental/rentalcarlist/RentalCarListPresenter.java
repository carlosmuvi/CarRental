package com.carlosmuvi.carrental.rentalcarlist;

import com.carlosmuvi.carrental.base.BasePresenter;
import com.carlosmuvi.carrental.base.BaseView;
import com.carlosmuvi.carrental.domain.SimpleListener;
import com.carlosmuvi.carrental.domain.model.Car;
import com.carlosmuvi.carrental.rentalcarlist.usecases.GetAvailableCars;
import java.util.List;
import javax.inject.Inject;
import org.joda.time.DateTime;

/**
 * Created by carlosmuvi on 28/07/16.
 */
public class RentalCarListPresenter extends BasePresenter<RentalCarListPresenter.View> {

    GetAvailableCars getAvailableCars;

    @Inject public RentalCarListPresenter(GetAvailableCars getAvailableCars) {
        this.getAvailableCars = getAvailableCars;
    }

    public void searchForAvailableCars(DateTime pickup, DateTime dropoff, String location) {
        getAvailableCars.execute(pickup, dropoff, location, new SimpleListener<List<Car>>() {
            @Override public void onSuccess(List<Car> cars) {

                if (cars.isEmpty()) {
                    getView().showMessage("No available cars found!");
                } else {
                    getView().showMessage(cars.get(0).getModel());
                    getView().renderCarList(cars);
                }
            }

            @Override public void onError(Exception error) {
                getView().showMessage(error.getMessage());
            }
        });
    }

    public interface View extends BaseView {
        void renderCarList(List<Car> cars);
    }
}
