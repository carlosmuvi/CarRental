package com.carlosmuvi.carrental.data.repository.datasource.hotwire;

import com.carlosmuvi.carrental.data.repository.datasource.RentalCarDatasource;
import com.carlosmuvi.carrental.domain.model.Car;
import java.util.List;
import javax.inject.Inject;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.joda.time.DateTime;
import retrofit2.Retrofit;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public class HotWireRentalCarDatasource implements RentalCarDatasource {

    private final HotWireService hotWireService;

    @Inject public HotWireRentalCarDatasource() {
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

    @Override public List<Car> searchCars(DateTime pickupDateTime, DateTime dropoffDateTime, String location) {

        String formattedPickupDate = formatDate(pickupDateTime);
        String formattedDropoffDate = formatDate(dropoffDateTime);
        String formattedPickupTime = formatTime(pickupDateTime);
        String formattedDropoffTime = formatTime(dropoffDateTime);

        hotWireService.searchCars(location, formattedPickupDate, formattedDropoffDate, formattedPickupTime,
            formattedDropoffTime);
        return null;
    }

    private String formatDate(DateTime dateTime) {
        return dateTime.toString("MM/dd/yyyy");
    }

    private String formatTime(DateTime dateTime) {
        return dateTime.toString("HH:mm");
    }
}
