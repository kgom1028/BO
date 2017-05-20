package com.kgom.binaryoptions.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;

import com.kgom.binaryoptions.R;

/**
 * Created by KJS on 9/3/2016.
 */
public class SplashActivity extends  BaseActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (android.os.Build.VERSION.SDK_INT >= 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                init();
            }
        }, 2000);

    }

    private void init() {
        //startActivity(new Intent(this, MainActivity.class));
        startActivity(new Intent(this, WarningActivity.class));
        finish();
    }
}
