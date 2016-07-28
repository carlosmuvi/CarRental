package com.carlosmuvi.carrental.data.repository.base;

import com.carlosmuvi.carrental.data.repository.error.RepositoryException;
import java.util.List;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public interface ReadableRepository<T, E extends Specification> {
    List<T> query(E specification) throws RepositoryException;
}
