package com.example.willi.imagecamera;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by willi on 10/11/2017.
 */

public class DBOpenHelper extends SQLiteOpenHelper {
    SQLiteDatabase dba;
    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        Log.i("openHelper","isThere");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("DB","IsCreated");
        this.dba = db;
        String createQuery="CREATE TABLE foto"+"(_id integer primary key autoincrement,"+"name TEXT, path TEXT);";
        dba.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
