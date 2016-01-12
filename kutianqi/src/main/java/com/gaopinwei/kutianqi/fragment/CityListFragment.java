package com.gaopinwei.kutianqi.fragment;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gaopinwei.kutianqi.R;
import com.gaopinwei.kutianqi.adapters.SelectedCityAdapter;
import com.gaopinwei.kutianqi.base.BaseFragment;
import com.gaopinwei.kutianqi.base.MyApp;
import com.gaopinwei.kutianqi.request.entitys.WeatherEntity;
import com.gaopinwei.kutianqi.request.utils.ReadWriteFileUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 * <p/>
 * 已订阅城市列表展示界面
 */
public class CityListFragment extends BaseFragment implements View.OnClickListener {
//    private View rootView;

    private List<String> tempList;
    private List<String> imageList;
    private List<String> weatherList;
    private String data;
    private ListView cityList;

    private boolean ischanged = false;//是否已经编辑过已订阅城市
    private TextView dingyue;
    private ImageView back;

    public CityListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_city_list, container, false);

        //准备数据源
        setData();

        //初始化控件
        initView(view);

        return view;

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setData() {
        tempList = new ArrayList<>();
        imageList = new ArrayList<>();
        weatherList = new ArrayList<>();

        //获取城市名
        SharedPreferences city = activity.getSharedPreferences("city", Context.MODE_PRIVATE);
        LinkedHashSet<String> defaultSet = new LinkedHashSet<>();
        defaultSet.add("北京");
        Set<String> nameSet = city.getStringSet("name", defaultSet);
        weatherList.addAll(nameSet);
        Collections.sort(weatherList);

        for (int i = 0; i < weatherList.size(); i++) {
            String cityName = weatherList.get(i);
            data = ReadWriteFileUtil.readFileData(cityName + ".txt");

            WeatherEntity entity = new Gson().fromJson(data, WeatherEntity.class);

            if (entity != null && !"{\"showapi_res_code\":0,\"showapi_res_error\":\"\",\"showapi_res_body\":{\"remark\":\"找不到此地名!\",\"ret_code\":-1}}".equals(data)) {//如果本地已经加载完数据

                String temperature = entity.getShowapi_res_body().getNow().getTemperature();
                tempList.add(temperature + "℃");

                String weather_pic = entity.getShowapi_res_body().getNow().getWeather_pic();
                imageList.add(weather_pic);

            }
        }

    }

    private void initView(View view) {
        //回退按钮
        back = (ImageView) view.findViewById(R.id.back);
        back.setOnClickListener(this);

        //已订阅文本展示
        dingyue = ((TextView) view.findViewById(R.id.dingyue));

        //编辑城市列表图片
        ImageView editCity = (ImageView) view.findViewById(R.id.edit_cicy);
        editCity.setOnClickListener(this);

        //右上角的添加更多城市的图片
        ImageView addCity = (ImageView) view.findViewById(R.id.iv_add_city);
        addCity.setOnClickListener(this);

        cityList = (ListView) view.findViewById(R.id.list_view);
        cityList.setAdapter(new SelectedCityAdapter(getActivity(), imageList, weatherList, tempList));

        //给listview添加监听事件
        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView city = (TextView) view.findViewById(R.id.tv_city);
                String cityName = city.getText().toString();

                //使sharedprefrences中存储的当前点击的城市发生改变
                MyApp.getInstance().getSharedPreferences("lastCityName", Context.MODE_PRIVATE).edit().putString("lastCityName", weatherList.get(position)).commit();

                //发送消息,让MainActivity接收已经改变的城市名
                Message message = activity.handler.obtainMessage();
                message.what = 999;
                message.obj = weatherList.get(position);
                activity.handler.sendMessage(message);

                Fragment01 fragment = new Fragment01(cityName);
                ChangeFragmentHelper helper = new ChangeFragmentHelper();

                helper.setTargetFragment(fragment);

                helper.setIsClearStackBack(true);

                activity.changeFragment(helper);
            }
        });

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.iv_add_city://跳转到搜索城市fragment

                if (!ischanged) {

                    Fragment searchFragment = new SearchFragment();
                    ChangeFragmentHelper helper = new ChangeFragmentHelper();
                    Bundle bundle = new Bundle();
                    bundle.putString("type", "SearchFragment");
                    helper.setBundle(bundle);
                    helper.setTargetFragment(searchFragment);
                    helper.setTargetFragmentTag("CityListFragment");
                    activity.changeFragment(helper);

                } else {
                    final Snackbar snackbar = Snackbar.make(back, "请先编辑完数据再返回!", Snackbar.LENGTH_INDEFINITE);
                    snackbar.setAction("确定", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            snackbar.dismiss();
                        }
                    }).show();
                }

                break;

            case R.id.edit_cicy://编辑已订阅城市
                ImageView v1 = (ImageView) v;
                ImageView deleteCity;//左边小红点
                ImageView delete;//右边垃圾箱

                if (!ischanged) {//如果没有编辑过,变成可编辑状态
                    v1.setImageResource(R.mipmap.sns_upload_success);
                    dingyue.setText("正在编辑中");
                    for (int i = 0; i < weatherList.size(); i++) {
                        LinearLayout view = (LinearLayout) cityList.getChildAt(i);
                        deleteCity = (ImageView) view.findViewById(R.id.small_edit_cicy);
                        deleteCity.setVisibility(View.VISIBLE);
                    }
                    ischanged = true;
                } else {
                    v1.setImageResource(R.mipmap.edit);
                    dingyue.setText("已订阅");
                    for (int i = 0; i < weatherList.size(); i++) {
                        LinearLayout view = (LinearLayout) cityList.getChildAt(i);
                        deleteCity = (ImageView) view.findViewById(R.id.small_edit_cicy);
                        delete = (ImageView) view.findViewById(R.id.delete);

                        deleteCity.setImageResource(R.mipmap.city_delete_normal);
                        deleteCity.setVisibility(View.GONE);
                        delete.setVisibility(View.GONE);
                    }
                    ischanged = false;
                }

                break;

            case R.id.back://回到Fragment01

                if (!ischanged) {

                    Fragment01 fragment = new Fragment01();
                    ChangeFragmentHelper helper2 = new ChangeFragmentHelper();

                    helper2.setTargetFragment(fragment);

                    helper2.setIsClearStackBack(true);

                    activity.changeFragment(helper2);

                } else {
                    final Snackbar snackbar = Snackbar.make(back, "请先编辑完数据再返回!", Snackbar.LENGTH_INDEFINITE);
                    snackbar.setAction("确定", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            snackbar.dismiss();
                        }
                    }).show();
                }
                break;
        }
    }

}
