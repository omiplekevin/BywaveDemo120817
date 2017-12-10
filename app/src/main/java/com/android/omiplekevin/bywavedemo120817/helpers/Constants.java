package com.android.omiplekevin.bywavedemo120817.helpers;

/**
 * Created by OMIPLEKEVIN on Dec 10, 0010.
 */

public class Constants {

    public static enum WeatherUnit{
        METRIC("metric"), IMPERIAL("imperial");

        private final String unit;

        WeatherUnit(String unit) {
            this.unit = unit;
        }

        String getUnit() {
            return this.unit;
        }
    }
}
