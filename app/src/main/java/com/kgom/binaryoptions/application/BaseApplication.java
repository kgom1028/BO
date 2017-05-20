package com.kgom.binaryoptions.application;
import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by KJS on 9/3/2016.
 */
public class BaseApplication extends Application {
    public static final String TAG = BaseApplication.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
    }


}
