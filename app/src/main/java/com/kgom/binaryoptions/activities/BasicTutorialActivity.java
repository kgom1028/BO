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
public class BasicTutorialActivity extends BaseActivity {
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
        indicator = (ImageView) findViewById(R.id.tut_indicator);
        background = (ViewGroup) findViewById(R.id.background);
        exitLabel = (TextView) findViewById(R.id.exit_label);
        openAccount = (ViewGroup) findViewById(R.id.open_account);

    }

    public void initialize()
    {
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextPage();
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousPage();
            }
        });

        exitLabel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BasicTutorialActivity.this, MenuActivity.class));
               }
        });

        openAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BasicTutorialActivity.this, FreeDemoActivity.class));
            }
        });

        changeScreen(currentPage);
    }
    private void nextPage(){
        currentPage++;
        changeScreen(currentPage);
    }

    private void previousPage(){
        currentPage--;
        changeScreen(currentPage);
    }
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.back_icon: {
                if (currentPage > 0)
                    previousPage();
                else
                    finish();
            }
                break;
        }
    }
    private void changeScreen(int currentPage){

        switch (currentPage){
            case 0: {
                previousButton.setVisibility(View.INVISIBLE);
                nextButton.setVisibility(View.VISIBLE);
                exitLabel.setVisibility(View.INVISIBLE);
                openAccount.setVisibility(View.INVISIBLE);
                indicator.setImageResource(R.drawable.tut_indicator_1);
                background.setBackgroundResource(R.drawable.tut_1);
            }
            break;
            case 1:{
                previousButton.setVisibility(View.VISIBLE);
                nextButton.setVisibility(View.VISIBLE);
                exitLabel.setVisibility(View.INVISIBLE);
                openAccount.setVisibility(View.INVISIBLE);

                indicator.setImageResource(R.drawable.tut_indicator_2);
                background.setBackgroundResource(R.drawable.tut_2);
            }
            break;
            case 2:{
                previousButton.setVisibility(View.VISIBLE);
                nextButton.setVisibility(View.VISIBLE);
                exitLabel.setVisibility(View.INVISIBLE);
                openAccount.setVisibility(View.INVISIBLE);

                indicator.setImageResource(R.drawable.tut_indicator_3);
                background.setBackgroundResource(R.drawable.tut_3);
            }

            break;
            case 3:
                previousButton.setVisibility(View.INVISIBLE);
                nextButton.setVisibility(View.INVISIBLE);
                exitLabel.setVisibility(View.VISIBLE);
                openAccount.setVisibility(View.VISIBLE);

                indicator.setImageResource(R.drawable.tut_indicator_4);
                background.setBackgroundResource(R.drawable.tut_4);
                break;
        }
    }
}
