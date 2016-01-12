package com.gaopinwei.kutianqi.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gaopinwei.kutianqi.R;
import com.gaopinwei.kutianqi.fragment.Fragment01;
import com.gaopinwei.kutianqi.request.db.NoteBookDB;
import com.gaopinwei.kutianqi.request.entitys.NoteBook;
import com.gaopinwei.kutianqi.request.entitys.WeatherEntity;
import com.gaopinwei.kutianqi.request.utils.GetPathFromUri;
import com.gaopinwei.kutianqi.request.utils.ReadWriteFileUtil;
import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;

import java.io.File;

import de.greenrobot.event.EventBus;

/**
 * 编辑日记的界面
 */
public class AddNotebookActivity extends AppCompatActivity {
    private static final int RESULT_LOAD_IMAGE = 100;
    private static final int REQUEST_CODE_CAPTURE_CAMEIA = 200;

    private ImageView imageView_file_add;  //取消按钮图片
    private ImageView imageView_success_add; //保存按钮图片
    private EditText editText_title;         //标题控件
    private EditText edittext_write_notebook; //正文控件

    private String title; //标题的内容
    private String content; //正文的内容
    private String title_from_f4; //已存在的标题
    private String content_from_f4; //已存在的内容

    private String cityName;   //从f4获取当前城市名
    private String weatherInfoFromF4;   //根据城市获取的天气信息

    private TextView textView_innotebook_weather; //天气信息
    private TextView textView_innotebook_weekday;  //星期几
    private TextView textView_innotebook_date;  //日期
    private String imagePath;//图片路径
    private ImageView imageView;//要展示的图片

    private boolean isPicEdited = false;//图片是否剪裁过

    private NoteBookDB db;  //日记数据库操作类


    /**
     * 根据从主界面传过来的城市名，在本地获取日期，星期以及天气信息
     */
    public void getTodayInfo() {
        //从本地获取数据
        weatherInfoFromF4 = ReadWriteFileUtil.readFileData(cityName + ".txt");

        //如果城市信息齐全
        if (!"{\"showapi_res_code\":0,\"showapi_res_error\":\"\",\"showapi_res_body\":{\"remark\":\"找不到此地名!\",\"ret_code\":-1}}".equals(weatherInfoFromF4)) {

            WeatherEntity weatherEntity = new Gson().fromJson(weatherInfoFromF4, WeatherEntity.class);

            //星期几
            int index = weatherEntity.getShowapi_res_body().getF1().getWeekday();
            String weekday = "";
            if (index == 1) {
                weekday = "星期一";
            } else if (index == 2) {
                weekday = "星期二";
            } else if (index == 3) {
                weekday = "星期三";
            } else if (index == 4) {
                weekday = "星期四";
            } else if (index == 5) {
                weekday = "星期五";
            } else if (index == 6) {
                weekday = "星期六";
            } else if (index == 7) {
                weekday = "星期日";
            }
            textView_innotebook_weekday.setText(weekday);

            //天气信息
            String day_weather_pic = weatherEntity.getShowapi_res_body().getNow().getWeather();

            //日期
            String formatedDateTime = Fragment01.getFormatedDateTime("yyyy/MM/dd", Long.valueOf(System.currentTimeMillis()));
            textView_innotebook_date.setText(formatedDateTime);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notebook);

        db = NoteBookDB.getInstance(this); //实例化日记数据库操作类

        //接收传过来的值
        Intent intent = getIntent();
        title_from_f4 = intent.getStringExtra("title");
        content_from_f4 = intent.getStringExtra("content");
        cityName = intent.getStringExtra("cityName");
        imagePath = intent.getStringExtra("pathName");

        //日期和天气控件
        textView_innotebook_weekday = (TextView) findViewById(R.id.textView_innotebook_weekday);
        textView_innotebook_weather = (TextView) findViewById(R.id.textView_innotebook_weather);
        textView_innotebook_date = (TextView) findViewById(R.id.textView_innotebook_date);

        getTodayInfo(); //显示日期和天气

        //标题和内容编辑框
        editText_title = (EditText) findViewById(R.id.editText_title);
        edittext_write_notebook = (EditText) findViewById(R.id.edittext_write_notebook);

        //要展示的图片
        imageView = (ImageView) findViewById(R.id.imageView_note);

        //如果从f4跳转过来时，传的值不为“kong”，则表示要进行展示或者编辑
        if (!title_from_f4.equals("kong") && !content_from_f4.equals("kong")) {
            showNotebook();  //展示出来
        }

        //字符个数限制
        edittext_write_notebook.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3000)});

        imageView_file_add = (ImageView) findViewById(R.id.imageView_file_add);
        imageView_success_add = (ImageView) findViewById(R.id.imageView_success_add);

        imageView_file_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接返回
                finish();
            }
        });

        imageView_success_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddNotebookActivity.this.title = editText_title.getText().toString();
                content = edittext_write_notebook.getText().toString();

                if (!TextUtils.isEmpty(AddNotebookActivity.this.title) && !TextUtils.isEmpty(content)) {

                    //给f4发消息
//                    EventBus.getDefault().post(new NoteBook(AddNotebookActivity.this.title, content, imagePath));

                    //存入数据库
                    String s = db.queryByTitle(title);
                    if (s != null) {
                        //1.如果已有相同标题，修改其中内容
                        int update = db.update(new NoteBook(title, content, imagePath));
                        if (update > 0) {
                            Toast.makeText(AddNotebookActivity.this, "修改成功！", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(AddNotebookActivity.this, "修改失败！", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        //2.没有的话，直接新建一条
                        db.saveNotebook(new NoteBook(title, content, imagePath));
                    }

                    finish();

                } else {
                    Toast.makeText(AddNotebookActivity.this, "不写点神马？？", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        //添加图片操作
        ImageView imageView_add_pic = (ImageView) findViewById(R.id.imageView_add_pic);
        imageView_add_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //弹出对话框,有两个选项:从本地图库选择照片,或者使用相机拍照
                final AlertDialog alertDialog = new AlertDialog.Builder(AddNotebookActivity.this).create();

                LayoutInflater inflater = LayoutInflater.from(AddNotebookActivity.this);
                View view = inflater.inflate(R.layout.dialog_list, null);

                //进入图库选择图片
                LinearLayout go_to_pic = (LinearLayout) view.findViewById(R.id.go_to_pic);
                go_to_pic.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(//固定写法
                                Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(i, RESULT_LOAD_IMAGE);
                        alertDialog.dismiss();
                    }
                });

                //进入相机拍照
                LinearLayout go_to_camera = (LinearLayout) view.findViewById(R.id.go_to_camrea);
                go_to_camera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent getImageByCamera = new Intent("android.media.action.IMAGE_CAPTURE");
                        startActivityForResult(getImageByCamera, REQUEST_CODE_CAPTURE_CAMEIA);
                        alertDialog.dismiss();
                    }
                });

                alertDialog.setTitle("请选择要使用的应用");
                alertDialog.setView(view);

                //显示对话框
                alertDialog.show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {//图片成功返回

            if (data != null) {

                Uri uri = data.getData();
                if (uri != null) {

                    //根据本地相册图片URI获取图片的绝对路径
                    imagePath = GetPathFromUri.getPath(AddNotebookActivity.this, uri);

                    //进行图片压缩操作
                    Bitmap bitmap = getNewBitmap(imagePath);

                    imageView.setImageBitmap(bitmap);

                    //让图片可见
                    imageView.setVisibility(View.VISIBLE);
//                    Log.e("pic", string);

                } else {//拍照后获取的数据
                    Bundle extras = data.getExtras();//获取封装数据的 bundle
                    Bitmap bitmap = (Bitmap) extras.get("data");// 通过 bundle 将内部的 bitmap 获取到
                    imageView.setImageBitmap(bitmap);

                    //反过来获取缩略图片Uri
                    uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, null, null));

                    //根据本地相册图片URI获取图片的绝对路径
                    imagePath = GetPathFromUri.getPath(AddNotebookActivity.this, uri);

                    /*
                    跳到图片剪裁页面,现已放弃
                     */
//                    if (!isPicEdited) {
//
//                        isPicEdited=true;
//
//                        Intent i = new Intent("com.android.camera.action.CROP");
//                        i.setType("image/*");
//
//                        i.setDataAndType(uri, "image/jpeg");
//
//                        i.putExtra("crop", "true");
//
//                        i.putExtra("aspectX", 1);
//
//                        i.putExtra("aspectY", 1);
//
//                        i.putExtra("outputX", 500);
//
//                        i.putExtra("outputY", 500);
//
//                        i.putExtra("return-data", true);
//
//                        this.startActivityForResult(i, 7);//进入图片剪裁页面
//
//                        if (requestCode == 7) {//获取剪裁后的图片
//
//                            Bitmap bb = data.getParcelableExtra("data");
//                            imageView.setImageBitmap(bb);
//
//                        }
//                    }
                    //让图片可见
                    imageView.setVisibility(View.VISIBLE);
                }

            }

        }
    }

    /**
     * 进行图片压缩操作
     *
     * @param imagePath
     * @return
     */
    @NonNull
    private Bitmap getNewBitmap(String imagePath) {
        //进行图片压缩操作
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath, options); //此时返回 bm 为空
        options.inJustDecodeBounds = false; //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = (int) (options.outHeight / (float) 320);
        if (be <= 0)
            be = 1;
        options.inSampleSize = be; //重新读入图片，注意此时已经把 options.inJustDecodeBounds 设回 false 了
        bitmap = BitmapFactory.decodeFile(imagePath, options);
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        return bitmap;
    }

    /**
     * 展示已存在的日记
     */
    private void showNotebook() {
        editText_title.setText(title_from_f4);
        edittext_write_notebook.setText(content_from_f4);

        if (imagePath != null) {

            //压缩图片并显示
            Bitmap bitmap = getNewBitmap(imagePath);
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageBitmap(bitmap);
        }
    }
}
