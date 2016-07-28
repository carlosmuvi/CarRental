package com.carlosmuvi.carrental.rentalcarlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.Bind;
import com.carlosmuvi.carrental.R;
import com.carlosmuvi.carrental.base.activity.ActivityModule;
import com.carlosmuvi.carrental.base.activity.BaseActivity;
import com.carlosmuvi.carrental.constants.BundleConstants;
import com.carlosmuvi.carrental.domain.model.Car;
import com.pedrogomez.renderers.AdapteeCollection;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;
import java.util.List;
import org.joda.time.DateTime;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class RentalCarListActivity
    extends BaseActivity<RentalCarListComponent, RentalCarListPresenter, RentalCarListPresenter.View>
    implements RentalCarListPresenter.View {

    @Bind(R.id.car_rental_list) RecyclerView carRentalList;

    @Override protected RentalCarListPresenter getPresenter() {
        return component.getPresenter();
    }

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DateTime pickup = (DateTime) getIntent().getSerializableExtra(BundleConstants.PICKUP_DATETIME);
        DateTime dropoff = (DateTime) getIntent().getSerializableExtra(BundleConstants.DROPOFF_DATETIME);
        String location = getIntent().getStringExtra(BundleConstants.LOCATION);
        presenter.searchForAvailableCars(pickup, dropoff, location);
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

    @Override public void renderCarList(List<Car> cars) {
        carRentalList.setLayoutManager(new LinearLayoutManager(this));

        Renderer<Car> renderer = new CarRenderer();
        RendererBuilder<Car> rendererBuilder = new RendererBuilder<>(renderer);
        AdapteeCollection<Car> collection = new ListAdapteeCollection<>(cars);
        RVRendererAdapter<Car> adapter = new RVRendererAdapter<>(rendererBuilder, collection);

        carRentalList.setAdapter(adapter);
    }
}
