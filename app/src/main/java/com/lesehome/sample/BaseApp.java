package com.lesehome.sample;

import com.lesehome.carrot.db.MyDb;
import com.lesehome.sample.utils.MyVolley;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import android.app.Application;

public class BaseApp extends Application {

    private static BaseApp _instance;
    private RefWatcher _refWatcher;

    public static BaseApp get() {
        return _instance;
    }

    /**
     * Modular-RecyclerView-And-LoadingViewHelper
     */
    @Override
    public void onCreate() {
        super.onCreate();

        _instance = (BaseApp) getApplicationContext();

        MyVolley.init(getApplicationContext());

        MyDb.init(getApplicationContext());
        MyDb.enableQueryBuilderLog();

        _refWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher() {
        return BaseApp.get()._refWatcher;
    }
}
