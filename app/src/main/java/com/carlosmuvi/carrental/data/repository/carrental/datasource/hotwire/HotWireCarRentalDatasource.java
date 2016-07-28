package com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire;

import com.carlosmuvi.carrental.data.repository.carrental.specification.CarRentalSpecification;
import com.carlosmuvi.carrental.data.repository.carrental.datasource.CarRentalDatasource;
import com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.error.APIException;
import com.carlosmuvi.carrental.domain.model.Car;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class HotWireCarRentalDatasource implements CarRentalDatasource {

    private final HotWireService hotWireService;
    private final HotWireModelMapper mapper;

    @Inject public HotWireCarRentalDatasource(HotWireModelMapper mapper) {
        this.mapper = mapper;
        Retrofit retrofit =
            new Retrofit.Builder().baseUrl("http://api.hotwire.com/").client(buildHotwireHttpClient()).build();

        this.hotWireService = retrofit.create(HotWireService.class);
    }

    private OkHttpClient buildHotwireHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            HttpUrl originalHttpUrl = original.url();

            HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("apikey", "jrj4z4fm2k6kyextv5det5jv")
                .addQueryParameter("format", "json")
                .build();

            Request.Builder requestBuilder = original.newBuilder().url(url);

            Request request = requestBuilder.build();
            return chain.proceed(request);
        });
        return httpClient.build();
    }

    @Override public List<Car> query(CarRentalSpecification specification) throws APIException {
        Call<List<HotWireApiCarModel>> carRentalListCall = specification.toRetrofitQuery(hotWireService);
        try {
            Response<List<HotWireApiCarModel>> listResponse = carRentalListCall.execute();
            List<Car> carList = mapper.map(listResponse.body().get(0).result.get(0));
            return carList;
        } catch (IOException e) {
            throw new APIException(e.getMessage());
        }
    }
}
