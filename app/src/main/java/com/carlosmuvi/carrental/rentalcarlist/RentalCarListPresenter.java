package com.carlosmuvi.carrental.rentalcarlist;

import com.carlosmuvi.carrental.base.BasePresenter;
import com.carlosmuvi.carrental.base.BaseView;
import com.carlosmuvi.carrental.domain.SimpleListener;
import com.carlosmuvi.carrental.domain.model.Car;
import com.carlosmuvi.carrental.rentalcarlist.usecases.GetAvailableCars;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by carlosmuvi on 28/07/16.
 */
public class RentalCarListPresenter extends BasePresenter {

    GetAvailableCars getAvailableCars;

    @Inject public RentalCarListPresenter(GetAvailableCars getAvailableCars) {
        this.getAvailableCars = getAvailableCars;
    }

    public void estimulate(){
        getAvailableCars.execute(new SimpleListener<List<Car>>() {
            @Override public void onSuccess(List<Car> cars) {
                getView().showMessage(cars.get(0).getModel());
            }

            @Override public void onError(Exception error) {

            }
        });
    }

    public interface View extends BaseView {
    }
}
