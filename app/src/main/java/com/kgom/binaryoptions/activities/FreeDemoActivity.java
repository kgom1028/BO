package com.kgom.binaryoptions.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kgom.binaryoptions.R;
import com.kgom.binaryoptions.doc.UserInfo;
import com.kgom.binaryoptions.views.AlertDialog;

/**
 * Created by KJS on 1/3/2017.
 */
public class FreeDemoActivity extends BaseActivity{
    UserInfo userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freedemo);
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
            case R.id.freedemoBtn:
                alertShow();

             /*   userInfo.selectedUrl = 0;
                startActivity(new Intent(this, WebViewActivity.class));*/
                break;
        }


    }

    private void alertShow(){
        AlertDialog dialog = new AlertDialog(this, getString(R.string.alert_freedemo));
        dialog.showDialog();
        dialog.setListener(new AlertDialog.AlertDialogListener() {
            @Override
            public void onOkButtonPressed() {

                startActivity(new Intent(FreeDemoActivity.this , LanguageSelectActivity.class));
            }
        });
    }
}
