package com.gaopinwei.kutianqi.base;

import android.app.Application;
import android.os.Handler;
import android.os.Message;

/**
 * Created by Administrator on 2015/11/12.
 */
public class MyApp extends Application {

    private static MyApp instance;

    //构建EventBus实例

    public static MyApp getInstance() {

        return instance;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    // 共享变量
    private Handler handler = null;

    // set方法
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    // get方法
    public Handler getHandler() {
        return handler;
    }

}
