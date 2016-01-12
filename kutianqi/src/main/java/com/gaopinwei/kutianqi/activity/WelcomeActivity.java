package com.gaopinwei.kutianqi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.gaopinwei.kutianqi.R;


/**
 * 起始界面(欢迎界面)
 *
 */
public class WelcomeActivity extends AppCompatActivity {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 001:
                    startActivity(new Intent(WelcomeActivity.this,GuideActivity.class));
                    WelcomeActivity.this.finish();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        handler.sendEmptyMessageDelayed(001,2000); //2秒后跳转到导航页
    }
}
