package com.example.faizankhan.logindemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String LOGIN_TABLE_NAME = "logindetails";
    public static final String USERNAME_ID = "id";
    public static final String LOGIN_USERNAME = "username";
    public static final String LOGIN_NAME = "loginname";
    public static final String LOGIN_PASSWORD = "password";
    public static final String LOGIN_MOBILE = "mobile";

    public DBHelper(Context context)
    {

        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table logindetails"+
                        "(username text primary key,  loginname text, password text,mobile text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists logindetails");
        onCreate(db);
    }

    public boolean insertDetails(String username,String loginname, String password,  String mobile  )
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user",username);
        values.put("loginname",loginname);
        values.put("password",password);
        values.put("mobile",mobile);
        db.insert("logindetails",null,values);
        return true;
    }

    public Cursor getData(String username)
    {
        SQLiteDatabase db= getReadableDatabase();
        Cursor r = db.rawQuery("select * from logindetails where username="+username+"",null);
        return  r;

    }
}
