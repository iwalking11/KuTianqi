package com.gaopinwei.kutianqi.request.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.gaopinwei.kutianqi.request.entitys.City;
import com.gaopinwei.kutianqi.request.entitys.NoteBook;
import com.gaopinwei.kutianqi.request.entitys.Province;

import java.util.ArrayList;
import java.util.List;

/**
 *  日记数据库操作类
 *
 */
public class NoteBookDB {

    public static final int VERSION = 1;
    public static final String DB_NAME = "notebooks";
    private static NoteBookDB notebookDB;
    private SQLiteDatabase db;

    //单例模式，创建一个数据库
    private NoteBookDB(Context context) {
        NoteBookOpenHelper dbHelper = new NoteBookOpenHelper(context,DB_NAME, null, VERSION);

        //获得数据库操作的实例
        db = dbHelper.getWritableDatabase();
    }

    //synchronized 避免同步创建实例
    public synchronized static NoteBookDB getInstance(Context context) {
        if (notebookDB == null) {
            notebookDB = new NoteBookDB(context);
        }
        return notebookDB;
    }

    //保存日记信息
    public void saveNotebook(NoteBook noteBook) {
        if (noteBook != null) {
            ContentValues values = new ContentValues();
            values.put("title", noteBook.getTitle());
            values.put("content", noteBook.getContent());
            values.put("pathName",noteBook.getPathName());
            db.insert("notebook", null, values);
            Log.e("xiazhenjie","写进来了");
        }
    }

    //获取所有日记信息
    public List<NoteBook> queryAll() {
        List<NoteBook> list = new ArrayList<>();
        Cursor cursor = db.query("notebook", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                NoteBook noteBook = new NoteBook();
                noteBook.set_id(cursor.getInt(cursor.getColumnIndex("_id")));
                noteBook.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                noteBook.setContent(cursor.getString(cursor.getColumnIndex("content")));
                noteBook.setPathName(cursor.getString(cursor.getColumnIndex("pathName")));
                list.add(noteBook);
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        return list;
    }

    /**
     * 根据标题查询正文内容
     */
    public String queryByTitle(String title){

        Cursor cursor = db.query("notebook", new String[]{"_id", "title", "content","pathName"}, "title=?", new String[]{title}, null, null, null);
        if(cursor!=null){
            if(cursor.moveToFirst()){
                String content = cursor.getString(cursor.getColumnIndex("content"));
                return content;
            }
        }
        return null;
    }
    /**
     * 根据标题查询图片路径pathName
     */
    public String queryPathByTitle(String title){

        Cursor cursor = db.query("notebook", new String[]{"_id", "title", "content","pathName"}, "title=?", new String[]{title}, null, null, null);
        if(cursor!=null){
            if(cursor.moveToFirst()){
                String content = cursor.getString(cursor.getColumnIndex("pathName"));
                return content;
            }
        }
        return null;
    }

    /**
     * 根据"标题"修改标题和正文以及图片路径
     *
     */
    public int update(NoteBook noteBook){
        ContentValues values = new ContentValues();
        values.put("content", noteBook.getContent());
        values.put("title", noteBook.getTitle());
        values.put("pathName",noteBook.getPathName());
        int cursor = db.update("notebook", values, "title=?", new String[]{noteBook.getTitle()});
        return cursor;
    }

    /**
     * 根据标题删除某一条
     *
     */
    public int deleteByTitle(String title){
        int cursor = db.delete("notebook", "title=?", new String[]{title});
        return cursor;
    }

}
