package com.carlosmuvi.carrental.rentalcarsearchform;

import com.carlosmuvi.carrental.R;
import com.carlosmuvi.carrental.base.activity.ActivityModule;
import com.carlosmuvi.carrental.base.activity.BaseActivity;

public class RentalCarSearchFormActivity
    extends BaseActivity<RentalCarSearchFormComponent, RentalCarSearchFormPresenter, RentalCarSearchFormPresenter.View>
    implements RentalCarSearchFormPresenter.View {

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
}
