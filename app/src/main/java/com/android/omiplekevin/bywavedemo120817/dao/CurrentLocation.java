package com.android.omiplekevin.bywavedemo120817.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by OMIPLEKEVIN on Dec 10, 0010.
 */

public class CurrentLocation {

    @SerializedName("temp")
    @Expose
    public Float temp;
    @SerializedName("temp_min")
    @Expose
    public Float tempMin;
    @SerializedName("temp_max")
    @Expose
    public Float tempMax;
    @SerializedName("pressure")
    @Expose
    public Float pressure;
    @SerializedName("sea_level")
    @Expose
    public Float seaLevel;
    @SerializedName("grnd_level")
    @Expose
    public Float grndLevel;
    @SerializedName("humidity")
    @Expose
    public Integer humidity;
    @SerializedName("temp_kf")
    @Expose
    public double tempKf;

}