package com.carlosmuvi.carrental.data.repository.carrental.specification;

import com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.HotWireApiCarModel;
import com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.HotWireService;
import java.util.List;
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

    @Override public Call<List<HotWireApiCarModel>> toRetrofitQuery(HotWireService hotWireService) {

        String formattedPickupDate = formatDate(pickupDate);
        String formattedDropoffDate = formatDate(dropoffDate);
        String formattedPickupTime = formatTime(pickupDate);
        String formattedDropoffTime = formatTime(dropoffDate);

        return hotWireService.searchCars(location, formattedPickupDate, formattedDropoffDate, formattedPickupTime,
            formattedDropoffTime);
    }

    private String formatDate(DateTime dateTime) {
        return dateTime.toString("MM/dd/yyyy");
    }

    private String formatTime(DateTime dateTime) {
        return dateTime.toString("HH:mm");
    }
}
