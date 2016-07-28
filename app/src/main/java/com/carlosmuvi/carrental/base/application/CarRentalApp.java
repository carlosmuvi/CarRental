package com.carlosmuvi.carrental.base.application;

import android.app.Application;
import net.danlew.android.joda.JodaTimeAndroid;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class CarRentalApp extends Application {

    private AppComponent appComponent;

    @Override public void onCreate() {
        super.onCreate();
        setupInjection();
        setupJodaTime();
    }

    private void setupJodaTime() {
        JodaTimeAndroid.init(this);
    }

    private void setupInjection() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getComponent() {
        return appComponent;
    }
}
