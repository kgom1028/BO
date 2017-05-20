package com.kgom.binaryoptions.activities;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.appsflyer.AppsFlyerLib;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kgom.binaryoptions.R;
import com.kgom.binaryoptions.application.BaseApplication;
import com.kgom.binaryoptions.fragments.BaseFragment;


/**
 * Created by KJS on 9/3/2016.
 */
public class BaseActivity extends AppCompatActivity {
    protected FirebaseAnalytics mFirebaseAnalytics;
    public BaseApplication application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        AppsFlyerLib.getInstance().startTracking(this.getApplication(),getString(R.string.appsflyer_dev_key));
    }

    public void attachHandle()
    {

    }

    public void initialize()
    {

    }

    public void showToast(Context context, String strMsg){
        Toast.makeText(context, strMsg, Toast.LENGTH_LONG).show();
    }

    public interface PushFragment {
        public void onPushFragment(BaseFragment fragment);
    }
}
