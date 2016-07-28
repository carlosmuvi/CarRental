package com.carlosmuvi.carrental.data.repository.carrental.specification;

import com.carlosmuvi.carrental.data.repository.base.Specification;
import com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.HotWireService;
import com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.model.HotwireResponse;
import retrofit2.Call;

/**
 * This class wraps a repository query, allowing to perform that same query across different datasources.
 */
public interface CarRentalSpecification extends Specification {

    Call<HotwireResponse> toRetrofitQuery(HotWireService hotWireService);
    //TODO toCacheQuery, for example.
}
