package com.carlosmuvi.carrental.application;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by carlosmuvi on 28/07/16.
 */

@Module public class AppModule {

    private final CarRentalApp app;

    public AppModule(CarRentalApp app) {
        this.app = app;
    }

    @Provides @Singleton Context provideAppContext() {
        return this.app;
    }
}