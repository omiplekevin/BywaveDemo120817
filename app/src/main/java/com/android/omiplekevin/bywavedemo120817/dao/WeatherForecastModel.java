package com.android.omiplekevin.bywavedemo120817.dao;

import com.android.omiplekevin.bywavedemo120817.dao.commons.Clouds;
import com.android.omiplekevin.bywavedemo120817.dao.commons.Rain;
import com.android.omiplekevin.bywavedemo120817.dao.commons.Sys;
import com.android.omiplekevin.bywavedemo120817.dao.commons.Wind;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by OMIPLEKEVIN on Dec 10, 0010.
 */

public class WeatherForecastModel {

    @SerializedName("dt")
    @Expose
    public Integer dt;
    @SerializedName("main")
    @Expose
    public CurrentLocation currentLocation;
    @SerializedName("weather")
    @Expose
    public java.util.List<CurrentCondition> currentCondition = null;
    @SerializedName("clouds")
    @Expose
    public Clouds clouds;
    @SerializedName("wind")
    @Expose
    public Wind wind;
    @SerializedName("rain")
    @Expose
    public Rain rain;
    @SerializedName("sys")
    @Expose
    public Sys sys;
    @SerializedName("dt_txt")
    @Expose
    public String dtTxt;

}
