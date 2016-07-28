package com.carlosmuvi.carrental.rentalcarsearchform;

import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;
import com.carlosmuvi.carrental.R;
import com.carlosmuvi.carrental.base.activity.ActivityModule;
import com.carlosmuvi.carrental.base.activity.BaseActivity;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import java.util.Calendar;
import org.joda.time.Duration;
import org.joda.time.MutableDateTime;

public class RentalCarSearchFormActivity
    extends BaseActivity<RentalCarSearchFormComponent, RentalCarSearchFormPresenter, RentalCarSearchFormPresenter.View>
    implements RentalCarSearchFormPresenter.View {

    @Bind(R.id.pickup_time_selection) TextView pickupTimeText;
    @Bind(R.id.pickup_date_selection) TextView pickupDateText;
    @Bind(R.id.dropoff_time_selection) TextView dropOffTimeText;
    @Bind(R.id.dropoff_date_selection) TextView dropOffDateText;

    private boolean dropoffDatePicked, dropoffTimePicked, pickupDatePicked, pickupTimePicked;

    private MutableDateTime selectedDropOffDatetime = new MutableDateTime();
    private MutableDateTime selectedPickupDatetime = new MutableDateTime();

    @Override protected RentalCarSearchFormPresenter getPresenter() {
        return component.getPresenter();
    }

    @Override protected RentalCarSearchFormComponent buildComponent() {
        return DaggerRentalCarSearchFormComponent.builder()
            .appComponent(getAppComponent())
            .activityModule(new ActivityModule(this))
            .build();
    }

    @Override protected void bindComponent() {
        component.inject(this);
    }

    @Override protected RentalCarSearchFormPresenter.View getView() {
        return this;
    }

    @Override protected int getLayoutId() {
        return R.layout.activity_rental_car_search_form;
    }

    @OnClick(R.id.dropoff_date_container) public void onDropoffDate() {
        presenter.onDropoffDate();
    }

    @OnClick(R.id.dropoff_time_container) public void onDropoffTime() {
        presenter.onDropoffTime();
    }

    @OnClick(R.id.pickup_date_container) public void onPickupDate() {
        presenter.onPickupDate();
    }

    @OnClick(R.id.pickup_time_container) public void onPickupTime() {
        presenter.onPickupTime();
    }

    @OnClick(R.id.button_submit_form) public void onSubmitClicked() {
        presenter.onSubmitClicked(selectedPickupDatetime, selectedDropOffDatetime, "LAX");
    }

    @Override public void showDatePicker(String key) {
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance((view, year, monthOfYear, dayOfMonth) -> {
            if (key.equals(RentalCarSearchFormPresenter.DROPOFF_DATE_KEY)) {
                selectedDropOffDatetime.setYear(year);
                selectedDropOffDatetime.setMonthOfYear(monthOfYear+1);
                selectedDropOffDatetime.setDayOfMonth(dayOfMonth);
                dropoffDatePicked = true;
                presenter.onDropoffDatePicked(selectedDropOffDatetime);
            } else {
                selectedPickupDatetime.setYear(year);
                selectedPickupDatetime.setMonthOfYear(monthOfYear+1);
                selectedPickupDatetime.setDayOfMonth(dayOfMonth);
                pickupDatePicked = true;
                presenter.onPickupDatePicked(selectedPickupDatetime);
            }
        }, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
        dpd.show(getFragmentManager(), key);
    }

    @Override public void showTimePicker(String key) {
        Calendar now = Calendar.getInstance();
        TimePickerDialog tpd = TimePickerDialog.newInstance((view, hourOfDay, minute, second) -> {
            if (key.equals(RentalCarSearchFormPresenter.DROPOFF_TIME_KEY)) {
                selectedDropOffDatetime.setTime(hourOfDay, minute, second, 0);
                selectedDropOffDatetime = roundDate(selectedDropOffDatetime, 30);
                dropoffTimePicked = true;
                presenter.onDropoffTimePicked(selectedDropOffDatetime);
            } else {
                selectedPickupDatetime.setTime(hourOfDay, minute, second, 0);
                selectedPickupDatetime = roundDate(selectedPickupDatetime, 30);
                pickupTimePicked = true;
                presenter.onPickupTimePicked(selectedPickupDatetime);
            }
        }, now.get(Calendar.HOUR), now.get(Calendar.MINUTE), true);
        tpd.show(getFragmentManager(), key);
    }

    @Override public void showDropoffDateText(String dateTimeText) {
        dropOffDateText.setText(dateTimeText);
    }

    @Override public void showPickupTimeText(String dateTimeText) {
        pickupTimeText.setText(dateTimeText);
    }

    @Override public void showDropoffTimeText(String dateTimeText) {
        dropOffTimeText.setText(dateTimeText);
    }

    @Override public void showPickupDateText(String dateTimeText) {
        pickupDateText.setText(dateTimeText);
    }

    private MutableDateTime roundDate(final MutableDateTime dateTime, final int minutes) {
        if (minutes < 1 || 60 % minutes != 0) {
            throw new IllegalArgumentException("minutes must be a factor of 60");
        }

        final MutableDateTime hour = dateTime.hourOfDay().roundFloor();
        final long millisSinceHour = new Duration(hour, dateTime).getMillis();
        final int roundedMinutes = ((int) Math.round(millisSinceHour / 60000.0 / minutes)) * minutes;
        hour.addMinutes(roundedMinutes);
        return hour;
    }
}
