package com.carlosmuvi.carrental.base.application;

import android.content.Context;
import com.carlosmuvi.carrental.domain.threading.Executor;
import com.carlosmuvi.carrental.domain.threading.MainThread;
import com.carlosmuvi.carrental.domain.threading.ThreadExecutor;
import com.carlosmuvi.carrental.domain.threading.UIThread;
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

    @Provides @Singleton Executor provideExecutor(ThreadExecutor executor) {
        return executor;
    }

    @Provides @Singleton MainThread provideMainThread(UIThread uiThread) {
        return uiThread;
    }
}