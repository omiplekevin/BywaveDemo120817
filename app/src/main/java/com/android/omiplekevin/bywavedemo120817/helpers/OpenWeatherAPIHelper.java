package com.android.omiplekevin.bywavedemo120817.helpers;

import com.android.omiplekevin.bywavedemo120817.BuildConfig;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by OMIPLEKEVIN on Dec 10, 0010.
 */

public class OpenWeatherAPIHelper {

    public static volatile OpenWeatherAPIHelper instance;
    public static final String TAG = "OpenWeatherAPIHelper";

    private Retrofit retrofit;

    public static OpenWeatherAPIHelper getInstance() {
        if (instance == null) {
            synchronized (OpenWeatherAPIHelper.class) {
                if (instance == null) {
                    instance = new OpenWeatherAPIHelper();
                }
            }
        }

        return instance;
    }

    private OpenWeatherAPIHelper() {
        initializeRetrofit();
    }

    private void initializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.OWAPIBASE)
                .build();
    }

    public WeatherRequestService getWeatherRequestService() {
        if (retrofit == null) {
            initializeRetrofit();
        }
        return retrofit.create(WeatherRequestService.class);
    }

    public interface WeatherRequestService {
        @GET("data/2.5/forecast")
        Call<ResponseBody> getCurrentWeather(@Query("q") String place,
                                             @Query("unit") Constants.WeatherUnit unit,
                                             @Query("APPID") String appId);
    }

}
