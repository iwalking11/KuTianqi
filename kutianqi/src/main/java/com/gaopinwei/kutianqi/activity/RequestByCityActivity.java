package com.gaopinwei.kutianqi.activity;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gaopinwei.kutianqi.R;
import com.gaopinwei.kutianqi.base.MyApp;
import com.gaopinwei.kutianqi.request.db.CityDB;
import com.gaopinwei.kutianqi.request.entitys.City;
import com.gaopinwei.kutianqi.request.entitys.Province;
import com.gaopinwei.kutianqi.inter.CitysHttpCallbackListener;
import com.gaopinwei.kutianqi.request.utils.HttpUtil;
import com.gaopinwei.kutianqi.request.utils.LoadWeatherInfoUtil;
import com.gaopinwei.kutianqi.request.utils.RequestFromServer;
import com.gaopinwei.kutianqi.request.utils.Utility;
import com.gaopinwei.kutianqi.request.utils.ReadWriteFileUtil;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 从导航页跳过来,获得城市名,请求天气数据
 *
 */
public class RequestByCityActivity extends AppCompatActivity{

    public static final int LEVEL_PROVINCE = 0; //当前所处的层次
    public static final int LEVEL_CITY = 1;
    private ProgressDialog progressDialog;
    private TextView titleText;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private CityDB cityDB;  //城市信息数据库帮助类
    private List<String> dataList = new ArrayList<>();  //数据源
    private List<Province> provinceList;   //省的集合
    private List<City> cityList;           //市的集合
    private Province selectedProvince;
    private City selectedCity;
    private int currentLevel;  //当前层次
    private String content;  //接收获取的天气信息
    private  String cityName; //当前城市的名字


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_area);         //加载布局文件

        //GPS定位
        Button button_gps = (Button) findViewById(R.id.button_gps);
        button_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RequestByCityActivity.this,GPSActivity.class));
            }
        });

        titleText = (TextView) findViewById(R.id.title_text);
        listView = (ListView) findViewById(R.id.list_view);

        //绑定适配器
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        //实例化数据库实例
        cityDB = CityDB.getInstance(this);

        //给ListVie添加监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentLevel == LEVEL_PROVINCE) {
                    selectedProvince = provinceList.get(position);

                    //搜索并显示城市的信息
                    queryCities();
                    return;
                }

                //获取城市名
                cityName = dataList.get(position).toString();

                SharedPreferences city = MyApp.getInstance().getSharedPreferences("city", MODE_PRIVATE);
                LinkedHashSet<String> defaultSet = new LinkedHashSet<>();
                defaultSet.add("北京");
                Set<String> nameSet = new LinkedHashSet<>();

                //判断是否是第一次运行程序选择城市
                SharedPreferences isUsed = getSharedPreferences("tea", Context.MODE_PRIVATE);
                boolean isUsered = isUsed.getBoolean("isUsered", false);
                // 向参数偏好文件中写入数据，表示已经使用过，第二次启动app的时候，就会跳过欢迎界面，直接进入主界面
                isUsed.edit().putBoolean("isUsered", true).commit();

                if (isUsered) {//如果不是,应该先获取以前已经订阅过的城市
                    nameSet = city.getStringSet("name", defaultSet);
                }

                nameSet.add(cityName);
                SharedPreferences.Editor edit = city.edit();
                edit.putStringSet("name", nameSet);

                //初始化省份信息
                edit.putString("北京", "北京");
                edit.putString("上海", "上海");
                edit.putString("天津", "天津");
                edit.putString("重庆", "重庆");
                edit.putString("沈阳", "辽宁");
                edit.putString("大连", "辽宁");
                edit.putString("长春", "吉林");
                edit.putString("郑州", "河南");
                edit.putString("广州", "广东");
                edit.putString("哈尔滨", "黑龙江");
                edit.putString("武汉", "湖北");
                edit.putString("长沙", "湖南");
                edit.putString("深圳", "广东");
                edit.putString("南京", "江苏");
                edit.putString("合肥", "安徽");
                edit.putString("杭州", "浙江");
                edit.putString("石家庄", "河北");
                edit.putString("兰州", "甘肃");
                edit.putString("昆明", "云南");
                edit.putString("成都", "四川");
                edit.putString("西安", "陕西");
                edit.putString("西宁", "青海");
                edit.putString("贵阳", "贵州");
                edit.putString("呼和浩特", "内蒙古");
                edit.putString("银川", "宁夏");
                edit.putString("乌鲁木齐", "新疆");
                edit.putString("香港", "香港");
                edit.putString("澳门", "澳门").commit();

                //存储所有点击过的城市组成的set集合,已经城市对应的省份
                edit.putStringSet("name", nameSet).putString(cityName, selectedProvince.getProvinceName()).commit();

                SharedPreferences sp = MyApp.getInstance().getSharedPreferences("lastCityName", MODE_PRIVATE);
                sp.edit().putString("lastCityName", cityName).commit();

                //跳转到主界面
                Intent intent = new Intent(RequestByCityActivity.this, MainActivity.class);
                RequestByCityActivity.this.startActivity(intent);
                RequestByCityActivity.this.finish();
            }
        });

        //搜索并显示省份信息
        queryProvinces();

    }

    /*
     * 搜索并显示省份信息
     *
     */
    private void queryProvinces() {

        //查看数据库是否存有数据
        provinceList = cityDB.loadProvinces();

        //如果数据库中有，就直接从中获取
        if (provinceList.size() > 0) {
            dataList.clear();
            for (Province province : provinceList) {
                dataList.add(province.getProvinceName());
            }
            //notifyDataSetChanged()可以在修改适配器绑定的数组后，
            // 不用重新刷新Activity，通知Activity更新ListView。
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            titleText.setText("中国");
            currentLevel = LEVEL_PROVINCE;
        }
        //如果数据库没有数据，就直接下载
        else {
            //注意大小写"province"
            queryFromServer(null, "province");
        }
    }

    /*
     *  搜索并显示城市的信息
     *
     */
    private void queryCities() {
        cityList = cityDB.loadCities(selectedProvince.getId());
        if (cityList.size() > 0) {
            dataList.clear();
            for (City city : cityList) {
                dataList.add(city.getCityName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            titleText.setText(selectedProvince.getProvinceName());
            currentLevel = LEVEL_CITY;
        } else {
            //注意是getProvinceCode()
            queryFromServer(selectedProvince.getProvinceCode(), "city");
        }
    }

    /*
     * 第一次运行，从服务器下载数据
     *
     * @param code
     * @param type
     */
    private void queryFromServer(final String code, final String type) {
        String address;
        if (!TextUtils.isEmpty(code)) {
            address = "http://www.weather.com.cn/data/list3/city" + code + ".xml";
        } else {
            address = "http://www.weather.com.cn/data/list3/city.xml";
        }
        showProgressDialog();

        //通过httpUtils下载数据
        HttpUtil.sendHttpRequest(address, new CitysHttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                boolean result = false;
                if ("province".equals(type)) {
                    //调用工具类，解析数据
                    result = Utility.handleProvincesResponse(cityDB, response);
                } else if ("city".equals(type)) {
                    result = Utility.handleCitiesResponse(cityDB, response, selectedProvince.getId());
                }
                if (result) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            closeProgressDialog();
                            if ("province".equals(type)) {
                                queryProvinces();
                            } else if ("city".equals(type)) {
                                queryCities();
                            }
                        }
                    });
                }
            }

            @Override
            public void onError(Exception e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        closeProgressDialog();
                        Toast.makeText(RequestByCityActivity.this, "加载失败,请检查网络连通性!!!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    //显示进度条
    private void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
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

    //返回按钮
    @Override
    public void onBackPressed() {

        if (currentLevel == LEVEL_CITY) {
            queryProvinces();
        } else {
            finish();
        }
    }

}
