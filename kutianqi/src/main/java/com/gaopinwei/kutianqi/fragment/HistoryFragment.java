package com.gaopinwei.kutianqi.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gaopinwei.kutianqi.R;
import com.gaopinwei.kutianqi.adapters.HistoryAdapter;
import com.gaopinwei.kutianqi.base.BaseFragment;
import com.gaopinwei.kutianqi.base.MyApp;
import com.gaopinwei.kutianqi.request.entitys.History;
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
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;


public class HistoryFragment extends BaseFragment {

   private  ListView lv_history_show;
    private TreeSet<History> historys = new TreeSet<>();
    private List<History> list = new ArrayList<>();
    private Context context;
    private HistoryAdapter adapter;
    private SharedPreferences sf ;

    private SharedPreferences.Editor editor;
     private  String cityname;
    public HistoryFragment( Context context) {
        this.context = context;
        sf =  context.getSharedPreferences("history", Context.MODE_PRIVATE);
        editor = sf.edit();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        cityname = getArguments().getString("city");
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        lv_history_show =  ((ListView) view.findViewById(R.id.lv_history_show));
        adapter = new HistoryAdapter(context,list);
        //加载数据
        downloadHistory();

        View  headerview = LayoutInflater.from(context).inflate(R.layout.fragment_history_headerview,null);

        //设置footerview
        View footerView = LayoutInflater.from(context).inflate(R.layout.fragment_history_footerview,null);
        TextView history_footer = ((TextView) footerView.findViewById(R.id.history_footer));
         history_footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击跳转到心情记录界面
                //提醒主界面该变Fragment04
                MyApp.getInstance().getHandler().sendEmptyMessage(777);
            }
        });

        lv_history_show.addHeaderView(headerview);
        lv_history_show.addFooterView(footerView);
        lv_history_show.setAdapter(adapter);

        return view;
    }

    private void downloadHistory() {
        String historytime = sf.getString("historytime", "");
        String  result =  sf.getString("result", "") ;

        //Log.e("historytime",historytime+"..........");
        //Log.e("result", result  +"************");

        //获取当前时间（按年月日）
        Date time =new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String timestr =format.format(time);


        if(historytime.equals(timestr) && !result.equals(""))
        {//当存储信息时间和当前时间是同一天，并且result不为“”时，从SharedPreferences中获取Json字符串
          // Log.e("Test","historytime和timestr是一样的哦！");
            //Log.e("result", result);

            try {
                JSONObject obj = new JSONObject(result);
                JSONObject obj1 = obj.getJSONObject("showapi_res_body");
                Iterator keys = obj1.keys();
                historys.clear();
                while (keys.hasNext()) {
                    String key = keys.next().toString();
                    String value = obj1.getString(key);
                    historys.add(new History(key, value));
                }
                list.addAll(historys);
                adapter.notifyDataSetChanged();
                Log.e("responseInfo", historys.size() + "");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }
        editor.putString("historytime", timestr);
        editor.commit();
       // Log.e("timestr",timestr);
        Toast.makeText(context,"正在加载，要对时间有耐心......",Toast.LENGTH_LONG).show();
        //下载数据解析
        HttpUtils httpUtils = new HttpUtils();
        RequestParams params =  getparams();
        httpUtils.send(HttpRequest.HttpMethod.POST, "http://route.showapi.com/148-1", params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                Log.e("responseInfo", responseInfo.result);
                //解析
                try {
                    JSONObject obj = new JSONObject(responseInfo.result);
                    String error = obj.getString("showapi_res_error");
                    if (error.equals("")) {
                        Message msg = new Message();
                        msg.what = 1;
                        msg.obj = responseInfo.result;
                        handler.sendMessage(msg);

                        JSONObject obj1 = obj.getJSONObject("showapi_res_body");
                        Iterator keys = obj1.keys();
                        historys.clear();
                        while (keys.hasNext()) {
                            String key = keys.next().toString();
                            String value = obj1.getString(key);
                            historys.add(new History(key, value));
                        }
                        list.addAll(historys);
                        adapter.notifyDataSetChanged();
                        Log.e("responseInfo", historys.size() + "");
                    } else {
                        Toast.makeText(context, error, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(HttpException error, String msg) {
                Toast.makeText(context, "网络连接出错了哦！", Toast.LENGTH_LONG).show();
            }
        });

    }


    /**
     * 获得请求参数
     */
    private RequestParams getparams() {

        Date time =new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestr =format.format(time);
       // Log.e("timestr", timestr);
        RequestParams params = new RequestParams();
        params.addBodyParameter("showapi_appid", "11976");//应用ID
        params.addBodyParameter("showapi_sign", "45c22790028c41ceba1a95fd257039c1");//应用签名
        params.addBodyParameter("showapi_timestamp", timestr);//当前时间

        return params;
    }


    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    editor.putString("result", (String) msg.obj);
                    editor.commit();
                    break;
            }
        }
    };
}
