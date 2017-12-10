package com.android.omiplekevin.bywavedemo120817.dao.commons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by OMIPLEKEVIN on Dec 10, 0010.
 */

public class Wind {

    @SerializedName("speed")
    @Expose
    public Float speed;
    @SerializedName("deg")
    @Expose
    public Float deg;

}