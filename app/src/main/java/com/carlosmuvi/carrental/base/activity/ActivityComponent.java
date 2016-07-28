package com.carlosmuvi.carrental.base.activity;

import com.carlosmuvi.carrental.base.application.AppComponent;
import dagger.Component;

/**
 * Created by carlosmuvi on 28/07/16.
 */

@ActivityScope @Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    BaseActivity activity();

}