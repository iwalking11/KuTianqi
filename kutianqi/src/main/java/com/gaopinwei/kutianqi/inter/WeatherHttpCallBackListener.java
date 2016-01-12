package com.gaopinwei.kutianqi.inter;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.io.UnsupportedEncodingException;

/**
 * 天气信息请求回调
 *
 */
public class WeatherHttpCallBackListener extends AsyncHttpResponseHandler {

    private Handler handler;
    private int what;

    public WeatherHttpCallBackListener(Handler handler, int what) {
        this.handler = handler;
        this.what = what;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        try {

            //在此对返回内容做处理
            Log.e("tianqi",new String(responseBody,"utf-8"));
            Message message = handler.obtainMessage();
            message.what = what;
            message.obj = new String(responseBody,"utf-8");
            handler.sendMessage(message);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
        Log.e("tianqi","呵呵呵呵");
    }
}
