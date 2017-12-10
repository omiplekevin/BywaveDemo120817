package com.android.omiplekevin.bywavedemo120817;

import android.app.Application;

import net.ralphpina.permissionsmanager.PermissionsManager;

/**
 * Created by OMIPLEKEVIN on December 10, 2017.
 * BywaveDemo120817
 * com.android.omiplekevin.bywavedemo120817
 */

public class WeatherApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PermissionsManager.init(this);
    }
}
