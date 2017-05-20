package com.kgom.binaryoptions.activities;

import android.os.Bundle;

import com.kgom.binaryoptions.R;
import com.kgom.binaryoptions.doc.UserInfo;

/**
 * Created by KJS on 9/10/2016.
 */
public class TermsAndPolicyActivity extends  BaseActivity {
    UserInfo userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_policy);
        userInfo = UserInfo.getInstance();
    }

    public void attachHandle()
    {

    }

    public void initialize()
    {

    }
}
