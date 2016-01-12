package com.gaopinwei.kutianqi.request.utils;

import android.os.Handler;

import com.gaopinwei.kutianqi.fragment.Fragment01;
import com.gaopinwei.kutianqi.inter.WeatherHttpCallBackListener;
import com.gaopinwei.kutianqi.request.api.ShowApiRequest;

/**
 * Created by xiazhenjie on 2015/11/7.
 *
 * 通过城市名获取天气预报
 */
public class RequestFromServer {

    /*
     * 返回一个json字符串
     * @param cityName 城市名
     * @return
     */
    public void getData(String cityName,Handler handler,int what){
        //当前时间
        String CurrentTime = Fragment01.getFormatedDateTime("yyyyMMddHHmmss", Long.valueOf(System.currentTimeMillis()));
        //请求网络(qingqiu自易源接口)
        new ShowApiRequest("http://route.showapi.com/9-2", "11976", "45c22790028c41ceba1a95fd257039c1")
                .setResponseHandler(new WeatherHttpCallBackListener(handler,what))
                .addTextPara("area", cityName).addTextPara("needMoreDay", "1")
                .addTextPara("needIndex", "1").addTextPara("needAlarm", "1")
                .addTextPara("showapi_timestamp", CurrentTime) .post();
    }

}
