package com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire;

import com.carlosmuvi.carrental.data.repository.carrental.datasource.CarRentalDatasource;
import com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.error.APIException;
import com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.model.HotwireResponse;
import com.carlosmuvi.carrental.data.repository.carrental.specification.CarRentalSpecification;
import com.carlosmuvi.carrental.domain.model.Car;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class HotWireCarRentalDatasource implements CarRentalDatasource {

    private final HotWireService hotWireService;
    private final HotWireModelMapper mapper;

    @Inject public HotWireCarRentalDatasource(HotWireModelMapper mapper) {
        this.mapper = mapper;

        GsonBuilder gson = new GsonBuilder();
        gson.setLenient();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.hotwire.com/")
            .addConverterFactory(GsonConverterFactory.create(gson.create()))
            .build();

        this.hotWireService = retrofit.create(HotWireService.class);
    }

    private OkHttpClient buildHotwireHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return client;
        //OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        //httpClient.addInterceptor(chain -> {
        //    Request original = chain.request();
        //    HttpUrl originalHttpUrl = original.url();
        //
        //    HttpUrl url = originalHttpUrl.newBuilder()
        //        .addQueryParameter("apikey", "jrj4z4fm2k6kyextv5det5jv")
        //        .addQueryParameter("format", "json")
        //        .build();
        //
        //    Request.Builder requestBuilder = original.newBuilder().url(url);
        //
        //    Request request = requestBuilder.build();
        //    return chain.proceed(request);
        //});
        //return httpClient.build();
    }

    @Override public List<Car> query(CarRentalSpecification specification) throws APIException {
        Call<HotwireResponse> carRentalListCall = specification.toRetrofitQuery(hotWireService);
        try {
            HotwireResponse listResponse = carRentalListCall.execute().body();
            List<Car> carList = mapper.map(listResponse.result, listResponse.metaData);
            return carList;
        } catch (IOException e) {
            throw new APIException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
