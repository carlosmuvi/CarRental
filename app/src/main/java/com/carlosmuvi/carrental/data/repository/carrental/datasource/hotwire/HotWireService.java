package com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire;

import com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.model.HotwireResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public interface HotWireService {

    @GET("v1/search/car") Call<HotwireResponse> searchCars(@Query("apikey") String apikey,
        @Query("format") String format, @Query("dest") String destination, @Query("startdate") String startDate,
        @Query("enddate") String endDate, @Query("pickuptime") String pickupTime,
        @Query("dropofftime") String dropoffTime);
}
