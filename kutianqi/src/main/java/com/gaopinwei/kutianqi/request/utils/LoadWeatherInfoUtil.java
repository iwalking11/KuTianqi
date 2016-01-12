package com.gaopinwei.kutianqi.request.utils;

import android.os.Handler;
import android.os.Message;

/**
 * Created by Administrator on 2015/11/12.
 *
 * 请求网络信息
 *
 */
public class LoadWeatherInfoUtil {
    private static String content;  //接收获取的天气信息
    private String cityName; //当前城市的名字

    public LoadWeatherInfoUtil( String cityName) {
        this.cityName = cityName;
        loadData();
    }

    /**
     * 获得并处理请求到的数据
     */
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1001:
                    content = msg.obj.toString();
                    //写入本地
                    ReadWriteFileUtil.writeFileData(cityName + ".txt", content);
                    break;
            }
        }
    };

    /**
     *  根据城市名获取当地的天气信息
     */
    private void loadData(){
        new RequestFromServer().getData(cityName, handler, 1001);
    }

    /**
     * 返回获取的城市天气信息
     * @return
     */
    public  String getData(){
        if ("".equals(content)){
        return content;
        }
        return "";
    }

}
