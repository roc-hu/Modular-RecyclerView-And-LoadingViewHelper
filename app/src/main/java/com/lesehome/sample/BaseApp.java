package com.lesehome.sample;

import com.lesehome.sample.utils.MyVolley;

import android.app.Application;

public class BaseApp extends Application {

    /**
     * Modular-RecyclerView-And-LoadingViewHelper
     */
    @Override
    public void onCreate() {
        super.onCreate();
        MyVolley.init(getApplicationContext());
    }
}
