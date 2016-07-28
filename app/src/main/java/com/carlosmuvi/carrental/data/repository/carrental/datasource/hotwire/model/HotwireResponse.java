package com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo") public class HotwireResponse {

    @SerializedName("MetaData") @Expose public MetaData metaData;
    @SerializedName("Result") @Expose public List<Result> result = new ArrayList<Result>();
    @SerializedName("StatusCode") @Expose public String statusCode;
    @SerializedName("StatusDesc") @Expose public String statusDesc;
}
