package com.carlosmuvi.carrental.rentalcarsearchform;

import android.widget.TextView;
import butterknife.Bind;
import butterknife.OnClick;
import com.carlosmuvi.carrental.R;
import com.carlosmuvi.carrental.base.activity.ActivityModule;
import com.carlosmuvi.carrental.base.activity.BaseActivity;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import java.util.Calendar;

public class RentalCarSearchFormActivity
    extends BaseActivity<RentalCarSearchFormComponent, RentalCarSearchFormPresenter, RentalCarSearchFormPresenter.View>
    implements RentalCarSearchFormPresenter.View, DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {

    @Bind(R.id.dropoff_datetime_selection) TextView dropOffDateTimeText;
    @Bind(R.id.pickup_datetime_selection) TextView pickupDateTimeText;

    DateTimeWrapper selectedDropOffDatetime = new DateTimeWrapper();
    DateTimeWrapper selectedPickupDatetime = new DateTimeWrapper();

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

    @OnClick(R.id.dropoff_datetime_container) public void onDropoffDateTimeClick() {
        presenter.onDropoffDateTimeClick();
    }

    @OnClick(R.id.pickup_datetime_container) public void onPickupDateTimeClick() {
        presenter.onPickupDateTimeClick();
    }

    @OnClick(R.id.button_submit_form) public void onSubmitClicked() {
        presenter.onSubmitClicked(selectedPickupDatetime, selectedDropOffDatetime, "LAX");
    }

    @Override public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        if (view.getTag() == RentalCarSearchFormPresenter.DROPOFF_DATE_KEY) {
            selectedDropOffDatetime.getDateTime().withDate(year, monthOfYear, dayOfMonth);
        } else {
            selectedPickupDatetime.getDateTime().withDate(year, monthOfYear, dayOfMonth);
        }
    }

    @Override public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        if (view.getTag() == RentalCarSearchFormPresenter.DROPOFF_TIME_KEY) {
            selectedDropOffDatetime.getDateTime().withTime(hourOfDay, minute, second, 0);
            presenter.onDropOffDateTimePicked(selectedDropOffDatetime);
        } else {
            selectedPickupDatetime.getDateTime().withTime(hourOfDay, minute, second, 0);
            presenter.onPickupDateTimePicked(selectedPickupDatetime);
        }
    }

    @Override public void showDatePicker(String key) {
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(RentalCarSearchFormActivity.this, now.get(Calendar.YEAR),
            now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
        dpd.show(getFragmentManager(), key);
    }

    @Override public void showTimePicker(String key) {
        Calendar now = Calendar.getInstance();
        TimePickerDialog tpd = TimePickerDialog.newInstance(RentalCarSearchFormActivity.this, now.get(Calendar.HOUR),
            now.get(Calendar.MINUTE), true);
        tpd.show(getFragmentManager(), key);
    }

    @Override public void showDropoffDateTimeText(String dateTimeText) {
        dropOffDateTimeText.setText(dateTimeText);
    }

    @Override public void showPickupDateTimeText(String dateTimeText) {
        pickupDateTimeText.setText(dateTimeText);
    }
}
