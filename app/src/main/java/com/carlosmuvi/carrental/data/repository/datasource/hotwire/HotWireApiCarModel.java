package com.carlosmuvi.carrental.data.repository.datasource.hotwire;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlosmuvi on 28/07/16.
 */
public class HotWireApiCarModel {

    @SerializedName("Errors")

    public List<Object> errors = new ArrayList<Object>();
    @SerializedName("MetaData")

    public MetaData metaData;
    @SerializedName("Result")

    public List<Result> result = new ArrayList<Result>();
    @SerializedName("StatusCode")

    public String statusCode;
    @SerializedName("StatusDesc")

    public String statusDesc;

    public class CarMetaData {

        @SerializedName("CarTypes")

        public List<CarType> carTypes = new ArrayList<CarType>();
    }

    public class CarType {

        @SerializedName("TypicalSeating")

        public String typicalSeating;
        @SerializedName("CarTypeName")

        public String carTypeName;
        @SerializedName("CarTypeCode")

        public String carTypeCode;
        @SerializedName("PossibleFeatures")

        public String possibleFeatures;
        @SerializedName("PossibleModels")

        public String possibleModels;
    }

    public class MetaData {

        @SerializedName("CarMetaData")

        public CarMetaData carMetaData;
    }

    public class Result {

        @SerializedName("CurrencyCode")

        public String currencyCode;
        @SerializedName("DeepLink")

        public String deepLink;
        @SerializedName("ResultId")

        public String resultId;
        @SerializedName("HWRefNumber")

        public String hWRefNumber;
        @SerializedName("SubTotal")

        public String subTotal;
        @SerializedName("TaxesAndFees")

        public String taxesAndFees;
        @SerializedName("TotalPrice")

        public String totalPrice;
        @SerializedName("CarTypeCode")

        public String carTypeCode;
        @SerializedName("DailyRate")

        public String dailyRate;
        @SerializedName("DropoffDay")

        public String dropoffDay;
        @SerializedName("DropoffTime")

        public String dropoffTime;
        @SerializedName("PickupDay")

        public String pickupDay;
        @SerializedName("PickupTime")

        public String pickupTime;
        @SerializedName("LocationDescription")

        public String locationDescription;
        @SerializedName("MileageDescription")

        public String mileageDescription;
        @SerializedName("PickupAirport")

        public String pickupAirport;
        @SerializedName("RentalDays")

        public String rentalDays;
        @SerializedName("VendorLocationId")

        public String vendorLocationId;
    }
}


