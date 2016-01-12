package com.gaopinwei.kutianqi.fragment;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gaopinwei.kutianqi.R;
import com.gaopinwei.kutianqi.adapters.NewsAdapter;
import com.gaopinwei.kutianqi.request.entitys.News;
import com.gaopinwei.kutianqi.request.utils.DividerItemDecoration;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    private  Activity activity;
    private RecyclerView rv_news;
    private SwipeRefreshLayout swipe_refresh_widget;
    private LinearLayoutManager mLayoutManager;
    int lastVisibleItem ;
    int page = 1 ;
    List<Integer>  pagelist = new ArrayList<>();
     int maxpage = Integer.MAX_VALUE;
    News news = new News();
    private List<News.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity> newslist  = new ArrayList<>();
    private NewsAdapter adapter;
    private HttpUtils httpUtils = new HttpUtils();
    private  String proviceName;//城市所在省名

    private ProgressDialog progressDialog;

    public NewsFragment(String proviceName) {

        this.proviceName = proviceName;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("proviceName",proviceName);
        mLayoutManager = new LinearLayoutManager(activity) ;
        //在这里对fragment进行初始化
        View view =  inflater.inflate(R.layout.fragment_news, container, false);
        showProgressDialog();
        initView(view);
        //读取本地数据，第一页
        //验证本次城市和上次城市是否为同一城市，不是的话也要直接网络请求

        onRefresh();
//        if(isFrist)
//        {
//
//
//        }
//        else {
//            String string = getDataFromFile();
//            news = new Gson().fromJson(string, News.class);
//            newslist.addAll(news.getShowapi_res_body().getPagebean().getContentlist());//获取数据源
//            adapter.notifyDataSetChanged();
//            swipe_refresh_widget.setRefreshing(false);
//
//        }
        closeProgressDialog();

        //添加滑动监听
        rv_news.setOnScrollListener(new RecyclerView.OnScrollListener() {
                                        @Override
                                        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                                            super.onScrollStateChanged(recyclerView, newState);
                                            if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()) {//当recycleview显示出最后一条
                                                //下载数据，解析
                                                // handler.sendEmptyMessageDelayed(0, 3000);
                                                Log.e("show", "recycleview显示出最后一条");
                                                if (!pagelist.contains(page)) {//已加载page中包含此page，则不再执行加载
                                                    downloadJson(page,proviceName);
                                                }
                                            }
                                        }

                                        @Override
                                        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                                            super.onScrolled(recyclerView, dx, dy);
                                            lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
                                            }
                                    }

        );
        return  view;
    }

    /**
     * 初始化界面
     * @param view
     */
    private void initView(final View view) {
        swipe_refresh_widget = ((SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_widget));
        rv_news = ((RecyclerView) view.findViewById(R.id.rv_news));


        swipe_refresh_widget.setRefreshing(true);
        swipe_refresh_widget.setColorSchemeColors(R.color.green, R.color.blue, R.color.orange);
        swipe_refresh_widget.setOnRefreshListener(this);
        //第一次进入界面时加载进度条
        swipe_refresh_widget.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));


        rv_news.setHasFixedSize(true);
        rv_news.setLayoutManager(mLayoutManager);
        rv_news.setItemAnimator(new DefaultItemAnimator());
        //recycleview添加分割线
        DividerItemDecoration divider = new DividerItemDecoration(activity, LinearLayoutManager.VERTICAL);
        rv_news.addItemDecoration(divider);

        adapter = new NewsAdapter(activity, newslist, getFragmentManager());
        rv_news.setAdapter(adapter);


    }

    private void downloadJson(final int p,String city) {
        Toast.makeText(activity,"正在请求哦，要对时间有耐心......",Toast.LENGTH_LONG).show();
        if(p !=1 )
           pagelist.add(p);//请求时将当前page放进集合
        if(page > maxpage)
       {
           Toast.makeText(activity,"没有更多数据了",Toast.LENGTH_LONG).show();
           return;
       }
       RequestParams params = getparams(city, p);
        httpUtils.send(HttpRequest.HttpMethod.POST, "http://route.showapi.com/170-47", params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                Log.e("Json", responseInfo.result);
//                if (p == 1) {
//                    //保存数据
//                    saveDataToFile(responseInfo.result);
//                    isFrist = false;
//                }
                //请求成功
                JSONObject obj = null;
                try {
                    obj = new JSONObject(responseInfo.result);
                    String error = obj.getString("showapi_res_error");
                    if (!error.equals("")) {//如果返回数据有错误信息，就弹出吐司说明错误
                        Toast.makeText(activity, error, Toast.LENGTH_LONG).show();
                         closeProgressDialog();
                        return;
                    }
                    else {
                        news = new Gson().fromJson(responseInfo.result, News.class);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

               //Log.e("newslist", news.getShowapi_res_body().getPagebean().getContentlist().size() + "");
                if (news.getShowapi_res_body().getPagebean().getContentlist() != null) {

                    maxpage = news.getShowapi_res_body().getPagebean().getAllPages();
                    if (p == 1) {
                        newslist.clear();
                    }
                    newslist.addAll(news.getShowapi_res_body().getPagebean().getContentlist());//获取数据源
                    page++;
                }
               // Log.e("newslist", newslist.size() + "");
                adapter.notifyDataSetChanged();
                swipe_refresh_widget.setRefreshing(false);
                closeProgressDialog();
            }

            @Override
            public void onFailure(HttpException error, String msg) {
                //Log.e("Json", "网络错误");
                //请求不成功，将pagelist中的刚添加的p移除
                Toast.makeText(activity, "网络请求失败", Toast.LENGTH_LONG).show();
                if (p != 1 && pagelist.contains(p))
                    pagelist.remove(p);
                swipe_refresh_widget.setRefreshing(false);
                closeProgressDialog();


            }
        });

    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;

    }

    @Override
    public void onRefresh() {
        //刷新时，重新加载第一页数据,page置为一,pagelist置为空
        showProgressDialog();
        swipe_refresh_widget.setRefreshing(true);
        page = 1;
        pagelist.clear();
        downloadJson(page, proviceName);


    }


    /**
     * 获得请求参数
     * @param string
     * @param p
     * @return
     */
    private RequestParams getparams(String string, int p) {

        Date time =new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestr =format.format(time);
        //Log.e("timestr", timestr);
        RequestParams params = new RequestParams();
        params.addBodyParameter("showapi_appid", "11976");//应用ID
        params.addBodyParameter("showapi_sign", "45c22790028c41ceba1a95fd257039c1");//应用签名
        params.addBodyParameter("showapi_timestamp", timestr);//当前时间
        params.addBodyParameter("areaName", string);//参数城市名
        params.addBodyParameter("page", p + "");//参数城市名

        return params;
    }


//    /**
//     * 保存第一页新闻信息到文件
//     * @param string
//     */
//    private void saveDataToFile(String string) {
//
//        FileOutputStream ops = null;
//        OutputStreamWriter outputStreamWriter = null;
//        BufferedWriter bufferedWriter = null;
//        try {
//            ops = activity.openFileOutput("NewsJson", Context.MODE_PRIVATE);
//            outputStreamWriter = new OutputStreamWriter(ops);
//            bufferedWriter = new BufferedWriter(outputStreamWriter);
//            bufferedWriter.write(string);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (bufferedWriter != null) {
//                try {
//                    bufferedWriter.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

//    /**
//     * 从文件中获取上次保存的第一页json数据
//     * @return
//     */
//
//    public String getDataFromFile() {
//        FileInputStream fileInputStream=null;
//        InputStreamReader inputStreamReader=null;
//        BufferedReader bufferedReader=null;
//        StringBuilder stringBuilder=null;
//        String line=null;
//        try {
//            stringBuilder=new StringBuilder();
//            fileInputStream=activity.openFileInput("NewsJson");
//            inputStreamReader=new InputStreamReader(fileInputStream);
//            bufferedReader=new BufferedReader(inputStreamReader);
//            while((line=bufferedReader.readLine())!=null){
//                stringBuilder.append(line);
//            }
//          //  Log.e("--->", stringBuilder.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            try {
//                if (bufferedReader!=null) {
//                    bufferedReader.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return stringBuilder.toString();
//    }
//


    //显示进度条
    private void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(activity);
            progressDialog.setMessage("正在加载...");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }

    //关闭进度条
    private void closeProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
