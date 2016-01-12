package com.gaopinwei.kutianqi.fragment;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.gaopinwei.kutianqi.R;
import com.gaopinwei.kutianqi.activity.RequestByCityActivity;
import com.gaopinwei.kutianqi.adapters.CityListAdapter;
import com.gaopinwei.kutianqi.base.BaseFragment;
import com.gaopinwei.kutianqi.base.MyApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 * <p/>
 * 城市搜索界面
 */
public class SearchFragment extends BaseFragment implements View.OnClickListener {

    private List<String> cityList;

    private RecyclerView recyclerView;
    private SharedPreferences.Editor edit;
    private SearchView search;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);


        cityList = new ArrayList<>();

        initView(view);
        return view;
    }

    private void initView(View view) {

        //回退按钮
        ImageView back = (ImageView) view.findViewById(R.id.back);
        back.setOnClickListener(this);

        //搜索
        search = (SearchView) view.findViewById(R.id.search);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (cityList.contains(query)) {

                    goToFragment01(query);

                } else {
                    final Snackbar snackbar = Snackbar.make(search, "您查找的城市不在列表中!", Snackbar.LENGTH_INDEFINITE);
                    snackbar.setAction("确定", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            snackbar.dismiss();
                        }
                    }).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
//        search.setOnSearchClickListener(this);

        cityList.add("北京");
        cityList.add("上海");
        cityList.add("天津");
        cityList.add("重庆");
        cityList.add("沈阳");
        cityList.add("大连");
        cityList.add("长春");
        cityList.add("郑州");
        cityList.add("广州");
        cityList.add("哈尔滨");
        cityList.add("武汉");
        cityList.add("长沙");
        cityList.add("深圳");
        cityList.add("南京");
        cityList.add("合肥");
        cityList.add("杭州");
        cityList.add("石家庄");
        cityList.add("兰州");
        cityList.add("昆明");
        cityList.add("成都");
        cityList.add("西安");
        cityList.add("西宁");
        cityList.add("贵阳");
        cityList.add("呼和浩特");
        cityList.add("银川");
        cityList.add("乌鲁木齐");
        cityList.add("香港");
        cityList.add("澳门");
        cityList.add("更多...");

        recyclerView = ((RecyclerView) view.findViewById(R.id.recycler_view));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        CityListAdapter adapter = new CityListAdapter(getContext(), cityList);
        recyclerView.setAdapter(adapter);

        adapter.setMyOnItemClickListener(new CityListAdapter.MyOnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void myOnItemClick(View view, int postion) {

                TextView textView = (TextView) view.findViewById(R.id.tv_city);
                String name = textView.getText().toString();
                if ("更多...".equals(name)) {
                    startActivity(new Intent(getContext(), RequestByCityActivity.class));

                } else {
                    goToFragment01(name);

                }

            }
        });

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void goToFragment01(String name) {
        SharedPreferences city = activity.getSharedPreferences("city", Context.MODE_APPEND);
        LinkedHashSet<String> defaultSet = new LinkedHashSet<>();
        defaultSet.add("北京");
        Set<String> nameSet = city.getStringSet("name", defaultSet);
        edit = city.edit();
        nameSet.add(name);
        edit.putStringSet("name", nameSet).commit();


        //使sharedprefrences中存储的当前点击的城市发生改变
        MyApp.getInstance().getSharedPreferences("lastCityName", Context.MODE_PRIVATE).edit().putString("lastCityName", name).commit();

        //发送消息,让MainActivity接收已经改变的城市名
        Message message = activity.handler.obtainMessage();
        message.what = 999;
        message.obj = name;
        activity.handler.sendMessage(message);

        Fragment01 fragment = new Fragment01(name);
        ChangeFragmentHelper helper = new ChangeFragmentHelper();

        helper.setTargetFragment(fragment);

        helper.setIsClearStackBack(true);

        activity.changeFragment(helper);
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back://回到Fragment01
                CityListFragment fragment = new CityListFragment();
                ChangeFragmentHelper helper2 = new ChangeFragmentHelper();

                helper2.setTargetFragment(fragment);

                helper2.setIsClearStackBack(true);

                activity.changeFragment(helper2);

                break;

            case R.id.search:

                break;
        }
    }
}
