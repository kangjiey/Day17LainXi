package com.example.dell.day17lainxi;

import android.app.Application;

/**
 * Created by dell on 2019/6/20.
 */

public class DbApp extends Application {
    private static DbApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static DbApp getApp() {
        return app;
    }
}
