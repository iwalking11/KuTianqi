package com.gaopinwei.kutianqi.request.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.gaopinwei.kutianqi.request.entitys.City;
import com.gaopinwei.kutianqi.request.entitys.Province;

import java.util.ArrayList;
import java.util.List;

/**
 *   城市数据库操作类
 *
 */
public class CityDB {

    public static final int VERSION = 1;
    public static final String DB_NAME = "city";
    private static CityDB cityDB;
    private SQLiteDatabase db;

    //单例模式，创建一个数据库
    private CityDB(Context context) {
        CityOpenHelper dbHelper = new CityOpenHelper(context,DB_NAME, null, VERSION);

        //获得数据库操作的实例
        db = dbHelper.getWritableDatabase();
    }

    //synchronized 避免同步创建实例
    public synchronized static CityDB getInstance(Context context) {
        if (cityDB == null) {
            cityDB = new CityDB(context);
        }
        return cityDB;
    }

    //保存省份信息
    public void saveProvince(Province province) {
        if (province != null) {
            ContentValues values = new ContentValues();
            values.put("province_name", province.getProvinceName());
            values.put("province_code", province.getProvinceCode());
            db.insert("Province", null, values);
        }
    }

    //获取各省份的信息
    public List<Province> loadProvinces() {
        List<Province> list = new ArrayList<>();
        Cursor cursor = db.query("Province", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                list.add(province);
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        return list;
    }



    //保存城市的信息
    public void saveCity(City city) {
        if (city != null) {
            ContentValues values = new ContentValues();
            values.put("city_name", city.getCityName());
            values.put("city_code", city.getCityCode());
            values.put("province_id", city.getProvinceId());
            db.insert("City", null, values);
        }
    }

    //获取各城市的信息
    public List<City> loadCities(int provinceId) {
        List<City> list = new ArrayList<>();
        Cursor cursor = db.query("City", null, "province_id=?",
                new String[]{String.valueOf(provinceId)}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                City city = new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                city.setProvinceId(provinceId);
                list.add(city);

            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        return list;
    }

}
