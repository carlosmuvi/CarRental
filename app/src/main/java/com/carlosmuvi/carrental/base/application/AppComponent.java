package com.carlosmuvi.carrental.base.application;

import android.content.Context;
import com.carlosmuvi.carrental.base.BaseComponent;
import com.carlosmuvi.carrental.domain.threading.Executor;
import com.carlosmuvi.carrental.domain.threading.MainThread;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by carlosmuvi on 28/07/16.
 */

@Singleton @Component(modules = AppModule.class) public interface AppComponent extends BaseComponent {

    //void bind(BaseActivity baseActivity);

    Context context();
    Executor executor();
    MainThread mainThread();
}
