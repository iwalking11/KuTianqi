package com.gaopinwei.kutianqi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.gaopinwei.kutianqi.R;
import com.gaopinwei.kutianqi.base.MyApp;
import com.gaopinwei.kutianqi.fragment.NewsFragment;

public class NewsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    private android.support.v4.app.FragmentManager manager;
    private ImageView news_getD_img;
    private  DrawerLayout  drawer_layout;
    private NavigationView navigationView;
    private String  proviceName ;
    private String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        navigationView = (NavigationView) findViewById(R.id.nav_news_view);
        navigationView.setNavigationItemSelectedListener(NewsActivity.this);

        proviceName = getIntent().getStringExtra("proviceName"); //省
        cityName = getIntent().getStringExtra("cityName"); //市

        manager =  getSupportFragmentManager();
        //新建新闻fragmentnew
        NewsFragment newsFragment = new NewsFragment(proviceName);
        manager.beginTransaction().replace(R.id.news_container,newsFragment).commit();

        drawer_layout =  ((DrawerLayout) findViewById(R.id.drawer_layout));

        news_getD_img = ((ImageView) findViewById(R.id.news_getD_img));

        news_getD_img.setOnClickListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        manager = getSupportFragmentManager();
        int id = item.getItemId();

        if (id == R.id.nav_item01) {
            //跳转到首页界面
            finish();

        } else if (id == R.id.nav_item02) {
            //设置为身边头条（新闻）点击时加载新闻信息
            //创建fragment时就 传递城市信息
            //从activity交互时获取信息
            item.setChecked(true);

        } else if (id == R.id.nav_item03) {

            //通知首页加载更换城市
            MyApp.getInstance().getHandler().sendEmptyMessage(888);
            finish();

        } else if (id == R.id.nav_share) {

            //写日记功能
            Intent intent = new Intent(this, AddNotebookActivity.class);
            intent.putExtra("title","kong");
            intent.putExtra("content","kong");
            intent.putExtra("cityName",cityName);
            startActivity(intent);

        } else if (id == R.id.nav_send) {
//            //地图定位
//            startActivity(new Intent(this,LocationActivity.class));
            //扫一扫
            startActivity(new Intent(NewsActivity.this,CaptureActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        drawer_layout.openDrawer(navigationView);
    }

}
