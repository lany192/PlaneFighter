package com.github.lany192.planefighter;

import android.app.Activity;
import android.app.Application;

public class MyApp extends Application {

    private static MyApp globalContext = null;
    public static Activity activity = null;

    @Override
    public void onCreate() {
        super.onCreate();
        globalContext = this;
    }

    public static MyApp getInstance() {
        return globalContext;
    }

    public static Activity getActivity() {
        return activity;
    }

    public static void setActivity(Activity a) {
        activity = a;
    }
}
