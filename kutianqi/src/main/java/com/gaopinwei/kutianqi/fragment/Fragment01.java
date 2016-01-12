package com.gaopinwei.kutianqi.fragment;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.gaopinwei.kutianqi.R;
import com.gaopinwei.kutianqi.base.BaseFragment;
import com.gaopinwei.kutianqi.base.MyApp;
import com.gaopinwei.kutianqi.request.entitys.WeatherEntity;
import com.gaopinwei.kutianqi.request.utils.LoadWeatherInfoUtil;
import com.gaopinwei.kutianqi.request.utils.ReadWriteFileUtil;
import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/**
 * 首页,显示此时此地的天气
 */
public class Fragment01 extends BaseFragment {

    private int loadTime;
    private ImageView imageView_share; //分享

    private onBackgroundChangedlistener mainactivity;
    private ProgressDialog progressDialog;
    private TextView textview;
    private TextView textView_yourcity;
    private Button button_alarm;
    private Button button_ziwaixian;
    private TextView textView_date;
    private TextView textView_today_weather;
    private TextView textView_today_temperature;
    private TextView textView_middle_wind;
    private TextView textView_middle_press;
    private TextView textView_jiangshui;
    private ImageView imageView_middle_photo;
    private String alarmIssueContent;//雾霾预警
    private ImageView imageView_settings;

    private TextView textView_buttom_today_weather;
    private TextView textView_buttom_today_temperature;
    private ImageView imageView_buttom_today_weather;

    private TextView textView_buttom_tomorrow_weather;
    private TextView textView_buttom_tomorrow_temperature;
    private ImageView imageView_buttom_tomorrow_weather;
    private WeatherEntity.ShowapiResBodyEntity.F1Entity todayInfo;


    private String city; //从主界面传过来选择的城市名
    private String content; //根据城市名从本地获取的信息（数据源）
    private View view; //首页
    private LoadWeatherInfoUtil loadWeatherInfoUtil;

    private Button button_refresh_fragment01; //刷新按钮

    public Fragment01(String city) {
        this.city = city;
    }

    public Fragment01() {
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment001, container, false); //首页
        //初始化控件
        initViews();

        city = MyApp.getInstance().getSharedPreferences("lastCityName", Context.MODE_PRIVATE).getString("lastCityName", city);

        textView_yourcity.setText(city);

        //从本地读取
        content = ReadWriteFileUtil.readFileData(city + ".txt");

        if (!"{\"showapi_res_code\":0,\"showapi_res_error\":\"\",\"showapi_res_body\":{\"remark\":\"找不到此地名!\",\"ret_code\":-1}}".equals(content)) {

            addListener();

        }


        //如果从本地读取的数据为空,则从网络加载数据
        if ("".equals(content)) {
            showProgressDialog();
            loadWeatherInfoUtil = new LoadWeatherInfoUtil(city); //网络请求
            loadTime = 1;
            handler.sendEmptyMessageDelayed(1002, 1000);
        } else if (!"{\"showapi_res_code\":0,\"showapi_res_error\":\"\",\"showapi_res_body\":{\"remark\":\"找不到此地名!\",\"ret_code\":-1}}".equals(content)) {

            showDatas();

        } else {

            /**
             * 从sharedpreference中获取已订阅的城市并移除要删除的城市
             */
            SharedPreferences city = MyApp.getInstance().getSharedPreferences("city", Context.MODE_PRIVATE);
            LinkedHashSet<String> defaultSet = new LinkedHashSet<>();
            defaultSet.add("北京");
            Set<String> nameSet = city.getStringSet("name", defaultSet);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(nameSet);
            Collections.sort(arrayList);
            arrayList.remove(city);
            nameSet.clear();
            nameSet.addAll(arrayList);
            city.edit().putStringSet("name", nameSet).apply();

        }

        return view;
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        mainactivity = (onBackgroundChangedlistener) activity;
    }

    private void addListener() {
        //刷新按钮
        button_refresh_fragment01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog();
                loadWeatherInfoUtil = new LoadWeatherInfoUtil(city); //网络请求
                loadTime = 1;
                handler.sendEmptyMessageDelayed(1002, 1000);
            }
        });


        //弹出侧滑菜单
        imageView_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.mDrawerLayout.openDrawer(activity.navigationView);
            }
        });

        textView_yourcity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CityListFragment();
                ChangeFragmentHelper helper = new ChangeFragmentHelper();
                Bundle bundle = new Bundle();
                bundle.putString("type", "CityListFragment");
                helper.setBundle(bundle);
                helper.setTargetFragment(fragment);
                helper.setTargetFragmentTag("CityListFragment");
                activity.changeFragment(helper);
            }
        });

        imageView_middle_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage(alarmIssueContent);
                builder.setTitle("雾霾预警");
                builder.setPositiveButton("收到", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                // 显示对话框
                builder.create().show();
            }
        });

        //分享
        imageView_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //生活提示
                WeatherEntity.ShowapiResBodyEntity.F1Entity.IndexEntity index = todayInfo.getIndex();
                String telling = "---生活小提示---\n美肤" + index.getBeauty().getDesc() + ";\n天气：" + index.getCold().getDesc();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, telling);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1002:
                    //从本地读取
                    content = ReadWriteFileUtil.readFileData(city + ".txt");

                    if (loadTime > 10) {
                        closeProgressDialog();
                        Toast.makeText(MyApp.getInstance().getApplicationContext(), "更新网络数据失败", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (!"".equals(content) && !"{\"showapi_res_code\":0,\"showapi_res_error\":\"\",\"showapi_res_body\":{\"remark\":\"找不到此地名!\",\"ret_code\":-1}}".equals(content)) {
                        showDatas();
                        closeProgressDialog();
                        return;
                    }
                    handler.sendEmptyMessageDelayed(1002, 1000);
                    loadTime++;
                    break;
            }
        }
    };

    /**
     * 初始化控件
     */
    public void initViews() {

        //刷新按钮
        button_refresh_fragment01 = (Button) view.findViewById(R.id.button_refresh_fragment01);
        //分享
        imageView_share = (ImageView) view.findViewById(R.id.imageView_share);

        //弹出侧滑菜单
        imageView_settings = (ImageView) view.findViewById(R.id.imageView_settings);
        //城市名
        textView_yourcity = (TextView) view.findViewById(R.id.textView_yourcity);
        //雾霾
        button_alarm = (Button) view.findViewById(R.id.button_alarm);
        //紫外线
        button_ziwaixian = (Button) view.findViewById(R.id.button_ziwaixian);
        //时间
        textView_date = (TextView) view.findViewById(R.id.textView_date);
        //大图片
        imageView_middle_photo = (ImageView) view.findViewById(R.id.imageView_middle_photo);

        //此刻的天气
        textView_today_weather = (TextView) view.findViewById(R.id.textView_today_weather);
        textView_today_temperature = (TextView) view.findViewById(R.id.textView_today_temperature);

        //给温度显示添加动画
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.anim1);
        textView_today_temperature.setAnimation(animation);

        //风级
        textView_middle_wind = (TextView) view.findViewById(R.id.textView_middle_wind);
        //压强
        textView_middle_press = (TextView) view.findViewById(R.id.textView_middle_press);
        //降水
        textView_jiangshui = (TextView) view.findViewById(R.id.textView_jiangshui);


        //底部的天气信息
        textView_buttom_today_weather = (TextView) view.findViewById(R.id.textView_buttom_today_weather);
        textView_buttom_today_temperature = (TextView) view.findViewById(R.id.textView_buttom_today_temperature);
        imageView_buttom_today_weather = (ImageView) view.findViewById(R.id.imageView_buttom_today_weather);

        textView_buttom_tomorrow_weather = (TextView) view.findViewById(R.id.textView_buttom_tomorrow_weather);
        textView_buttom_tomorrow_temperature = (TextView) view.findViewById(R.id.textView_buttom_tomorrow_temperature);
        imageView_buttom_tomorrow_weather = (ImageView) view.findViewById(R.id.imageView_buttom_tomorrow_weather);

    }


    /**
     * 初始化控件实例
     */
    private void showDatas() {

        WeatherEntity weatherEntity = new Gson().fromJson(content, WeatherEntity.class);

        //今天的天气信息
        todayInfo = weatherEntity.getShowapi_res_body().getF1();

        //雾霾
        List<WeatherEntity.ShowapiResBodyEntity.F1Entity.AlarmListEntity> alarmList = todayInfo.getAlarmList();
        if (alarmList != null && alarmList.size() > 0) {
            button_alarm.setText(alarmList.get(0).getSignalType());

            //雾霾预警（点击大图片弹出的对话框内容）
            String alarmInfo = todayInfo.getAlarmList().get(0).getIssueContent();
            alarmIssueContent = alarmInfo == "" ? "注意天气变化，预防感冒." : alarmInfo;
        }
        button_ziwaixian.setText("紫外线: " + todayInfo.getZiwaixian());
        textView_date.setText(getFormatedDateTime("yyyy/MM/dd HH:mm:ss", Long.valueOf(System.currentTimeMillis())) + "发布");
        textView_middle_press.setText(todayInfo.getAir_press());
        textView_jiangshui.setText("降水: " + todayInfo.getJiangshui());

        //今日的压强
        String s3 = todayInfo.getAir_press();
        if ("暂无实况".equals(s3)) {
            textView_middle_press.setText(todayInfo.getAir_press());
        }

        textView_jiangshui.setText("降水概率：" + todayInfo.getJiangshui());

        //当前的天气状况
        WeatherEntity.ShowapiResBodyEntity.NowEntity nowEntity = weatherEntity.getShowapi_res_body().getNow();

        textView_today_weather.setText(nowEntity.getWeather());

        //根据当前天气情况设置标志值，并回传给MainActivity
        //阴，多云，小雨，阵雨，雨夹雪，晴，雾，中雨
        String weather = nowEntity.getWeather();
        int id = 0;
        switch (weather) {
            case "阴":
                id = R.mipmap.yin_day;
                break;
            case "多云":
                id = R.mipmap.duoyun_day;
                break;
            case "小雨":
                id = R.mipmap.yu_gezhong;
                break;
            case "阵雨":
                id = R.mipmap.yu_gezhong;
                break;
            case "雨夹雪":
                id = R.mipmap.yujiaxue_day;
                break;
            case "晴":
                id = R.mipmap.qing_day;
                break;
            case "雾":
                id = R.mipmap.yin_day;
                break;
            case "中雨":
                id = R.mipmap.yu_gezhong;
                break;
            default:
                id = R.mipmap.yu_gezhong;
                break;
        }
        view.setBackgroundResource(id); //设置背景
        mainactivity.onBackgroundChanged(id);

        //当前气温
        String s = nowEntity.getTemperature();
        if (!"暂无实况".equals(s)) {
            textView_today_temperature.setText(nowEntity.getTemperature() + "℃");
        }

        //当前的风级
        String s2 = nowEntity.getWind_power();
        if (!"暂无实况".equals(s2)) {
            textView_middle_wind.setText(nowEntity.getWind_power());
        }

        //今明天的其他信息
        String weatherChange = "";
        if (todayInfo.getDay_weather().equals(todayInfo.getNight_weather())) {
            weatherChange = todayInfo.getNight_weather();
        } else {
            weatherChange = todayInfo.getDay_weather() + "转" + todayInfo.getNight_weather();
        }
        textView_buttom_today_weather.setText(weatherChange);
        textView_buttom_today_temperature.setText(todayInfo.getNight_air_temperature() + "~" + todayInfo.getDay_air_temperature() + "℃");

        //今天的天气图片
        String day_weather_pic = todayInfo.getDay_weather_pic();
        BitmapUtils bitmapUtils = new BitmapUtils(MyApp.getInstance());
        bitmapUtils.display(imageView_buttom_today_weather, day_weather_pic);

        //明天的全部信息
        WeatherEntity.ShowapiResBodyEntity.F2Entity tomorrowInfo = weatherEntity.getShowapi_res_body().getF2();

        String tomorrow_weatherChange = "";
        if (tomorrowInfo.getDay_weather().equals(tomorrowInfo.getNight_weather())) {
            tomorrow_weatherChange = tomorrowInfo.getNight_weather();
        } else {
            tomorrow_weatherChange = tomorrowInfo.getDay_weather() + "转" + tomorrowInfo.getNight_weather();
        }
        textView_buttom_tomorrow_weather.setText(tomorrow_weatherChange);
        textView_buttom_tomorrow_temperature.setText(tomorrowInfo.getNight_air_temperature() + "~" + tomorrowInfo.getDay_air_temperature() + "℃");

        //明天的天气
        String day_weather_pic2 = tomorrowInfo.getDay_weather_pic();
        BitmapUtils bitmapUtils2 = new BitmapUtils(MyApp.getInstance());
        bitmapUtils.display(imageView_buttom_tomorrow_weather, day_weather_pic2);
    }

    /*
     *  日期格式转换
     * @param pattern 格式
     * @param dateTime 毫秒字符串
     * @return
     */
    public static String getFormatedDateTime(String pattern, long dateTime) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat(pattern);
        return sDateFormat.format(new Date(dateTime + 0));
    }

    //显示进度条
    private void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(getActivity());
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

    public interface onBackgroundChangedlistener {
        public void onBackgroundChanged(int id);

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onDestroyView() {
        /**
         * 将当前的城市名加入到代表已订阅的SharedPreferences
         */
        SharedPreferences citys = MyApp.getInstance().getSharedPreferences("city", Context.MODE_PRIVATE);
        LinkedHashSet<String> defaultSet = new LinkedHashSet<>();
        defaultSet.add("北京");
        Set<String> nameSet = citys.getStringSet("name", defaultSet);
        nameSet.add(city);
        citys.edit().putStringSet("name", nameSet).apply();

        MyApp.getInstance().getSharedPreferences("lastCityName", Context.MODE_PRIVATE).edit().putString("lastCityName", city).commit();
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        city = MyApp.getInstance().getSharedPreferences("lastCityName", Context.MODE_PRIVATE).getString("lastCityName", city);
        MyApp.getInstance().getSharedPreferences("lastCityName", Context.MODE_PRIVATE).edit().putString("lastCityName", city).commit();

    }

}


//+++++++++++++++++++++++++++++++++++++++++++++++++++++++

