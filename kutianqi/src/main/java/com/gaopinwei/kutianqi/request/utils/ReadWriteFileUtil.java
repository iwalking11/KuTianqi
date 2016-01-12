package com.gaopinwei.kutianqi.request.utils;

import android.content.Context;

import com.gaopinwei.kutianqi.base.MyApp;

import org.apache.http.util.EncodingUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2015/11/12.
 *
 * 天气信息操作类
 */
public class ReadWriteFileUtil {
    /**
     * 将天气信息写入本地
     * @param fileName
     * @param message
     */
    public static void writeFileData(String fileName,String message){
        try{
            FileOutputStream fout = MyApp.getInstance().openFileOutput(fileName, Context.MODE_PRIVATE);
            byte [] bytes = message.getBytes();
            fout.write(bytes);
            fout.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
     * 从本地读取天气信息
     * @param fileName
     * @return
     */
    public static String readFileData(String fileName){
        String res="";
        try{
            FileInputStream fin = MyApp.getInstance().openFileInput(fileName);
            int length = fin.available();
            byte [] buffer = new byte[length];
            fin.read(buffer);
            res = EncodingUtils.getString(buffer, "UTF-8");
            fin.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }
}
