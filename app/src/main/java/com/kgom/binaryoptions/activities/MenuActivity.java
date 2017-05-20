package com.kgom.binaryoptions.activities;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import com.kgom.binaryoptions.R;
import com.kgom.binaryoptions.doc.UserInfo;
import com.kgom.binaryoptions.views.AlertDialog;
import com.kgom.binaryoptions.views.ConfirmDialog;
import com.kgom.binaryoptions.views.IntroVideoSurface;

import java.io.IOException;

/**
 * Created by KJS on 1/3/2017.
 */
public class MenuActivity extends BaseActivity{
    IntroVideoSurface surface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        attachHandle();
        setupWindowAnimations();
    }

    public void attachHandle()
    {
        surface = (IntroVideoSurface)findViewById(R.id.surface);
    }

    public void initialize()
    {

    }
    private void setupWindowAnimations() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide();
            slide.setDuration(1000);
            getWindow().setExitTransition(slide);
        }
    }
    @Override
    protected void onPause(){
        super.onPause();
        surface.stopVideo();
    }
    @Override
    protected void onResume(){
        super.onResume();
        surface.startVideo();
    }
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.back_icon:

                finish();
                break;
            case R.id.google_play:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url",getString(R.string.google_play_url));
                startActivity(intent);
            }
            break;
            case R.id.buy_or_sell:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url",getString(R.string.buy_or_sell));
                startActivity(intent);
            }

                break;
            case R.id.trader_of_week:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url",getString(R.string.trader_of_week));
                startActivity(intent);
            }
            break;
            case R.id.freeDemo:
                startActivity(new Intent(this, FreeDemoActivity.class));
                break;
            case R.id.tradingAlerts:
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url",getString(R.string.trading_alerts_url));
                startActivity(intent);
                break;
            case R.id.tutorial:
                startActivity(new Intent(this, TutorialActivity.class));
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
                startActivity(new Intent(this, ProfitHacksActivity.class));
                //tartActivity(new Intent(this, Tip1Activity.class));
                break;
        }
    }

}
