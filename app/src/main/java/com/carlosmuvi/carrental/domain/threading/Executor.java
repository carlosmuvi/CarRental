package com.carlosmuvi.carrental.domain.threading;

/**
 * Created by carlosmuvi on 28/07/16.
 */

import com.carlosmuvi.carrental.domain.UseCase;

public interface Executor {
    void run(UseCase useCase);
}
