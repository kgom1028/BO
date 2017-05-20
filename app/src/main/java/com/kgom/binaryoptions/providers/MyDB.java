package com.kgom.binaryoptions.providers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Message;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.kgom.binaryoptions.models.MessageModel;


/**
 * Created by KJS on 4/23/2016.
 */
public class MyDB {
    // Database fields
    private SQLiteDatabase database;
    private DBHelper mDBHelper;
    private Context  ctx;
    public MyDB(Context ctx)
    {
        mDBHelper = new DBHelper(ctx);
        database = mDBHelper.getWritableDatabase();
    }
    public void closeDB()
    {
        database.close();
    }
    public void SetContext(Context context) {
        this.ctx = context;
    }

    public void insertNotifications(List<MessageModel> items)
    {
        for(MessageModel item : items)
        {
            insertNotification(item);
        }
    }
    public void insertNotification(MessageModel item)
    {
        ContentValues values =new ContentValues();
        values.put(DBHelper.KEY_ID, item.mId);
        values.put(DBHelper.KEY_CONTENT, item.mContent);
        values.put(DBHelper.KEY_TITLE, item.mTitle);
        values.put(DBHelper.KEY_READ, item.mRead);
        values.put(DBHelper.KEY_TIME, item.mTime);
        database.insert(DBHelper.TABLE_NOTIFICATION, null, values);

    }

    public int updateNotifications(List<MessageModel> items)
    {
        int result = 0;
        for(MessageModel item: items)
        {
            result += updateNotification(item);
        }
        return result;
    }
    public int updateNotification(MessageModel item)
    {
        ContentValues values = new ContentValues();
        values.put(DBHelper.KEY_ID, item.mId);
        values.put(DBHelper.KEY_TITLE, item.mTitle);
        values.put(DBHelper.KEY_CONTENT, item.mContent);
        values.put(DBHelper.KEY_READ, item.mRead);
        values.put(DBHelper.KEY_TIME, item.mTime);
// updating row
        return database.update(DBHelper.TABLE_NOTIFICATION, values, DBHelper.KEY_ID + " = ?",
                new String[]{String.valueOf(item.mId)});
    }

    public int deleteNotifications(List<MessageModel> items)
    {
        int result = 0;
        for(MessageModel item : items)
        {
            result += deleteNotification(item);
        }
        return result;
    }
    public int deleteNotification(MessageModel item)
    {
        return database.delete(DBHelper.TABLE_NOTIFICATION, DBHelper.KEY_ID + "= ?",new String[]{String.valueOf(item.mId)});
    }

    public List<MessageModel> getAllNotifications()
    {
        List<MessageModel> notifications = new ArrayList<MessageModel>();
    String selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NOTIFICATION +" ORDER BY "+ DBHelper.KEY_ID +" DESC" ;

        Cursor cursor = database.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MessageModel notification = new MessageModel();
                notification.mId = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_ID));
                notification.mTitle = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_TITLE));
                notification.mContent = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_CONTENT));
                notification.mRead = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_READ));
                notification.mTime = cursor.getLong(cursor.getColumnIndex(DBHelper.KEY_TIME));
                notifications.add(notification);
            } while (cursor.moveToNext());
        }

        return notifications;

    }

    public MessageModel getNotification(int notification_id)
    {

        String selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NOTIFICATION +" WHERE "+ DBHelper.KEY_ID + "=" + notification_id ;
        MessageModel notification = new MessageModel();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()) {
            notification.mId = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_ID));
            notification.mTitle = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_TITLE));
            notification.mContent = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_CONTENT));
            notification.mRead = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_READ));
            notification.mTime = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_TIME));
        }
        cursor.close();
        return notification;
    }
    public boolean NotificationExist(int notification_id)
    {
        Cursor mCount = database.rawQuery("select count(*) from "+DBHelper.TABLE_NOTIFICATION +" WHERE "+DBHelper.KEY_ID+"="+notification_id,null);
        mCount.moveToFirst();
        int count = mCount.getInt(0);
        mCount.close();
        return count > 0;
    }


}
