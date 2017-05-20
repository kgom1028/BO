package com.kgom.binaryoptions.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kgom.binaryoptions.R;
import com.kgom.binaryoptions.adapters.NotificationAdapter;
import com.kgom.binaryoptions.models.MessageModel;
import com.kgom.binaryoptions.providers.MyDB;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by KJS on 9/10/2016.
 */
public class NotificationActivity extends BaseActivity {
    private ListView notificationList;
    private List<MessageModel> notificationItems;
    private NotificationAdapter notificationAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        attachHandle();
        initialize();
        getNotifications();
    }

    public void attachHandle()
    {
        notificationList = (ListView) findViewById(R.id.notification_list);
    }

    private void getNotifications()
    {
        MyDB myDB = new MyDB(this);
        notificationItems =  myDB.getAllNotifications();
        myDB.closeDB();
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_icon:
                finish();
                break;
        }
    }
    public void initialize()
    {
        notificationItems = new ArrayList<MessageModel>();
        getNotifications();
        notificationAdapter = new NotificationAdapter(this, notificationItems);
        notificationList.setAdapter(notificationAdapter);
        notificationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

            }
        });
    }
}
