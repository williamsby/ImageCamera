package com.example.willi.imagecamera;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by willi on 10/11/2017.
 */

public class DBMasters {
    private static final String DB_NAME = "foto.db";
    private SQLiteDatabase database;
    private DBOpenHelper databaseOpenHelper;

    public DBMasters(Context context){
        databaseOpenHelper = new DBOpenHelper(context,DB_NAME,null,1);
        Log.i("Master","isThere");
    }

    public void open() throws SQLException {
        database = databaseOpenHelper.getWritableDatabase();
    }

    public void read() throws SQLException{
        database = databaseOpenHelper.getReadableDatabase();
    }

    public void close(){
        if (database!=null) database.close();
    }

    public void insertData(String name,String path){
        ContentValues newTamu = new ContentValues();
        newTamu.put("name",name);
        newTamu.put("path",path);

        open();
        database.insert("foto",null,newTamu);
        close();
    }

    public void deleteData(String id){
        open();
        database.delete("foto","_id="+id,null);
        close();
    }

    public Cursor selectAll(){
        open();
        read();
        return database.query("foto",new String[]{"_id","name","path"},null,null,null,null,"name");
    }
}
