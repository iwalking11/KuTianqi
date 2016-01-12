package com.gaopinwei.kutianqi.request.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *  日记数据库帮助类
 *
 */
public class NoteBookOpenHelper extends SQLiteOpenHelper {

    public static final String CREATE_NOTEBOOK = "create table notebook ("
            + "_id integer primary key autoincrement, "
            + "title varchar(50), "
            +"content text,"
            + "pathName varchar(100))";


    //构造方法
    public NoteBookOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //建表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_NOTEBOOK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
