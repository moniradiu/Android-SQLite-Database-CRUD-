package com.example.munira.sqlitapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Munira on 22-Mar-18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    /*part:1*/
    public static final String DATABASE_NAME="student.db";
    /*part:2*/
    public static final String TABLE_NAME="student_data";

    /*part:3*/
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="SURNAME";
    public static final String COL_4="MARKS";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
