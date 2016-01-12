package com.gaopinwei.kutianqi.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaopinwei.kutianqi.R;
import com.gaopinwei.kutianqi.adapters.AdvanceAdapter;
import com.gaopinwei.kutianqi.base.BaseFragment;
import com.gaopinwei.kutianqi.request.entitys.WeatherEntity;
import com.gaopinwei.kutianqi.request.utils.ReadWriteFileUtil;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.gson.Gson;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * 预告未来几天的天气
 */
public class Fragment02 extends BaseFragment {

    private String cityName;

    private String data;
    private List<String> dayAirTemperature;
    private List<String> nightAirTemperature;
    private List<String> time;


    private LineChart mChart;
    private WeatherEntity weatherEntity;
    private RecyclerView recyclerView;

    public Fragment02(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment002, container, false);

        data = ReadWriteFileUtil.readFileData(cityName + ".txt");

        nightAirTemperature = new ArrayList<>();
        dayAirTemperature = new ArrayList<>();
        time = new ArrayList<>();
        weatherEntity = new WeatherEntity();


        if (!"{\"showapi_res_code\":0,\"showapi_res_error\":\"\",\"showapi_res_body\":{\"remark\":\"找不到此地名!\",\"ret_code\":-1}}".equals(data)) {

            initData();

        }

        initView(view);
        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void initData() {

        weatherEntity = new Gson().fromJson(data, WeatherEntity.class);
        if (weatherEntity != null) {
//            try {
            WeatherEntity.ShowapiResBodyEntity.F1Entity f1 = weatherEntity.getShowapi_res_body().getF1();
            WeatherEntity.ShowapiResBodyEntity.F2Entity f2 = weatherEntity.getShowapi_res_body().getF2();
            WeatherEntity.ShowapiResBodyEntity.F3Entity f3 = weatherEntity.getShowapi_res_body().getF3();
            WeatherEntity.ShowapiResBodyEntity.F4Entity f4 = weatherEntity.getShowapi_res_body().getF4();
            WeatherEntity.ShowapiResBodyEntity.F5Entity f5 = weatherEntity.getShowapi_res_body().getF5();
            WeatherEntity.ShowapiResBodyEntity.F6Entity f6 = weatherEntity.getShowapi_res_body().getF6();
            WeatherEntity.ShowapiResBodyEntity.F7Entity f7 = weatherEntity.getShowapi_res_body().getF7();

            String f1Day_air_temperature = f1.getDay_air_temperature();
            String f2Day_air_temperature = f2.getDay_air_temperature();
            String f3Day_air_temperature = f3.getDay_air_temperature();
            String f4Day_air_temperature = f4.getDay_air_temperature();
            String f5Day_air_temperature = f5.getDay_air_temperature();
            String f6Day_air_temperature = f6.getDay_air_temperature();
            String f7Day_air_temperature = f7.getDay_air_temperature();
            dayAirTemperature.add(f1Day_air_temperature);
            dayAirTemperature.add(f2Day_air_temperature);
            dayAirTemperature.add(f3Day_air_temperature);
            dayAirTemperature.add(f4Day_air_temperature);
            dayAirTemperature.add(f5Day_air_temperature);
            dayAirTemperature.add(f6Day_air_temperature);
            dayAirTemperature.add(f7Day_air_temperature);

            String f1Night_air_temperature = f1.getNight_air_temperature();
            String f2Night_air_temperature = f2.getNight_air_temperature();
            String f3Night_air_temperature = f3.getNight_air_temperature();
            String f4Night_air_temperature = f4.getNight_air_temperature();
            String f5Night_air_temperature = f5.getNight_air_temperature();
            String f6Night_air_temperature = f6.getNight_air_temperature();
            String f7Night_air_temperature = f7.getNight_air_temperature();
            nightAirTemperature.add(f1Night_air_temperature);
            nightAirTemperature.add(f2Night_air_temperature);
            nightAirTemperature.add(f3Night_air_temperature);
            nightAirTemperature.add(f4Night_air_temperature);
            nightAirTemperature.add(f5Night_air_temperature);
            nightAirTemperature.add(f6Night_air_temperature);
            nightAirTemperature.add(f7Night_air_temperature);

            String f1Time = f1.getDay().substring(f1.getDay().indexOf("5") + 1);
            String f2Time = f2.getDay().substring(f1.getDay().indexOf("5") + 1);
            String f3Time = f3.getDay().substring(f1.getDay().indexOf("5") + 1);
            String f4Time = f4.getDay().substring(f1.getDay().indexOf("5") + 1);
            String f5Time = f5.getDay().substring(f1.getDay().indexOf("5") + 1);
            String f6Time = f6.getDay().substring(f1.getDay().indexOf("5") + 1);
            String f7Time = f7.getDay().substring(f1.getDay().indexOf("5") + 1);

            StringBuffer stringBuffer1 = new StringBuffer(f1Time);
            stringBuffer1.insert(2, "月").append("日");
            StringBuffer stringBuffer2 = new StringBuffer(f2Time);
            stringBuffer2.insert(2, "月").append("日");
            StringBuffer stringBuffer3 = new StringBuffer(f3Time);
            stringBuffer3.insert(2, "月").append("日");
            StringBuffer stringBuffer4 = new StringBuffer(f4Time);
            stringBuffer4.insert(2, "月").append("日");
            StringBuffer stringBuffer5 = new StringBuffer(f5Time);
            stringBuffer5.insert(2, "月").append("日");
            StringBuffer stringBuffer6 = new StringBuffer(f6Time);
            stringBuffer6.insert(2, "月").append("日");
            StringBuffer stringBuffer7 = new StringBuffer(f7Time);
            stringBuffer7.insert(2, "月").append("日");

            time.add(stringBuffer1.toString());
            time.add(stringBuffer2.toString());
            time.add(stringBuffer3.toString());
            time.add(stringBuffer4.toString());
            time.add(stringBuffer5.toString());
            time.add(stringBuffer6.toString());
            time.add(stringBuffer7.toString());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }

    }

    private void initView(View view) {
        TextView title = (TextView) view.findViewById(R.id.text_view);
        title.setText(cityName + "未来七日预报");

        recyclerView = ((RecyclerView) view.findViewById(R.id.recycler_view));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        if ("{\"showapi_res_code\":0,\"showapi_res_error\":\"\",\"showapi_res_body\":{\"remark\":\"找不到此地名!\",\"ret_code\":-1}}".equals(data)) {

            weatherEntity=null;

        }
        recyclerView.setAdapter(new AdvanceAdapter(weatherEntity, getActivity()));

        mChart = ((LineChart) view.findViewById(R.id.chart));
        setChart(mChart);

        // 制作7个数据点。
        setData(mChart, dayAirTemperature.size());

        Legend l = mChart.getLegend();
        l.setForm(Legend.LegendForm.LINE);
        l.setTextSize(12f);
        l.setTextColor(Color.BLACK);
        l.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);

        XAxis xAxis = mChart.getXAxis();

        // 将X坐标轴的标尺刻度移动底部。
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        // X轴之间数值的间隔
        xAxis.setSpaceBetweenLabels(1);
//        xAxis.setTypeface();

        xAxis.setTextSize(8f);
        xAxis.setTextColor(Color.BLACK);

        YAxis leftAxis = mChart.getAxisLeft();
        setYAxisLeft(leftAxis);

        YAxis rightAxis = mChart.getAxisRight();
        setYAxisRight(rightAxis);
//        mChart.setRendererRightYAxis();


//        mChart.animateX(2500);
    }

    private void setChart(LineChart mChart) {
        mChart.setDescription("酷天气,酷酷的天气");
        mChart.setNoDataTextDescription("如果传递的数值是空，那么你将看到这段文字。");
        mChart.setHighlightPerDragEnabled(true);
        mChart.setHighlightPerDragEnabled(true);
        mChart.setTouchEnabled(true);
        mChart.setDragDecelerationFrictionCoef(0.9f);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setDrawGridBackground(true);
        mChart.setHighlightPerDragEnabled(true);
        mChart.setPinchZoom(true);
//        mChart.setBackgroundColor(Color.GRAY);
        mChart.animateX(2000);
//        mChart.setBackgroundResource(R.mipmap.wx_share_day);
        mChart.setGridBackgroundColor(Color.WHITE & 0x70); // 表格的的颜色，在这里是是给颜色设置一个透明度
    }

    private void setYAxisLeft(YAxis leftAxis) {
        // 在左侧的Y轴上标出10个刻度值
        leftAxis.setLabelCount(10, true);
        leftAxis.setShowOnlyMinMax(true);

        // Y坐标轴轴线的颜色
        leftAxis.setGridColor(Color.WHITE);

        // Y轴坐标轴上坐标刻度值的颜色
        leftAxis.setTextColor(Color.WHITE);

        // Y坐标轴最大值
        leftAxis.setAxisMaxValue(30);

        // Y坐标轴最小值
        leftAxis.setAxisMinValue(-20);

        leftAxis.setStartAtZero(false);

        leftAxis.setDrawLabels(true);
    }

    private void setYAxisRight(YAxis rightAxis) {
        // Y坐标轴上标出4个刻度值
        rightAxis.setLabelCount(10, true);

        // Y坐标轴上刻度值的颜色
        rightAxis.setTextColor(Color.BLACK);

        // Y坐标轴上轴线的颜色
        rightAxis.setGridColor(Color.BLACK);

        // Y坐标轴最大值
        rightAxis.setAxisMaxValue(40);

        // Y坐标轴最小值
        rightAxis.setAxisMinValue(-30);

        rightAxis.setStartAtZero(false);
        rightAxis.setDrawLabels(true);
    }

    private void setData(LineChart mChart, int count) {

//        String day = entity.getF1().getDay();
//        int intDay = new Integer(day);
//        ArrayList<String> xVals = new ArrayList<String>();
//        for (int i = 0; i < count; i++) {
//            xVals.add("某月" + (i + 1) + "日");
//        }

//        try {
        ArrayList<Entry> yHigh = new ArrayList<Entry>();
        LineDataSet high = new LineDataSet(yHigh, "白天");
        setHighTemperature(high, yHigh, count);

        ArrayList<Entry> yLow = new ArrayList<Entry>();
        LineDataSet low = new LineDataSet(yLow, "夜晚");
        setLowTemperature(low, yLow, count);

        ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
        dataSets.add(high);
        dataSets.add(low);

        LineData data = new LineData(time, dataSets);
        data.setValueTextColor(Color.WHITE);
        data.setValueTextSize(10f);
        mChart.setData(data);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private void setHighTemperature(LineDataSet high, ArrayList<Entry> yVals,
                                    int count) {

        for (int i = 0; i < count; i++) {
            String s = dayAirTemperature.get(i);
            float val = new Float(s);
            yVals.add(new Entry(val, i));
        }

        // 以左边的Y坐标轴为准
        high.setAxisDependency(YAxis.AxisDependency.LEFT);

        high.setLineWidth(2f);
        high.setColor(Color.WHITE);
        high.setCircleSize(3f);
        high.setCircleColor(Color.WHITE);
        high.setCircleColorHole(Color.WHITE);
//        high.setDrawCircleHole(true);

        // 设置折线上显示数据的格式。如果不设置，将默认显示float数据格式。
        high.setValueFormatter(new ValueFormatter() {

            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                DecimalFormat decimalFormat = new DecimalFormat(".0");
                String s = "" + decimalFormat.format(((double) v)) + "℃";
                return s;
            }

        });

    }

    private void setLowTemperature(LineDataSet low, ArrayList<Entry> yVals,
                                   int count) {

        for (int i = 0; i < count; i++) {
            String s = nightAirTemperature.get(i);
            float val = new Float(s);
            yVals.add(new Entry(val, i));
        }

        // 以右边Y坐标轴为准
        low.setAxisDependency(YAxis.AxisDependency.RIGHT);

        // 折现的颜色
        low.setColor(Color.BLACK);

        // 线宽度
        low.setLineWidth(2f);

        // 折现上点的圆球颜色
        low.setCircleColor(Color.BLACK);

        // 填充圆球中心部位洞的颜色
        low.setCircleColorHole(Color.BLACK);

        // 圆球的尺寸
        low.setCircleSize(3f);

//        low.setDrawCircleHole(true);

        low.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                DecimalFormat decimalFormat = new DecimalFormat(".0");
                String s = "" + decimalFormat.format(v) + "℃";
                return s;
            }
        });
    }

}
