package com.carlosmuvi.carrental.data.repository.carrental.specification;

import com.carlosmuvi.carrental.data.repository.base.Specification;
import com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.HotWireApiCarModel;
import com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.HotWireService;
import java.util.List;
import retrofit2.Call;

/**
 * This class wraps a repository query, allowing to perform that same query across different datasources.
 */
public interface CarRentalSpecification extends Specification {

    Call<List<HotWireApiCarModel>> toRetrofitQuery(HotWireService hotWireService);
    //TODO toCacheQuery, for example.
}
