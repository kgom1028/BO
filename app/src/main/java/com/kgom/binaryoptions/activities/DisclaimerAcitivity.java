package com.kgom.binaryoptions.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.kgom.binaryoptions.R;
import com.kgom.binaryoptions.application.BaseApplication;
import com.kgom.binaryoptions.doc.UserInfo;

/**
 * Created by KJS on 9/7/2016.
 */
public class DisclaimerAcitivity extends BaseActivity{
    UserInfo userInfo;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);
        userInfo = UserInfo.getInstance();
        attachHandle();
        initialize();
    }

    public void attachHandle()
    {
        checkBox = (CheckBox) findViewById(R.id.check_img);
    }

    public void initialize()
    {

    }
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.terms_and_policy:
                userInfo.selectedUrl = 11;
                startActivity(new Intent(this, WebViewActivity.class));
                break;
            case R.id.continue_btn:
                if(checkBox.isChecked())
                    startActivity(new Intent(this, OptionsActivity.class));
                else
                    Toast.makeText(this,getString(R.string.terms_conditions_need),Toast.LENGTH_SHORT);
                break;
            case R.id.back_icon:
                finish();
                break;
        }
    }
}
