package com.carlosmuvi.carrental.base.application;

import android.content.Context;
import com.carlosmuvi.carrental.base.activity.BaseActivity;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by carlosmuvi on 28/07/16.
 */

@Singleton @Component(modules = AppModule.class) public interface AppComponent {

    void bind(BaseActivity baseActivity);

    Context context();
}
