package com.kgom.binaryoptions.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.kgom.binaryoptions.R;
import com.kgom.binaryoptions.views.AlertDialog;
import com.kgom.binaryoptions.views.ConfirmDialog;



/**
 * Created by KJS on 9/7/2016.
 */
public class WarningActivity extends  BaseActivity {
    ViewGroup warningPopup;
    Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unavailable_warning);
        attachHandle();
        initialize();
    }

    public void attachHandle()
    {
        warningPopup =(ViewGroup) findViewById(R.id.warning_popup);

    }

    public void initialize()
    {
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation bottomUp = AnimationUtils.loadAnimation(WarningActivity.this,
                        R.anim.bottom_up);
                ViewGroup hiddenPanel = (ViewGroup)findViewById(R.id.warning_popup);
                hiddenPanel.startAnimation(bottomUp);
                hiddenPanel.setVisibility(View.VISIBLE);
            }
        },500);


    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.continue_btn:
                startActivity(new Intent(WarningActivity.this, MenuActivity.class));
                break;
        }
    }

    private void confirmShow(){
        ConfirmDialog dialog = new ConfirmDialog(this, getString(R.string.continue_iq), getString(R.string.ok), getString(R.string.cancel));
        dialog.showDialog();
        dialog.setListener(new ConfirmDialog.ConfirmDialogListener() {
            @Override
            public void onOkButtonPressed() {
                startActivity(new Intent(WarningActivity.this, MenuActivity.class));

            }

            @Override
            public void onCancelButtonPressed() {
                alertShow();
            }
        });
    }

    private void alertShow(){
        AlertDialog dialog = new AlertDialog(this, getString(R.string.alert_redirect));
        dialog.showDialog();
        dialog.setListener(new AlertDialog.AlertDialogListener() {
            @Override
            public void onOkButtonPressed() {
                try {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.iq_robot_url)));
                    startActivity(myIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(WarningActivity.this, "No application can handle this request."
                            + " Please install a webbrowser", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }

}
