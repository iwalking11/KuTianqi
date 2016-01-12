package com.gaopinwei.kutianqi.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.gaopinwei.kutianqi.R;

import java.util.LinkedList;
import java.util.List;

/**
 *  导航页面
 *
 */
public class GuideActivity extends AppCompatActivity {

    private ViewPager vpContainerId;

    private List<View> dataSouce;// 数据源

    private PagerAdapter adapter; //适配器

    private SharedPreferences preferences; //记录是否是第一次启动

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 根据参数偏好设置中的文件中保存的信息，加载相应的布局文件
        boolean isUsed = getUserInfo();// 读取文件，返回使用信息

        if (isUsed) {
            // 若不是第一次打开，开始获取城市名
           startActivity(new Intent(GuideActivity.this, MainActivity.class));
            finish();
        } else {
            // 若是第一次运行，显示欢迎界面
            setContentView(R.layout.activity_guide);

            // 获取界面控件
            vpContainerId = (ViewPager) findViewById(R.id.vpContainerId);

            // 关于ViewPager
            initViewPager();
        }
    }

    /**
     * 关于ViewPager相应的操作
     */
    private void initViewPager() {

        // 数据源
        dataSouce = new LinkedList<View>();
        int[] imgIds = { R.mipmap.img_bg1, R.mipmap.img_bg2 ,R.mipmap.img_bg3,R.mipmap.img_bg4};
        for (int imgId : imgIds) {
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(imgId);
            dataSouce.add(imageView);
        }

        // 将第四张符合图片（布局填充器生成一个View）添加到数据源中
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.guide_last, null);

        Button btnEnterSysId = (Button) view.findViewById(R.id.btnEnterSysId);
        btnEnterSysId.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //点击进入
                startActivity(new Intent(GuideActivity.this, RequestByCityActivity.class));
                finish();
            }
        });
        dataSouce.add(view);

        // 适配器
        adapter = new MyPagerAdapter();

        // 绑定适配器
        vpContainerId.setAdapter(adapter);
    }

    /**
     * PagerAdapter的子类
     */
    private final class MyPagerAdapter extends PagerAdapter {

        /*
         * (non-Javadoc)
         *
         * @see android.support.v4.view.PagerAdapter#getCount()
         */
        @Override
        public int getCount() {
            return dataSouce.size();
        }

        /*
         * (non-Javadoc)
         *
         * @see
         * android.support.v4.view.PagerAdapter#isViewFromObject(android.view
         * .View, java.lang.Object)
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = dataSouce.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(dataSouce.get(position));
        }

    }

    /**
     * 读取文件，返回使用信息
     *
     * @return
     */
    private boolean getUserInfo() {
        preferences = getSharedPreferences("tea", Context.MODE_PRIVATE);
        return preferences.getBoolean("isUsered", false);
    }

}
