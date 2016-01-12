package com.gaopinwei.kutianqi.request.utils;

import android.text.TextUtils;
import android.util.Log;

import com.gaopinwei.kutianqi.request.db.CityDB;
import com.gaopinwei.kutianqi.request.entitys.City;
import com.gaopinwei.kutianqi.request.entitys.Province;


/**
 * 解析数据
 *
 */
public class Utility {

    /**
     * 处理省份的信息
     * @param cityDB
     * @param response
     * @return
     */
    public synchronized static boolean handleProvincesResponse(CityDB cityDB,
                                                               String response){
        //isEmpty用于判断""或null
        if(!TextUtils.isEmpty(response)){
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length>0){
                for (String p : allProvinces){
                    //split分离,'\\|'传给正则就是"\|",表示对|进行转义，不作为特殊字符使用

                    Log.e("p",p);
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    //数据格式为"代号|城市",故array[0]为代号
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    cityDB.saveProvince(province);  //存入数据库
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 处理城市的信息
     * @param cityDB
     * @param response
     * @param provinceId
     * @return
     */
    public static boolean handleCitiesResponse(CityDB cityDB,
                                               String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCities = response.split(",");
            if (allCities != null && allCities.length > 0) {
                for (String c : allCities) {
                    String[] array = c.split("\\|");
                    Log.e("Cities",c);
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    cityDB.saveCity(city); //存入数据库
                }
                return true;
            }
        }
        return false;
    }
}
