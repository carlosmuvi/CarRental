package com.carlosmuvi.carrental.base.application;

import android.content.Context;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by carlosmuvi on 28/07/16.
 */

@Singleton @Component(modules = AppModule.class) public interface AppComponent extends BaseComponent {

    //void bind(BaseActivity baseActivity);

    Context context();
}
