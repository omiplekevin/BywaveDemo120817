package com.android.omiplekevin.bywavedemo120817.dao;

import com.android.omiplekevin.bywavedemo120817.dao.commons.City;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by OMIPLEKEVIN on Dec 10, 0010.
 */

public class CurrentWeatherModel {

    @SerializedName("cod")
    @Expose
    public String cod;
    @SerializedName("message")
    @Expose
    public Float message;
    @SerializedName("cnt")
    @Expose
    public Integer cnt;
    @SerializedName("list")
    @Expose
    public List<WeatherForecastModel> weatherForecastModel = null;
    @SerializedName("city")
    @Expose
    public City city;
}
