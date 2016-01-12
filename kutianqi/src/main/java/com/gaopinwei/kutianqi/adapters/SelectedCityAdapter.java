package com.gaopinwei.kutianqi.adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gaopinwei.kutianqi.R;
import com.gaopinwei.kutianqi.base.MyApp;
import com.gaopinwei.kutianqi.request.entitys.WeatherEntity;
import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2015/11/11.
 */
public class SelectedCityAdapter extends BaseAdapter {

    private Context context;
    private List<String> tempList;
    private List<String> imageList;
    private List<String> weatherEntityList;
    private boolean isInEdit = false;//小红点是否正在工作

    public SelectedCityAdapter(Context context, List<String> imageList, List<String> weatherEntityList, List<String> tempList) {
        this.context = context;
        this.imageList = imageList;
        this.weatherEntityList = weatherEntityList;
        this.tempList = tempList;
    }

    @Override
    public int getCount() {
        return weatherEntityList.size();
    }

    @Override
    public Object getItem(int position) {
        return weatherEntityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.city_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.delectCity = (ImageView) convertView.findViewById(R.id.small_edit_cicy);
            viewHolder.delectCity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView imageView = (ImageView) v;
                    if (isInEdit) {
                        imageView.setImageResource(R.mipmap.city_delete_normal);
                        viewHolder.delect.setVisibility(View.GONE);
                        isInEdit=false;
                    } else {
                        imageView.setImageResource(R.mipmap.city_delete_rotate);
                        viewHolder.delect.setVisibility(View.VISIBLE);
                        isInEdit=true;
                    }
                }
            });

            viewHolder.delect = (ImageView) convertView.findViewById(R.id.delete);
            viewHolder.delect.setOnClickListener(new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.HONEYCOMB)
                @Override
                public void onClick(View v) {

                    weatherEntityList.remove(position);
                    tempList.remove(position);
                    imageList.remove(position);
//                    viewHolder.delectCity.setImageResource(R.mipmap.city_delete_normal);
//                    viewHolder.delectCity.setVisibility(View.GONE);
//                    viewHolder.delect.setVisibility(View.GONE);

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
                    arrayList.remove(position);
                    nameSet.clear();
                    nameSet.addAll(arrayList);
                    city.edit().putStringSet("name", nameSet).apply();

                    notifyDataSetChanged();//通知适配器数据源已经改变


                }
            });
            viewHolder.city = (TextView) convertView.findViewById(R.id.tv_city);
            viewHolder.temp = (TextView) convertView.findViewById(R.id.tv_temp);
            viewHolder.temp.setClickable(true);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.city.setText(weatherEntityList.get(position));

        if (tempList.size()>position){//如果遇到内蒙古等一些特殊情况

            viewHolder.temp.setText(tempList.get(position));

            BitmapUtils bitmapUtils = new BitmapUtils(MyApp.getInstance().getApplicationContext());
            bitmapUtils.display(viewHolder.imageView, imageList.get(position));
        }

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;//天气图片
        ImageView delectCity;//左边小圆点
        ImageView delect;//右边确认删除
        TextView city;
        TextView temp;

    }
}
