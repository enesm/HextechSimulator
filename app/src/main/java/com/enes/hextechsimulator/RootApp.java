package com.enes.hextechsimulator;

import android.app.Application;
import android.content.Context;

import java.lang.ref.WeakReference;

public class RootApp extends Application {
    private static WeakReference<Context> mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = new WeakReference<Context>(this);
    }

    public static Context getContext() {
        return mContext.get();
    }
}
