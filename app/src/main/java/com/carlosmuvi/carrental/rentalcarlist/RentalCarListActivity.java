package com.carlosmuvi.carrental.rentalcarlist;

import com.carlosmuvi.carrental.R;
import com.carlosmuvi.carrental.base.BaseActivity;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class RentalCarListActivity extends BaseActivity<RentalCarListPresenter, RentalCarListPresenter.View> {

    @Override protected RentalCarListPresenter getPresenter() {
        return null;
    }

    @Override protected RentalCarListPresenter.View getView() {
        return null;
    }

    @Override protected int getLayoutId() {
        return R.layout.activity_rentalcarlist;
    }
}
