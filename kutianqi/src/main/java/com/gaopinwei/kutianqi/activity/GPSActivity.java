package com.gaopinwei.kutianqi.activity;

import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.gaopinwei.kutianqi.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * GPS定位
 */
public class GPSActivity extends AppCompatActivity {

    private EditText editText;
    private Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        editText = (EditText) findViewById(R.id.editText);

        String address = getAddress(this);
        editText.setText(address);
    }

    /**
     * 获取manager对象
     * @param context
     * @return
     */
    public static LocationManager getLocationManager(Context context) {
        return (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
    }

    /**
     * 获取位置信息
     *
     */
    public String getAddress(Context context) {
        LocationManager locationManager = this.getLocationManager(context);
        locationManager.setTestProviderEnabled("gps",true);
        if (!locationManager.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER)) {
            //打开GPS 需Android2.2以上系统支持
            android.provider.Settings.Secure.setLocationProviderEnabled(context.getContentResolver(), LocationManager.GPS_PROVIDER, false);
        }
        String addre = doWork(context);
        Log.e("xiazhenjie", "结果是： " + addre);
        Toast.makeText(GPSActivity.this, ""+addre, Toast.LENGTH_SHORT).show();
        return addre;
    }

    /**
     * 开启定位，返回位置
     * @param context
     * @return
     */
    private String doWork(Context context) {
        String addres = "";
        LocationManager locationManager = this.getLocationManager(context);
        Criteria criteria = new Criteria();
        // 获得最好的定位效果
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(false);
        // 使用省电模式
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        String provider = locationManager.getBestProvider(criteria, true);

        //获得当前位置  location为空是一直取  从onLocationChanged里面取
        while (location == null) {
            Log.e("xiazhenjie","kong");
            location = locationManager.getLastKnownLocation(provider);
        }

        /**
         *  locationListener监听
         */
        LocationListener locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {
                GPSActivity.this.location = location;
            }

            @Override
            public void onProviderDisabled(String provider) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }
        };

//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            return "123";
//        }
        locationManager.requestLocationUpdates(provider, 0, 0, locationListener);

        Geocoder geo = new Geocoder(context, Locale.getDefault());
        try {
            List<Address> address=geo.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if(address.size()>0){
                addres=address.get(0).getAddressLine(0);
            }
        } catch (IOException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return addres;
    }

}
