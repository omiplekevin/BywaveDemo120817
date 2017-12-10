package com.android.omiplekevin.bywavedemo120817;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

import com.android.omiplekevin.bywavedemo120817.dao.CurrentWeatherModel;
import com.android.omiplekevin.bywavedemo120817.helpers.Constants;
import com.android.omiplekevin.bywavedemo120817.helpers.LocationHelper;
import com.android.omiplekevin.bywavedemo120817.helpers.OpenWeatherAPIHelper;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends Activity implements Callback<ResponseBody>, LocationListener{

    private OpenWeatherAPIHelper openWeatherAPIHelper;
    private LocationHelper locationHelper;

    private static final String TAG = "WeatherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openWeatherAPIHelper = OpenWeatherAPIHelper.getInstance();
        locationHelper = LocationHelper.getInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();
        locationHelper.startLocationListening(this, this);
        openWeatherAPIHelper.getWeatherRequestService().getCurrentWeather(
                "Davao",
                Constants.WeatherUnit.METRIC,
                BuildConfig.OWAPIKEY).enqueue(this);
    }

    @Override
    public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
        if (response.body() != null) {
            try {
                CurrentWeatherModel currentWeatherModel = new Gson().fromJson(response.body().string(), CurrentWeatherModel.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Log.w(TAG, "onResponse: response is null!");
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        Log.e(TAG, "onFailure: " + t.getMessage(), t);
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "onLocationChanged: " + location.getLatitude() + ", " + location.getLongitude());
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        Log.d(TAG, "onStatusChanged: " + s);
    }

    @Override
    public void onProviderEnabled(String s) {
        Log.d(TAG, "onProviderEnabled: " + s);
    }

    @Override
    public void onProviderDisabled(String s) {
        Log.d(TAG, "onProviderDisabled: " + s);
    }
}
