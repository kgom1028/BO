package com.kgom.binaryoptions.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kgom.binaryoptions.R;
import com.kgom.binaryoptions.doc.UserInfo;

import org.w3c.dom.Text;

/**
 * Created by KJS on 1/3/2017.
 */
public class GetStartActivity extends BaseActivity {
    UserInfo userInfo;
    View nextButton, previousButton;
    TextView exitLabel;
    ViewGroup background;
    ImageView indicator;
    ViewGroup openAccount;
    int currentPage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_basic);
        userInfo = UserInfo.getInstance();
        attachHandle();
        initialize();
    }

    public void attachHandle()
    {
        nextButton = findViewById(R.id.next_btn);
        previousButton = findViewById(R.id.previous_btn);
        nextButton.setVisibility(View.GONE);
        previousButton.setVisibility(View.GONE);

        indicator = (ImageView) findViewById(R.id.tut_indicator);
        background = (ViewGroup) findViewById(R.id.background);
        exitLabel = (TextView) findViewById(R.id.exit_label);
        openAccount = (ViewGroup) findViewById(R.id.open_account);

        nextButton.setVisibility(View.GONE);
        previousButton.setVisibility(View.GONE);
        exitLabel.setVisibility(View.VISIBLE);
        openAccount.setVisibility(View.VISIBLE);
        indicator.setImageResource(R.drawable.tut_indicator_4);
        background.setBackgroundResource(R.drawable.tut_4);
    }

    public void initialize()
    {
        exitLabel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GetStartActivity.this, MenuActivity.class));
            }
        });

        openAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GetStartActivity.this, FreeDemoActivity.class));
            }
        });

    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.back_icon: {

                    finish();
            }
            break;
        }
    }

}
