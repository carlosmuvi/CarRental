package com.carlosmuvi.carrental.rentalcarsearchform;

import com.carlosmuvi.carrental.base.activity.ActivityComponent;
import com.carlosmuvi.carrental.base.activity.ActivityModule;
import com.carlosmuvi.carrental.base.activity.ActivityScope;
import com.carlosmuvi.carrental.base.application.AppComponent;
import dagger.Component;

/**
 * Created by carlosmuvi on 28/07/16.
 */
@ActivityScope @Component(dependencies = AppComponent.class, modules = {
    ActivityModule.class, RentalCarSearchFormModule.class
}) public interface RentalCarSearchFormComponent extends ActivityComponent {
    void inject(RentalCarSearchFormActivity rentalCarListActivity);

    RentalCarSearchFormPresenter getPresenter();
}
