package com.kgom.binaryoptions.activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.MailTo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.kgom.binaryoptions.R;
import com.kgom.binaryoptions.doc.UserInfo;
import com.kgom.binaryoptions.views.FullscreenableChromeClient;
import com.kgom.binaryoptions.views.ObservableWebView;

import java.io.ByteArrayInputStream;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by KJS on 11/16/2016.
 */
public class WebViewActivity extends BaseActivity{
    ObservableWebView webView;
    ProgressBar progressBar;
    FullscreenableChromeClient webChromeClient;
    String mCurrentLink;
    String mContent;
    Boolean isShowLoading = false;
    private GifImageView loadingAnim;
    private View loadingAnimBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        String url = "";
        String content = "";
        if(getIntent().hasExtra("url"))
            url = getIntent().getStringExtra("url");
        if(getIntent().hasExtra("content"))
        content =  getIntent().getStringExtra("content");
        isShowLoading = getIntent().getBooleanExtra("loading",true);
        mCurrentLink = url;
        mContent = content;
        attachHandle();
        initialize();

    }
    protected void onDestroy()
    {
        super.onDestroy();

    }
    public void attachHandle()
    {
        webView =(ObservableWebView) findViewById(R.id.webView);
        progressBar = (ProgressBar) this.findViewById(R.id.pro);
        loadingAnim = (GifImageView) findViewById(R.id.loading_anim);
        loadingAnimBar = (View)findViewById(R.id.loading_anim_bar);
    }

    public void initialize() {
        webChromeClient = new FullscreenableChromeClient(this){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
            }
        };
        WebSettings set = webView.getSettings();
        set.setJavaScriptEnabled(true);
        set.setBuiltInZoomControls(true);
        set.setLoadWithOverviewMode(true);
        set.setAllowContentAccess(true);
        //set.setUseWideViewPort(true);
        set.setAllowUniversalAccessFromFileURLs(true);
		set.setAllowFileAccessFromFileURLs(true);
        set.getAllowUniversalAccessFromFileURLs();
		set.setDomStorageEnabled(true);
		set.setLoadWithOverviewMode(true);
		set.setJavaScriptCanOpenWindowsAutomatically(true);
        if(isShowLoading){
            webView.setVisibility(View.INVISIBLE);
            loadingAnim.setVisibility(View.VISIBLE);
            loadingAnimBar.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
        }else {
            webView.setVisibility(View.VISIBLE);
            loadingAnim.setVisibility(View.GONE);
            loadingAnimBar.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }



        webView.setWebChromeClient(webChromeClient);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url)
            {
                progressBar.setVisibility(View.INVISIBLE);
                if(isShowLoading){
                    loadingAnim.setVisibility(View.GONE);
                    loadingAnimBar.setVisibility(View.GONE);
                    webView.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
                mCurrentLink = url;
                if(url.contains("promo/registration"))
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("registerstate","try");
                    mFirebaseAnalytics.logEvent("register_try", bundle);
                }
            }

            @Override
            public WebResourceResponse shouldInterceptRequest (final WebView view,  WebResourceRequest request) {
                Log.d("Request",request.toString());
                Uri uri = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    uri = request.getUrl();
                    String url  = uri.getScheme();
                    if(url.contains("register-finish"))
                    {
                        Bundle bundle = new Bundle();
                        bundle.putString("registerstate","success");
                        mFirebaseAnalytics.logEvent("register_success", bundle);
                    }
                }else
                    return  super.shouldInterceptRequest(view, request);

                return  super.shouldInterceptRequest(view, request);

            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.d("LoadingURL", url);
                if(url.startsWith("mailto:")){
                    MailTo mt = MailTo.parse(url);
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_EMAIL, new String[]{mt.getTo()});
                    i.putExtra(Intent.EXTRA_SUBJECT, mt.getSubject());
                    i.putExtra(Intent.EXTRA_CC, mt.getCc());
                    i.putExtra(Intent.EXTRA_TEXT, mt.getBody());
                    WebViewActivity.this.startActivity(i);
                    view.reload();
                    return true;
                }

                if (Uri.parse(url).getScheme().equals("market")) {
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        Activity host = (Activity) view.getContext();
                        host.startActivity(intent);
                        return true;
                    } catch (ActivityNotFoundException e) {
                        // Google Play app is not installed, you may want to open the app store link
                        Uri uri = Uri.parse(url);
                        view.loadUrl("http://play.google.com/store/apps/" + uri.getHost() + "?" + uri.getQuery());
                        return false;
                    }

                }

                if(url.contains("register-finish"))
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("registerstate","success");
                    mFirebaseAnalytics.logEvent("register_success", bundle);
                }
                if( URLUtil.isNetworkUrl(url) ) {
                    return false;
                }

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity( intent );
                return true;
            }});


        if(!mCurrentLink.isEmpty())
        webView.loadUrl(mCurrentLink);
        else if(!mContent.isEmpty()){
            webView.loadData(mContent, "text/html", null);
        }

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static WebResourceResponse createEmptyResource() {
        return new WebResourceResponse("text/plain", "utf-8", new ByteArrayInputStream("".getBytes()));
    }


    protected void onPause()
    {
        super.onPause();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) < 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {

            onBackPressed();
        }

        return super.onKeyDown(keyCode, event);
    }

    public void onBackPressed() {
            if (!webChromeClient.onBackPressed()) {
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    // Close app (presumably)
                    super.onBackPressed();
                    webView.loadUrl("about:blank");
                    finish();

                }
            }

    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.back_icon:
                onBackPressed();
                break;
        }


    }


}
