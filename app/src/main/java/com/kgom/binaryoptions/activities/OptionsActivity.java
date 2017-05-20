package com.kgom.binaryoptions.activities;

import android.content.Intent;
import android.net.MailTo;
import android.os.Bundle;
import android.view.View;

import com.kgom.binaryoptions.R;
import com.kgom.binaryoptions.doc.UserInfo;

/**
 * Created by KJS on 9/8/2016.
 */
public class OptionsActivity extends BaseActivity{
    UserInfo userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
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
            case R.id.option_1:
                userInfo.selectedUrl = 6;
                startActivity(new Intent(this, WebViewActivity.class));
                break;
            case R.id.option_2:
                userInfo.selectedUrl = 7;
                startActivity(new Intent(this, WebViewActivity.class));
                break;
            case R.id.option_3:
                userInfo.selectedUrl = 8;
                startActivity(new Intent(this, WebViewActivity.class));
                break;
            case R.id.option_4:
                userInfo.selectedUrl = 9;
                startActivity(new Intent(this, WebViewActivity.class));
                break;
            case R.id.option_5:
            /*    userInfo.selectedUrl = 12;
                startActivity(new Intent(this, WebViewActivity.class));*/
                MailTo mt = MailTo.parse(getString(R.string.option_url_6));
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{mt.getTo()});
                i.putExtra(Intent.EXTRA_SUBJECT, mt.getSubject());
                i.putExtra(Intent.EXTRA_CC, mt.getCc());
                i.putExtra(Intent.EXTRA_TEXT, mt.getBody());
                startActivity(i);
                break;
            case R.id.option_6:
                userInfo.selectedUrl = 10;
                startActivity(new Intent(this, WebViewActivity.class));
                break;
            case R.id.option_7:
                startActivity(new Intent(this, NotificationActivity.class));
                break;
            case R.id.back_icon:
                finish();
                break;
        }

    }
}
