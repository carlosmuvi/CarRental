package com.carlosmuvi.carrental.rentalcarsearchform;

import com.carlosmuvi.carrental.base.BasePresenter;
import com.carlosmuvi.carrental.base.BaseView;
import com.carlosmuvi.carrental.navigator.Navigator;
import javax.inject.Inject;

/**
 * Created by carlosmuvi on 28/07/16.
 */
public class RentalCarSearchFormPresenter extends BasePresenter<RentalCarSearchFormPresenter.View> {

    public static final String DROPOFF_TIME_KEY = "dropoff_time_key";
    public static final String DROPOFF_DATE_KEY = "dropoff_date_key";
    public static final String PICKUP_DATE_KEY = "pickup_date_key";
    public static final String PICKUP_TIME_KEY = "pickup_time_key";

    private Navigator navigator;

    @Inject public RentalCarSearchFormPresenter(Navigator navigator) {
        this.navigator = navigator;
    }

    public void onDropoffDateTimeClick() {
        getView().showTimePicker(DROPOFF_TIME_KEY);
        getView().showDatePicker(DROPOFF_DATE_KEY);
    }

    public void onPickupDateTimeClick() {
        getView().showTimePicker(PICKUP_TIME_KEY);
        getView().showDatePicker(PICKUP_DATE_KEY);
    }

    public void onDropOffDateTimePicked(DateTimeWrapper datetime) {
        getView().showDropoffDateTimeText(datetime.getDateTime().toString());
    }

    public void onPickupDateTimePicked(DateTimeWrapper datetime) {
        getView().showPickupDateTimeText(datetime.getDateTime().toString());
    }

    public void onSubmitClicked(DateTimeWrapper pickup, DateTimeWrapper dropoff, String location) {
        navigator.navigateToCarRentalList(pickup.getDateTime(), dropoff.getDateTime(), location);
    }

    public interface View extends BaseView {
        void showDatePicker(String key);

        void showTimePicker(String key);

        void showDropoffDateTimeText(String dateTimeText);

        void showPickupDateTimeText(String dateTimeText);
    }
}
