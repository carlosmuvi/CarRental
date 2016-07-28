package com.carlosmuvi.carrental.rentalcarlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.carlosmuvi.carrental.R;
import com.carlosmuvi.carrental.domain.model.Car;
import com.pedrogomez.renderers.Renderer;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class CarRenderer extends Renderer<Car> {

    @Bind(R.id.listitem_car_title) TextView titleTextView;
    @Bind(R.id.listitem_car_selection) TextView subtitleTextView;
    @Bind(R.id.listitem_car_price) TextView priceTextView;

    @Override protected void setUpView(View rootView) {

    }

    @Override protected void hookListeners(View rootView) {

    }

    @Override protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        View inflatedView = inflater.inflate(R.layout.listitem_car, parent, false);
        ButterKnife.bind(this, inflatedView);
        return inflatedView;
    }

    @Override public void render() {
        Car car = getContent();
        bindCarTitle(car);
        bindCarSubtitle(car);
        bindCarPrice(car);
    }

    private void bindCarPrice(Car car) {
        priceTextView.setText(car.getPrice());
    }

    private void bindCarSubtitle(Car car) {
        titleTextView.setText(car.getModel());
    }

    private void bindCarTitle(Car car) {
        subtitleTextView.setText(car.getSize());
    }
}
