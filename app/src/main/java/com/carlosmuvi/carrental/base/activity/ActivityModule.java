package com.carlosmuvi.carrental.base.activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by carlosmuvi on 28/07/16.
 */

@Module public class ActivityModule {
    private final BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides @ActivityScope BaseActivity providesActivity() {
        return this.activity;
    }
}
