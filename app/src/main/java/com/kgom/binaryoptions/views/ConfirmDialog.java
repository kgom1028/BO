package com.kgom.binaryoptions.views;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.kgom.binaryoptions.R;

/**
 * Created by KJS on 1/3/2017.
 */
public class ConfirmDialog extends Dialog {

    private Context mContext;
    ConfirmDialogListener _listener;
    String confirmString;
    String agree = "Ok";
    String disagree = "Cancel";

    public ConfirmDialog(Context mContext, String confirmString, String agree, String disagree)
    {
        super(mContext);
        this.mContext = mContext;
        this.confirmString = confirmString;
        if(agree != null && disagree != null){
            this.agree = agree;
            this.disagree = disagree;
        }
    }


    public interface ConfirmDialogListener{
        public void onOkButtonPressed();
        public void onCancelButtonPressed();
    }
    public void setListener(ConfirmDialogListener listener)
    {
        _listener = listener;
    }

    public void showDialog(){

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCancelable(true);
        setContentView(R.layout.dialog_confirm);
        TextView textView =  (TextView) findViewById(R.id.confirm_txt);
        textView.setText(confirmString);

        Button dialogCancelButton = (Button) findViewById(R.id.btn_dialog_cancel);
        dialogCancelButton.setText(disagree);
        dialogCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _listener.onCancelButtonPressed();
                dismiss();

            }
        });

        Button dialogOkButton = (Button) findViewById(R.id.btn_dialog_ok);
        dialogOkButton.setText(agree);
        dialogOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _listener.onOkButtonPressed();
                dismiss();
            }
        });

        show();

    }


}