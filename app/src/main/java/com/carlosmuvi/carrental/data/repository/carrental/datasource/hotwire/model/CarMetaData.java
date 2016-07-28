package com.carlosmuvi.carrental.data.repository.carrental.datasource.hotwire.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo") public class CarMetaData {

    @SerializedName("CarTypes") @Expose public List<Type> carTypes = new ArrayList<Type>();
}
