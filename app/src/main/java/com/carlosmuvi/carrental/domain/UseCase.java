package com.carlosmuvi.carrental.domain;

import com.carlosmuvi.carrental.domain.threading.Executor;
import com.carlosmuvi.carrental.domain.threading.MainThread;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public abstract class UseCase {

    protected Executor threadExecutor;
    protected MainThread mainThread;

    public UseCase(Executor threadExecutor, MainThread mainThread) {
        this.threadExecutor = threadExecutor;
        this.mainThread = mainThread;
    }

    public abstract void run();
}
