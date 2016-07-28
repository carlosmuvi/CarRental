package com.carlosmuvi.carrental.data.repository.carrental.specification;

import com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.HotWireService;
import com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.model.HotwireResponse;
import org.joda.time.DateTime;
import retrofit2.Call;

/**
 * Created by carlosmuvi on 28/07/16.
 */
public class CarsByLocationAndDatetimeSpecification implements CarRentalSpecification {

    private final DateTime pickupDate;
    private final DateTime dropoffDate;
    private final String location;

    public CarsByLocationAndDatetimeSpecification(DateTime pickupDate, DateTime dropoffDate, String location) {
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
        this.location = location;
    }

    @Override public Call<HotwireResponse> toRetrofitQuery(HotWireService hotWireService) {

        String formattedPickupDate = formatDate(pickupDate);
        String formattedDropoffDate = formatDate(dropoffDate);
        String formattedPickupTime = formatTime(pickupDate);
        String formattedDropoffTime = formatTime(dropoffDate);

        try {
            Call<HotwireResponse> listCall =
                hotWireService.searchCars("jrj4z4fm2k6kyextv5det5jv", "json", location, formattedPickupDate,
                    formattedDropoffDate, formattedPickupTime, formattedDropoffTime);
            return listCall;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String formatDate(DateTime dateTime) {
        return dateTime.toString("MM/dd/yyyy");
    }

    private String formatTime(DateTime dateTime) {
        return dateTime.toString("HH:mm");
    }
}
