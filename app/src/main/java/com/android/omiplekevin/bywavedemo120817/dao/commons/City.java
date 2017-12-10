package com.android.omiplekevin.bywavedemo120817.dao.commons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by OMIPLEKEVIN on December 10, 2017.
 * BywaveDemo120817
 * com.android.omiplekevin.bywavedemo120817.dao.commons
 */

public class City {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("coord")
    @Expose
    public Coord coord;
    @SerializedName("country")
    @Expose
    public String country;
}
