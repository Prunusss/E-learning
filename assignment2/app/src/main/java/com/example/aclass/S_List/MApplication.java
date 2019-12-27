package com.example.aclass.S_List;

import android.app.Application;
import android.content.Context;

public class MApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }

    public static Context getContext() {
        return context;
    }
}
