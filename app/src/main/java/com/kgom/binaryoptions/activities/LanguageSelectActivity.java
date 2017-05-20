package com.kgom.binaryoptions.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.kgom.binaryoptions.R;
import com.kgom.binaryoptions.doc.UserInfo;

/**
 * Created by KJS on 9/7/2016.
 */
public class LanguageSelectActivity extends BaseActivity{
    UserInfo userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
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
            case R.id.english_btn: {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.english_url));
                startActivity(intent);
            }
                break;
           /* case R.id.russian_btn: {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.russian_url));
                startActivity(intent);
            }
                break;*/
            case R.id.chinese_btn: {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.chinese_url));
                startActivity(intent);
            }
                break;
            case R.id.german_btn:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.german_url));
                startActivity(intent);
            }
                break;

            case R.id.italian_btn:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.italian_url));
                startActivity(intent);
            }
                break;
            case R.id.brazilian_btn:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.brazilian_url));
                startActivity(intent);
            }
                break;
            case R.id.korean_btn:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.korean_url));
                startActivity(intent);
            }
            break;

            case R.id.indonesian_btn:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.indonesian_url));
                startActivity(intent);
            }
                break;
            case R.id.arabic_btn:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.arabic_url));
                startActivity(intent);
            }
                break;
            case R.id.spanish_button:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.spanish_url));
                startActivity(intent);
            }
                break;
          /*  case R.id.french_btn:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.french_url));
                startActivity(intent);
            }
                break;*/

            /*case R.id.spanish_btn:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.spanish_url));
                startActivity(intent);
            }

            break;*/
            case R.id.thiland_btn:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.thiland_url));
                startActivity(intent);
            }

            case R.id.sweden_btn:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.sweden_url));
                startActivity(intent);
            }
                break;
            case R.id.portugal_btn:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.portugal_url));
                startActivity(intent);
            }
                break;
            case R.id.norway_btn:
            {
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("url", getString(R.string.norway_url));
                startActivity(intent);
            }
                break;
            case R.id.back_icon:
                finish();
            break;
        }


    }
}
