package com.carlosmuvi.carrental.rentalcarsearchform;

import com.carlosmuvi.carrental.base.BasePresenter;
import com.carlosmuvi.carrental.base.BaseView;
import com.carlosmuvi.carrental.navigator.Navigator;
import javax.inject.Inject;
import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;

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

    public void onSubmitClicked(boolean dropoffDatePicked, boolean dropoffTimePicked, boolean pickupDatePicked,
        boolean pickupTimePicked, MutableDateTime pickup, MutableDateTime dropoff, String location) {

        if (validateInput(dropoffDatePicked, dropoffTimePicked, pickupDatePicked, pickupTimePicked, pickup, dropoff,
            location)) {
            navigator.navigateToCarRentalList(new DateTime(pickup), new DateTime(dropoff), location);
        }
    }

    private boolean validateInput(boolean dropoffDatePicked, boolean dropoffTimePicked, boolean pickupDatePicked,
        boolean pickupTimePicked, MutableDateTime pickup, MutableDateTime dropoff, String location) {
        if (!(dropoffDatePicked && dropoffTimePicked && pickupDatePicked && pickupTimePicked)) {
            getView().showMessage("Select all dates before continue!");
            return false;
        } else if (pickup.isAfter(dropoff)) {
            getView().showMessage("Pickup date should be before dropoff date!");
            return false;
        } else if (location.isEmpty()) {
            getView().showMessage("Select location before continue!");
            return false;
        } else {
            return true;
        }
    }

    public void onDropoffDate() {
        getView().showDatePicker(DROPOFF_DATE_KEY);
    }

    public void onDropoffTime() {
        getView().showTimePicker(DROPOFF_TIME_KEY);
    }

    public void onPickupDate() {
        getView().showDatePicker(PICKUP_DATE_KEY);
    }

    public void onPickupTime() {
        getView().showTimePicker(PICKUP_TIME_KEY);
    }

    public void onDropoffTimePicked(MutableDateTime datetime) {
        getView().showDropoffTimeText(datetime.toString("HH:mm"));
    }

    public void onPickupTimePicked(MutableDateTime datetime) {
        getView().showPickupTimeText(datetime.toString("HH:mm"));
    }

    public void onPickupDatePicked(MutableDateTime datetime) {
        getView().showPickupDateText(datetime.toString("MM/dd/yyyy"));
    }

    public void onDropoffDatePicked(MutableDateTime datetime) {
        getView().showDropoffDateText(datetime.toString("MM/dd/yyyy"));
    }

    public interface View extends BaseView {
        void showDatePicker(String key);

        void showTimePicker(String key);

        void showDropoffDateText(String dateTimeText);

        void showPickupTimeText(String dateTimeText);

        void showDropoffTimeText(String dateTimeText);

        void showPickupDateText(String dateTimeText);
    }
}
