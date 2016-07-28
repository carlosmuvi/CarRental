package com.carlosmuvi.carrental.data.repository.datasource.hotwire;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public interface HotWireService {

    @GET("v1/search/car") Call<List<HotWireApiCarModel>> searchCars(@Query("dest") String destination,
        @Query("startdate") String startDate, @Query("enddate") String endDate, @Query("pickuptime") String pickupTime,
        @Query("dropofftime") String dropoffTime);
}
