package com.kgom.binaryoptions.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;

import com.kgom.binaryoptions.R;

/**
 * Created by KJS on 4/21/2017.
 */
public class ProfitHacksActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profit_hacks);
        attachHandle();
    }

    public void attachHandle()
    {


    }

    public void initialize()
    {

    }

    @Override
    protected void onPause(){
        super.onPause();

    }
    @Override
    protected void onResume(){
        super.onResume();

    }
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.back_icon:

                finish();
                break;
            case R.id.tip_1:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url",getString(R.string.tip_1_url));
                startActivity(intent);
            }
            break;
            case R.id.tip_2:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url",getString(R.string.tip_2_url));
                startActivity(intent);
            }

            break;
            case R.id.tip_3:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url",getString(R.string.tip_3_url));
                startActivity(intent);
            }
            break;
            case R.id.tip_4: {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.tip_4_url));
                startActivity(intent);
            }
                break;
            case R.id.tip_5: {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.tip_5_url));
                startActivity(intent);
            }
                break;
            case R.id.tip_6: {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.tip_6_url));
                startActivity(intent);
            }
                break;
            case R.id.tip_7:{
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url",getString(R.string.tip_7_url));
                startActivity(intent);
            }
                break;
            case R.id.tip_8: {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.tip_8_url));
                startActivity(intent);
            }
                break;
            case R.id.tip_9:{
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url",getString(R.string.tip_9_url));
                startActivity(intent);
            }
                break;
            case R.id.tip_10: {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.tip_10_url));
                startActivity(intent);
            }
                break;
            case R.id.mac_desktop: {

               /* Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",getString(R.string.feedback_mail), null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,  getString(R.string.mac_desktop_mail));
                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
                try {
                    startActivity(Intent.createChooser(emailIntent, "Send email..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MenuActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }*/
                Intent intent2 = new Intent(this, WebViewActivity.class);
                intent2.putExtra("url",getString(R.string.mac_desktop_url));
                startActivity(intent2);
            }
            break;
           /* case R.id.feedback:
            {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",getString(R.string.feedback_mail), null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,  getString(R.string.feedback_subject));
                emailIntent.putExtra(Intent.EXTRA_TEXT, "");
                try {
                    startActivity(Intent.createChooser(emailIntent, "Send email..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MenuActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }*/

/*
            case R.id.weekly_profit: {
                Intent intent1 = new Intent(this, WebViewActivity.class);
                intent1.putExtra("url", getString(R.string.weekly_profit));
                startActivity(intent1);
            }
            break;*/

            case R.id.privacy_policy: {
                Intent intent1 = new Intent(this, WebViewActivity.class);
                intent1.putExtra("url", getString(R.string.privacy_policy));
                startActivity(intent1);
            }
            break;
            case R.id.tips:
                startActivity(new Intent(this, TipsActivity.class));
                //tartActivity(new Intent(this, Tip1Activity.class));
                break;
        }
    }

}
