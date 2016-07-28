package com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo") public class Type {

    @SerializedName("TypicalSeating") @Expose public String typicalSeating;
    @SerializedName("CarTypeName") @Expose public String carTypeName;
    @SerializedName("CarTypeCode") @Expose public String carTypeCode;
    @SerializedName("PossibleFeatures") @Expose public String possibleFeatures;
    @SerializedName("PossibleModels") @Expose public String possibleModels;
}
