package com.kgom.binaryoptions.providers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by KJS on 4/23/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE_NOTIFICATION = "tbl_notification";
    private static final String DATABASE_NAME = "com.kgom.binaryoptions.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String TABLE_NOTIFICATION_CREATE = "CREATE TABLE IF NOT EXISTS " + TABLE_NOTIFICATION + " ("
            + "id INTEGER, "
            + "title TEXT, "
            + "content TEXT, "
            + "read int, " //0:unread 1:read
            + "time INTEGER, "
            + "PRIMARY KEY(id)"
            + ");";

    //NOTIFICATION TABLE column names
    public static final String KEY_ID = "id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_CONTENT = "content";
    public static final String KEY_READ = "read";
    public static final String KEY_TIME = "time";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(TABLE_NOTIFICATION_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTIFICATION);
        onCreate(db);
    }

}