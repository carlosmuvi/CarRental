package com.carlosmuvi.carrental.application;

import android.app.Application;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class CarRentalApp extends Application {

    private AppComponent appComponent;

    @Override public void onCreate() {
        super.onCreate();
        setupInjection();
    }

    private void setupInjection() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}
