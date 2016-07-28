package com.carlosmuvi.carrental.domain.threading;

/**
 * Created by carlosmuvi on 28/07/16.
 */
public interface MainThread {
    void post(final Runnable runnable);
}
