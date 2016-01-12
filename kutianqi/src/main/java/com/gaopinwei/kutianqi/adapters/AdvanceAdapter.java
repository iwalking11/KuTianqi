package com.gaopinwei.kutianqi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gaopinwei.kutianqi.R;
import com.gaopinwei.kutianqi.request.entitys.WeatherEntity;
import com.lidroid.xutils.BitmapUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/11/13.
 */
public class AdvanceAdapter extends RecyclerView.Adapter<AdvanceAdapter.MyViewHolder> {


    private WeatherEntity weatherEntity;
    private Context context;
    private MyOnItemClickListener myOnItemClickListener;


    public void setMyOnItemClickListener(MyOnItemClickListener myOnItemClickListener) {
        this.myOnItemClickListener = myOnItemClickListener;
    }

    public AdvanceAdapter(WeatherEntity weatherEntity, Context context) {
        this.weatherEntity = weatherEntity;
        this.context = context;
    }

    /**
     * 当 view 被复用的时候调用,将传回来的 holder 传递给了 onbindview, 做到了复用的功能,这个时候 onCreateViewHolder不会再执行
     *
     * @param holder
     */
    @Override
    public void onViewRecycled(MyViewHolder holder) {
//        Log.e("recycler", "onViewRecycled");
        super.onViewRecycled(holder);
    }

    /**
     * 创建 viewhoder, 返回值是我们自己的内部类MyViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.everyday_weather_item, null);
        return new MyViewHolder(itemView);
    }

    /**
     * 绑定视图,将内容显示出来的方法
     *
     * @param holder   onCreateViewHolder 返回的对象,传递到这里来 显示内容
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.buttomTodayWeatherTextView = (TextView) holder.itemView.findViewById(R.id.textView_buttom_today_weather);
        holder.windDesTextView = (TextView) holder.itemView.findViewById(R.id.text_wind_des);
        holder.windPowerTextView = (TextView) holder.itemView.findViewById(R.id.text_wind_power);
        holder.temperatureTextView = (TextView) holder.itemView.findViewById(R.id.textView_day_temperature);
        holder.nigntTemperatureTextView = (TextView) holder.itemView.findViewById(R.id.textView_nignt_temperature);
        holder.buttomTodayWeatherImageView = (ImageView) holder.itemView.findViewById(R.id.imageView_buttom_today_weather);
        holder.dayTextView = (TextView) holder.itemView.findViewById(R.id.textview_day);
        holder.nightTextView = (TextView) holder.itemView.findViewById(R.id.textView_night);
        holder.imageView2ImageView = (ImageView) holder.itemView.findViewById(R.id.imageView2);
        holder.dayWeather = (TextView) holder.itemView.findViewById(R.id.textview_day_weather);
        holder.nightWeather = (TextView) holder.itemView.findViewById(R.id.textView_night_weather);
        holder.day = (TextView) holder.itemView.findViewById(R.id.day);
        holder.weekDay = (TextView) holder.itemView.findViewById(R.id.week_day);

        String day = null;
        int weekday = 0;
        String signalType = null;
        String day_air_temperature = null;
        String night_air_temperature = null;
        String day_weather_pic = null;
        String night_weather_pic = null;
        String day_weather = null;
        String night_weather = null;
        String day_wind_direction = null;
        String day_wind_power = null;

        if (weatherEntity != null) {

            switch (position) {
                case 0:
                    WeatherEntity.ShowapiResBodyEntity.F1Entity f1 = weatherEntity.getShowapi_res_body().getF1();
                    day = f1.getDay();
                    weekday = f1.getWeekday();
                    List<WeatherEntity.ShowapiResBodyEntity.F1Entity.AlarmListEntity> alarmList = f1.getAlarmList();
//                if (alarmList != null && alarmList.size() != 0) {
//                    signalType = alarmList.get(0).getSignalType();
//                }
                    WeatherEntity.ShowapiResBodyEntity.F1Entity.IndexEntity index1 = f1.getIndex();
                    if (index1 != null) {
                        WeatherEntity.ShowapiResBodyEntity.F1Entity.IndexEntity.ComfortEntity comfort1 = index1.getComfort();
                        if (comfort1 != null) {
                            signalType = comfort1.getTitle();
                        }
                    }
                    day_air_temperature = f1.getDay_air_temperature();
                    night_air_temperature = f1.getNight_air_temperature();
                    day_weather_pic = f1.getDay_weather_pic();
                    night_weather_pic = f1.getNight_weather_pic();
                    day_weather = f1.getDay_weather();
                    night_weather = f1.getNight_weather();
                    day_wind_direction = f1.getDay_wind_direction();
                    day_wind_power = f1.getDay_wind_power();

                    break;
                case 1:
                    WeatherEntity.ShowapiResBodyEntity.F2Entity f2 = weatherEntity.getShowapi_res_body().getF2();
                    day = f2.getDay();
                    weekday = f2.getWeekday();
                    WeatherEntity.ShowapiResBodyEntity.F2Entity.IndexEntity index2 = f2.getIndex();
                    if (index2 != null) {
                        WeatherEntity.ShowapiResBodyEntity.F2Entity.IndexEntity.ComfortEntity comfort2 = index2.getComfort();
                        if (comfort2 != null) {
                            signalType = comfort2.getTitle();
                        }
                    }
                    day_air_temperature = f2.getDay_air_temperature();
                    night_air_temperature = f2.getNight_air_temperature();
                    day_weather_pic = f2.getDay_weather_pic();
                    night_weather_pic = f2.getNight_weather_pic();
                    day_weather = f2.getDay_weather();
                    night_weather = f2.getNight_weather();
                    day_wind_direction = f2.getDay_wind_direction();
                    day_wind_power = f2.getDay_wind_power();
                    break;
                case 2:
                    WeatherEntity.ShowapiResBodyEntity.F3Entity f3 = weatherEntity.getShowapi_res_body().getF3();
                    day = f3.getDay();
                    weekday = f3.getWeekday();
                    WeatherEntity.ShowapiResBodyEntity.F3Entity.IndexEntity index3 = f3.getIndex();
                    if (index3 != null) {
                        WeatherEntity.ShowapiResBodyEntity.F3Entity.IndexEntity.ComfortEntity comfort3 = index3.getComfort();
                        if (comfort3 != null) {
                            signalType = comfort3.getTitle();
                        }
                    }
                    day_air_temperature = f3.getDay_air_temperature();
                    night_air_temperature = f3.getNight_air_temperature();
                    day_weather_pic = f3.getDay_weather_pic();
                    night_weather_pic = f3.getNight_weather_pic();
                    day_weather = f3.getDay_weather();
                    night_weather = f3.getNight_weather();
                    day_wind_direction = f3.getDay_wind_direction();
                    day_wind_power = f3.getDay_wind_power();
                    break;
                case 3:
                    WeatherEntity.ShowapiResBodyEntity.F4Entity f4 = weatherEntity.getShowapi_res_body().getF4();
                    day = f4.getDay();
                    weekday = f4.getWeekday();
                    WeatherEntity.ShowapiResBodyEntity.F4Entity.IndexEntity index4 = f4.getIndex();
                    if (index4 != null) {
                        WeatherEntity.ShowapiResBodyEntity.F4Entity.IndexEntity.ComfortEntity comfort4 = index4.getComfort();
                        if (comfort4 != null) {
                            signalType = comfort4.getTitle();
                        }
                    }
                    day_air_temperature = f4.getDay_air_temperature();
                    night_air_temperature = f4.getNight_air_temperature();
                    day_weather_pic = f4.getDay_weather_pic();
                    night_weather_pic = f4.getNight_weather_pic();
                    day_weather = f4.getDay_weather();
                    night_weather = f4.getNight_weather();
                    day_wind_direction = f4.getDay_wind_direction();
                    day_wind_power = f4.getDay_wind_power();
                    break;
                case 4:
                    WeatherEntity.ShowapiResBodyEntity.F5Entity f5 = weatherEntity.getShowapi_res_body().getF5();
                    day = f5.getDay();
                    weekday = f5.getWeekday();
                    WeatherEntity.ShowapiResBodyEntity.F5Entity.IndexEntity index5 = f5.getIndex();
                    if (index5 != null) {
                        WeatherEntity.ShowapiResBodyEntity.F5Entity.IndexEntity.ComfortEntity comfort5 = index5.getComfort();
                        if (comfort5 != null) {
                            signalType = comfort5.getTitle();
                        }
                    }
                    day_air_temperature = f5.getDay_air_temperature();
                    night_air_temperature = f5.getNight_air_temperature();
                    day_weather_pic = f5.getDay_weather_pic();
                    night_weather_pic = f5.getNight_weather_pic();
                    day_weather = f5.getDay_weather();
                    night_weather = f5.getNight_weather();
                    day_wind_direction = f5.getDay_wind_direction();
                    day_wind_power = f5.getDay_wind_power();
                    break;
                case 5:
                    WeatherEntity.ShowapiResBodyEntity.F6Entity f6 = weatherEntity.getShowapi_res_body().getF6();
                    day = f6.getDay();
                    weekday = f6.getWeekday();
                    WeatherEntity.ShowapiResBodyEntity.F6Entity.IndexEntity index6 = f6.getIndex();
                    if (index6 != null) {
                        WeatherEntity.ShowapiResBodyEntity.F6Entity.IndexEntity.ComfortEntity comfort6 = index6.getComfort();
                        if (comfort6 != null) {
                            signalType = comfort6.getTitle();
                        }
                    }
                    day_air_temperature = f6.getDay_air_temperature();
                    night_air_temperature = f6.getNight_air_temperature();
                    day_weather_pic = f6.getDay_weather_pic();
                    night_weather_pic = f6.getNight_weather_pic();
                    day_weather = f6.getDay_weather();
                    night_weather = f6.getNight_weather();
                    day_wind_direction = f6.getDay_wind_direction();
                    day_wind_power = f6.getDay_wind_power();
                    break;
                case 6:
                    WeatherEntity.ShowapiResBodyEntity.F7Entity f7 = weatherEntity.getShowapi_res_body().getF7();
                    day = f7.getDay();
                    weekday = f7.getWeekday();
                    WeatherEntity.ShowapiResBodyEntity.F7Entity.IndexEntity index7 = f7.getIndex();
                    if (index7 != null) {
                        WeatherEntity.ShowapiResBodyEntity.F7Entity.IndexEntity.ComfortEntity comfort7 = index7.getComfort();
                        if (comfort7 != null) {
                            signalType = comfort7.getTitle();
                        }
                    }
                    day_air_temperature = f7.getDay_air_temperature();
                    night_air_temperature = f7.getNight_air_temperature();
                    day_weather_pic = f7.getDay_weather_pic();
                    night_weather_pic = f7.getNight_weather_pic();
                    day_weather = f7.getDay_weather();
                    night_weather = f7.getNight_weather();
                    day_wind_direction = f7.getDay_wind_direction();
                    day_wind_power = f7.getDay_wind_power();
                    break;
            }
        }


        if (signalType != null) {
            holder.buttomTodayWeatherTextView.setText(signalType);
        }

        holder.nightWeather.setText(night_weather);
        holder.dayWeather.setText(day_weather);
        holder.temperatureTextView.setText(day_air_temperature + "℃");
        holder.nigntTemperatureTextView.setText(night_air_temperature + "℃");
        holder.windDesTextView.setText(day_wind_direction);
        holder.windPowerTextView.setText(day_wind_power);


        StringBuffer stringBuffer = null;
        if (day != null) {
            String newDay = day.substring(day.indexOf("5") + 1);
            stringBuffer = new StringBuffer(newDay);
            stringBuffer.insert(2, "月").append("日");
        } else {
            stringBuffer = new StringBuffer("1月1日");
        }
        holder.day.setText(stringBuffer.toString());

        String newWeekDay = "一";
        switch (weekday) {
            case 1:
                newWeekDay = "一";
                break;
            case 2:
                newWeekDay = "二";
                break;
            case 3:
                newWeekDay = "三";
                break;
            case 4:
                newWeekDay = "四";
                break;
            case 5:
                newWeekDay = "五";
                break;
            case 6:
                newWeekDay = "六";
                break;
            case 7:
                newWeekDay = "日";

                break;
        }
        holder.weekDay.setText("星期" + newWeekDay);

        BitmapUtils bitmapUtils = new BitmapUtils(context);
        bitmapUtils.display(holder.buttomTodayWeatherImageView, day_weather_pic);
        bitmapUtils.display(holder.imageView2ImageView, night_weather_pic);
    }

    /**
     * 返回数据源的长度
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return 7;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /**
         * @param itemView 每一条 item 的 view
         */
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);//给 每一条 item设置点击事件
        }

        TextView buttomTodayWeatherTextView;
        TextView windDesTextView;
        TextView windPowerTextView;
        TextView temperatureTextView;
        TextView nigntTemperatureTextView;
        ImageView buttomTodayWeatherImageView;
        TextView dayTextView;
        TextView dayWeather;
        TextView nightWeather;
        TextView day;
        TextView weekDay;
        TextView nightTextView;
        ImageView imageView2ImageView;

        @Override
        public void onClick(View v) {//每一条 item 点击事件的具体执行内容
            if (myOnItemClickListener != null) {
                myOnItemClickListener.myOnItemClick(v, getLayoutPosition());
            }
        }
    }

    public interface MyOnItemClickListener {//自己声明的点击事件对象

        void myOnItemClick(View view, int postion);//点击事件具体执行的方法
    }
}