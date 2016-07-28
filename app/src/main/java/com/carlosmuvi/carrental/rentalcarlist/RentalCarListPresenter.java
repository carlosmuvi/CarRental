package com.carlosmuvi.carrental.rentalcarlist;

import com.carlosmuvi.carrental.base.BasePresenter;
import com.carlosmuvi.carrental.base.BaseView;
import javax.inject.Inject;

/**
 * Created by carlosmuvi on 28/07/16.
 */
public class RentalCarListPresenter extends BasePresenter {

    @Inject public RentalCarListPresenter() {
    }

    public void estimulate(){
        getView().showMessage("Estimulated!");
    }

    public interface View extends BaseView {
    }
}
