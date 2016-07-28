package com.carlosmuvi.carrental.domain;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public interface SimpleListener<T> {
    void onSuccess(T t);

    void onError(Exception error);
}


