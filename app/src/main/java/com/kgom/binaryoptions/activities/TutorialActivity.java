package com.kgom.binaryoptions.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kgom.binaryoptions.R;
import com.kgom.binaryoptions.doc.UserInfo;

/**
 * Created by KJS on 1/3/2017.
 */
public class TutorialActivity extends  BaseActivity {
    UserInfo userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        userInfo = UserInfo.getInstance();
    }

    public void attachHandle()
    {

    }

    public void initialize()
    {

    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.back_icon:
                finish();
                break;
            case R.id.video_tutorial: {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.video_tutorial_url));
                startActivity(intent);
            }
                break;
            case R.id.basic_tutorial:
                Intent intent = new Intent(this, BasicTutorialActivity.class);
                startActivity(intent);
                break;
        }


    }
}
