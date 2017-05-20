package com.kgom.binaryoptions.providers;

import android.content.Context;
import android.util.Log;

import com.kgom.binaryoptions.models.MessageModel;
import com.kgom.binaryoptions.providers.MyDB;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by KJS on 9/10/2016.
 */
public class NotificationProcessor {
    private final String  KEY_TITLE = "title";
    private final String KEY_CONTENT = "content";
    private final String KEY_ID  ="id";


    private static final String TAG ="NotificationProcessor";
    public static NotificationProcessor _instance = null;
    public NotificationProcessor()
    {

    }
    public static NotificationProcessor getInstance()
    {
        if(_instance == null)
            _instance = new NotificationProcessor();
        return _instance;
    }

    public void process(Context context, Map<String, String> notification)
    {
        MyDB db = new MyDB(context);
        try {
            MessageModel messageModel = new MessageModel();
            messageModel.mTitle = notification.get(KEY_TITLE);
            messageModel.mContent = notification.get(KEY_CONTENT);
            messageModel.mId =  Integer.parseInt(notification.get(KEY_ID));
            messageModel.mTime = System.currentTimeMillis();
            if(db.NotificationExist(messageModel.mId))
            {
                db.updateNotification(messageModel);
            }else
                db.insertNotification(messageModel);
        }catch (Exception e)
        {
            Log.d(TAG,"JSON Parsing faild");
        }
        db.closeDB();
    }


}
