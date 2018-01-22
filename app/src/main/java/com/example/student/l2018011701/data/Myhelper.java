package com.example.student.l2018011701.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Student on 2018/1/22.
 */

public class Myhelper extends SQLiteOpenHelper {
    public static String DB_NAME = "student.sqlite";
    public static  int VERSION = 1 ;
    public Myhelper(Context context)
    {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE `students` ( `_id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT, `score` INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
