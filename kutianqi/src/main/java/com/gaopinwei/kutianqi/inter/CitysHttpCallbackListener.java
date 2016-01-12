package com.gaopinwei.kutianqi.inter;

/**
 *  下载省市资源返回数据回调接口
 */
public interface CitysHttpCallbackListener {

    /*
     *  下载完成
     *
     *  @param response 下载获得的数据
     */

    void onFinish(String response);

    //下载失败
    void onError(Exception e);
}
