package com.carlosmuvi.carrental.base.activity;

import java.lang.annotation.Retention;
import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by carlosmuvi on 28/07/16.
 */

@Scope @Retention(RUNTIME) public @interface ActivityScope {
}
