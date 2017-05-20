package com.kgom.binaryoptions.views;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by KJS on 9/16/2016.
 */
public class MyWebViewClient extends WebViewClient {
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {

    }

    @Override
    public void onPageFinished(WebView view, String url) {
        view.setVisibility(View.VISIBLE);
        final Animation fade = new AlphaAnimation(0.0f, 1.0f);
        fade.setDuration(200);
        view.startAnimation(fade);
        view.setVisibility(View.VISIBLE);





    }
}
