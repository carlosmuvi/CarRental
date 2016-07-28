package com.carlosmuvi.carrental.base.activity;

import android.app.Activity;
import dagger.Module;
import dagger.Provides;

/**
 * Created by carlosmuvi on 28/07/16.
 */

@Module public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides @ActivityScope Activity providesActivity() {
        return this.activity;
    }
}
