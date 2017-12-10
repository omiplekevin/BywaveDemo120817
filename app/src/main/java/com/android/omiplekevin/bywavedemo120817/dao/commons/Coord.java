package com.android.omiplekevin.bywavedemo120817.dao.commons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by OMIPLEKEVIN on Dec 10, 0010.
 */

public class Coord {

    @SerializedName("lat")
    @Expose
    public Float lat;
    @SerializedName("lon")
    @Expose
    public Float lon;

}
