package com.android.omiplekevin.bywavedemo120817.helpers;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;

import net.ralphpina.permissionsmanager.PermissionsManager;

/**
 * Created by OMIPLEKEVIN on December 10, 2017.
 * BywaveDemo120817
 * com.android.omiplekevin.bywavedemo120817.helpers
 */

public class LocationHelper {

    private static volatile LocationHelper instance;

    private static final String TAG = "LocationHelper";

    private final long LOCATION_REFRESH_TIME = 30000;
    private final float LOCATION_MINIMUM_DIST = 0f;

    private LocationManager locationManager;

    public static LocationHelper getInstance() {
        if (instance == null) {
            synchronized (LocationHelper.class) {
                if (instance == null) {
                    instance = new LocationHelper();
                }
            }
        }
        return instance;
    }

    public boolean isLocationProviderEnabled(Context context, String provider) {
        if (locationManager == null) {
            locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        } else {
            Log.d(TAG, "isLocationProviderEnabled: locationManager is NOT null!");
        }

        if (locationManager != null) {
            return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } else {
            Log.w(TAG, "isLocationProviderEnabled: locationManager is NULL!");
        }

        return false;
    }

    public void startLocationListening(Context context, LocationListener locationListener) {
        if (locationManager == null) {
            locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        } else {
            Log.d(TAG, "startLocationListening: locationManager is NOT null!");
        }

        if (PermissionsManager.get().isLocationGranted()) {
            Log.d(TAG, "startLocationListening: LOCATION is granted!");
            try {
                locationManager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER,
                        LOCATION_REFRESH_TIME,
                        LOCATION_MINIMUM_DIST,
                        locationListener);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        } else {
            Log.w(TAG, "startLocationListening: LOCATION is NOT granted!");
        }
    }
}
