package com.gaopinwei.kutianqi.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gaopinwei.kutianqi.R;
import com.gaopinwei.kutianqi.base.MyApp;
import com.gaopinwei.kutianqi.fragment.ChangeFragmentHelper;
import com.gaopinwei.kutianqi.fragment.CityListFragment;
import com.gaopinwei.kutianqi.fragment.Fragment01;
import com.gaopinwei.kutianqi.fragment.Fragment02;
import com.gaopinwei.kutianqi.fragment.Fragment04;
import com.gaopinwei.kutianqi.fragment.HistoryFragment;

/**
 * 酷天气主页
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, RadioGroup.OnCheckedChangeListener, Fragment01.onBackgroundChangedlistener {

    private String cityName;
    private String proviceName;
    private FragmentManager manager;
    private View main_layout;
    private SharedPreferences sp;//存储当前要展示的城市信息
    private SharedPreferences sp2;//存储所有已订阅的城市已经对应的省份信息
    private RadioGroup mainTabBar;
    private boolean fromNewsActivity = false;//是否从NewsActivity界面跳转过来

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            ChangeFragmentHelper helper = null;
            Fragment fragment = null;

            switch (msg.what) {

                case 999://当其他页面已选择的城市发生改变的时候,在此处接收消息,改变城市名
                    cityName = ((String) msg.obj);
                    proviceName = sp2.getString(cityName, "北京");
                    break;

                case 888:

//                    接收从新闻界面传来的消息加载CitylistFragment
                     fragment = new CityListFragment();
                     helper = new ChangeFragmentHelper();
                    Bundle bundle = new Bundle();
                    bundle.putString("type", "CityListFragment");
                    helper.setBundle(bundle);
                    helper.setIsClearStackBack(false);
                    helper.setTargetFragment(fragment);
                    helper.setTargetFragmentTag("CityListFragment");
                    changeFragment(helper);

                    //同时使下方的图标也改变
//                    fromNewsActivity = true;

//                    mainTabBar.check(R.id.main_tab_bar_one);
                    break;

                case 777:
//                     fragment = new Fragment04(cityName);
//                    helper = new ChangeFragmentHelper();
//                    helper.setTargetFragment(fragment);
//                    helper.setIsClearStackBack(true);
//                    changeFragment(helper);

                    mainTabBar.check(R.id.main_tab_bar_four);

//                    mainTabBar.getChildAt(2).setSelected(false);
//                    mainTabBar.getChildAt(3).setSelected(true);
                    break;
            }
        }
    };

    //DrawerLayout控件
    public DrawerLayout mDrawerLayout;
    //侧滑部分
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置全局的handler对象
        MyApp.getInstance().setHandler(handler);

        //获取该展示的城市
        sp = MyApp.getInstance().getSharedPreferences("lastCityName", MODE_PRIVATE);
        cityName = sp.getString("lastCityName", "北京");
        // Log.e("xiazhenjie", "进入了主界面");
        // proviceName = getIntent().getStringExtra("proviceName");
        // Log.e("proviceName",proviceName);

        mainTabBar = (RadioGroup) findViewById(R.id.main_tab_bar);

        main_layout = findViewById(R.id.main_layout);

        mDrawerLayout = (DrawerLayout) this.findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        sp2 = MyApp.getInstance().getSharedPreferences("city", MODE_PRIVATE);
        proviceName = sp2.getString(cityName, "北京");

        manager = getSupportFragmentManager();
        initViews();  //初始化主界面

    }

    @Override
    protected void onDestroy() {
        sp.edit().putString("lastCityName", cityName).commit();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_item01) {
            item.setChecked(true); //回到首页

        } else if (id == R.id.nav_item02) {
            //设置为身边头条（新闻）点击时加载新闻信息
            Intent intent = new Intent(MainActivity.this, NewsActivity.class);
            intent.putExtra("proviceName", proviceName);
            intent.putExtra("cityName", cityName);

            startActivity(intent);

        } else if (id == R.id.nav_item03) {
            //选择其他城市
            Fragment fragment = new CityListFragment();
            ChangeFragmentHelper helper = new ChangeFragmentHelper();
            Bundle bundle = new Bundle();
            bundle.putString("type", "CityListFragment");
            helper.setBundle(bundle);
            helper.setTargetFragment(fragment);
            helper.setTargetFragmentTag("CityListFragment");
            changeFragment(helper);

        } else if (id == R.id.nav_share) {
            //写日记功能
            Intent intent = new Intent(this, AddNotebookActivity.class);
            intent.putExtra("title", "kong");
            intent.putExtra("content", "kong");
            intent.putExtra("cityName", cityName);
            startActivity(intent);

        } else if (id == R.id.nav_send) {
//            //地图定位
//            startActivity(new Intent(this,LocationActivity.class));
            //扫一扫
            startActivity(new Intent(MainActivity.this, CaptureActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * 初始化主界面
     */
    private void initViews() {

        mainTabBar.setOnCheckedChangeListener(this);
        //默认选中
        mainTabBar.check(R.id.main_tab_bar_one);
    }

    /**
     * 按钮viewpager的切换监听
     *
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (group.getId() == R.id.main_tab_bar) {
            changeFragment(checkedId);
        }
    }

    /**
     * 点击各个button的点击事件
     *
     * @param view
     */
    public void onclick(View view) {
        Fragment fragment = null;
        ChangeFragmentHelper helper = new ChangeFragmentHelper();
        switch (view.getId()) {
            case R.id.main_tab_bar_one:
                if (mainTabBar.getCheckedRadioButtonId() == R.id.main_tab_bar_one) {
                    return;
                }
                fragment = new Fragment01(cityName);
                break;
            case R.id.main_tab_bar_two:
                if (mainTabBar.getCheckedRadioButtonId() == R.id.main_tab_bar_two) {
                    return;
                }
                fragment = new Fragment02(cityName);
                break;
            case R.id.main_tab_bar_three:
                if (mainTabBar.getCheckedRadioButtonId() == R.id.main_tab_bar_three) {
                    return;
                }
                fragment = new HistoryFragment(this);
                Bundle bundle = new Bundle();
                bundle.putString("city", cityName);
                helper.setBundle(bundle);
                break;
            case R.id.main_tab_bar_four://今日备忘
                if (mainTabBar.getCheckedRadioButtonId() == R.id.main_tab_bar_four) {
                    return;
                }
                fragment = new Fragment04(cityName);
                break;
        }


        helper.setTargetFragment(fragment);

        if (fromNewsActivity) {

            fromNewsActivity=false;

        } else {

            //清空回退栈
            helper.setIsClearStackBack(true);
        }
        changeFragment(helper);
    }

    /**
     * 切换fragment
     *
     * @param checkedId
     */
    private void changeFragment(int checkedId) {
        Fragment fragment = null;
        ChangeFragmentHelper helper = new ChangeFragmentHelper();
        switch (checkedId) {
            case R.id.main_tab_bar_one:
                fragment = new Fragment01(cityName);
                break;
            case R.id.main_tab_bar_two:
                fragment = new Fragment02(cityName);
                break;
            case R.id.main_tab_bar_three:
                fragment = new HistoryFragment(this);
                Bundle bundle = new Bundle();
                bundle.putString("city", cityName);
                helper.setBundle(bundle);
                break;
            case R.id.main_tab_bar_four://今日备忘
                fragment = new Fragment04(cityName);
                break;
        }

        helper.setTargetFragment(fragment);

        if (fromNewsActivity) {

            fromNewsActivity=false;

        } else {

            //清空回退栈
            helper.setIsClearStackBack(true);
        }

        changeFragment(helper);
    }

    public void changeFragment(ChangeFragmentHelper helper) {

        //获取需要跳转的Fragment
        Fragment targetFragment = helper.getTargetFragment();

        //获取是否清空回退栈
        boolean clearStackBack = helper.isClearStackBack();

        //获取是否加入回退栈
        String targetFragmentTag = helper.getTargetFragmentTag();

        //获取Bundle
        Bundle bundle = helper.getBundle();
        //是否给Fragment传值
        if (bundle != null) {
            targetFragment.setArguments(bundle);
        }

        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = manager.beginTransaction();

        if (targetFragment != null) {
            fragmentTransaction.replace(R.id.container, targetFragment);
        }

        //是否添加到回退栈
        if (targetFragmentTag != null) {
            fragmentTransaction.addToBackStack(targetFragmentTag);
        }

        //是否清空回退栈
        if (clearStackBack) {
            manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

        fragmentTransaction.commitAllowingStateLoss();
    }


    @Override
    public void onBackgroundChanged(int id) {
        main_layout.setBackgroundResource(id);
    }

    private long exitTime = 0;

    /**
     * 捕捉返回事件按钮
     *
     * 因为此 Activity 继承 TabActivity 用 onKeyDown 无响应，所以改用 dispatchKeyEvent
     * 一般的 Activity 用 onKeyDown 就可以了
     */

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                this.exitApp();
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    /**
     * 退出程序
     */
    private void exitApp() {
        // 判断2次点击事件时间
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }
}
