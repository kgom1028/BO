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
public class AlertDialog extends Dialog {

    private Context mContext;
    AlertDialogListener _listener;
    String alertString;

    public AlertDialog(Context mContext, String alertString)
    {
        super(mContext);
        this.mContext = mContext;
        this.alertString = alertString;
    }


    public interface AlertDialogListener{
        public void onOkButtonPressed();
    }
    public void setListener(AlertDialogListener listener)
    {
        _listener = listener;
    }

    public void showDialog(){

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCancelable(true);
        setContentView(R.layout.dialog_alert);
        TextView textView =  (TextView) findViewById(R.id.confirm_txt);
        textView.setText(alertString);

        Button dialogCancelButton = (Button) findViewById(R.id.btn_dialog_ok);
        dialogCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _listener.onOkButtonPressed();
                dismiss();

            }
        });
        show();

    }


}