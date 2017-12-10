package com.android.omiplekevin.bywavedemo120817;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.omiplekevin.bywavedemo120817.helpers.LocationHelper;

import net.ralphpina.permissionsmanager.PermissionsManager;
import net.ralphpina.permissionsmanager.PermissionsResult;

import rx.functions.Action1;

public class SplashActivity extends AppCompatActivity {

    public static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        boolean state = true;
        int count = 5;
        checkPermissions();
        checkProviderEnabled();
    }

    private void checkPermissions() {
        PermissionsManager.get()
                .requestLocationPermission()
                .subscribe(new Action1<PermissionsResult>() {
                    @Override
                    public void call(PermissionsResult permissionsResult) {
                        if (permissionsResult.isGranted()) {
                            Log.d(TAG, "hasAskedForPermissions: LOCATION is granted!");
                        }
                        if (permissionsResult.hasAskedForPermissions()) {
                            if (!PermissionsManager.get().isLocationGranted()) {
                                Log.w(TAG, "hasAskedForPermissions: location is NOT granted!");
                            } else {
                                Log.d(TAG, "hasAskedForPermissions: location is granted!");
                            }
                        }
                    }
                });
    }

    private void checkProviderEnabled() {
        if (LocationHelper.getInstance().isLocationProviderEnabled(SplashActivity.this, LocationManager.GPS_PROVIDER)) {
            startTimer();
        } else {
            Toast.makeText(SplashActivity.this, "Please enable Location", Toast.LENGTH_LONG).show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                }
            }, 2000);
        }
    }

    private void startTimer() {
        CountDownTimer timer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
                Log.d(TAG, "onTick: starting in " + l);
            }

            @Override
            public void onFinish() {
                startMainScreen();
            }
        };
        timer.start();
    }

    private void startMainScreen() {
        Intent intent = new Intent(this, WeatherActivity.class);
        startActivity(intent);
        finish();
    }
}
