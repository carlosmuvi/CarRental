package com.carlosmuvi.carrental.rentalcarlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.carlosmuvi.carrental.R;
import com.carlosmuvi.carrental.base.activity.ActivityModule;
import com.carlosmuvi.carrental.base.activity.BaseActivity;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class RentalCarListActivity
    extends BaseActivity<RentalCarListComponent, RentalCarListPresenter, RentalCarListPresenter.View>
    implements RentalCarListPresenter.View {

    @Override protected RentalCarListPresenter getPresenter() {
        return component.getPresenter();
    }

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.estimulate();
    }

    @Override protected RentalCarListComponent buildComponent() {
        return DaggerRentalCarListComponent.builder()
            .appComponent(getAppComponent())
            .activityModule(new ActivityModule(this))
            .build();
    }

    @Override protected RentalCarListPresenter.View getView() {
        return this;
    }

    @Override protected void bindComponent() {
        component.inject(this);
    }

    @Override protected int getLayoutId() {
        return R.layout.activity_rentalcarlist;
    }
}
