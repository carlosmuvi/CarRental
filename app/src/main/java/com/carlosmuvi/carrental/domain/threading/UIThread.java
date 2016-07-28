package com.carlosmuvi.carrental.domain.threading;

import android.os.Handler;
import android.os.Looper;
import javax.inject.Inject;

/**
 * Created by carlosmuvi on 28/07/16.
 */
public class UIThread implements MainThread {
    private Handler handler;

    @Inject UIThread() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    public void post(Runnable runnable) {
        handler.post(runnable);
    }
}
