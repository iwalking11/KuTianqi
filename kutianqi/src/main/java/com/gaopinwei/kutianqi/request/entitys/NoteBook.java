package com.gaopinwei.kutianqi.request.entitys;

/**
 * Created by xiazhenjie on 2015/11/12.
 *
 * 日记实体类
 */
public class NoteBook implements Comparable<NoteBook>{

    private int _id;  //编号
    private String title; //标题
    private String content; //内容
    private String pathName;//图片路径

    public NoteBook() {
    }

    public NoteBook(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public NoteBook(int _id, String title, String content) {
        this._id = _id;
        this.title = title;
        this.content = content;
    }

    public NoteBook(int _id, String title, String content, String pathName) {
        this._id = _id;
        this.title = title;
        this.content = content;
        this.pathName = pathName;
    }

    public NoteBook(String title, String content, String pathName) {
        this.title = title;
        this.content = content;
        this.pathName = pathName;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(NoteBook another) {
        return 0;
    }
}
