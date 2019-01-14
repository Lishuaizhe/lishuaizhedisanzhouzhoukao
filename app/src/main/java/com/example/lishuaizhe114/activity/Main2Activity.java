package com.example.lishuaizhe114.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lishuaizhe114.R;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private static final int CESHI = 1;
    /**
     * 扫码
     */
    private Button mSaoma;
    private ImageView mImageView;
    /**
     * 请输入要生成的数据
     */
    private EditText mEditChazhao;
    /**
     * 生成二维码
     */
    private Button mShengcheng;
    /**
     * 崩溃测试
     */
    private Button mBengkui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();

        getSupportActionBar().hide();


    }

    private void initView() {
        mSaoma = (Button) findViewById(R.id.saoma);
        mSaoma.setOnClickListener(this);
        mImageView = (ImageView) findViewById(R.id.image_view);
        mEditChazhao = (EditText) findViewById(R.id.edit_chazhao);
        mShengcheng = (Button) findViewById(R.id.shengcheng);
        mShengcheng.setOnClickListener(this);
        mImageView.setOnClickListener(this);
        mEditChazhao.setOnClickListener(this);
        mBengkui = (Button) findViewById(R.id.bengkui);
        mBengkui.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.saoma:
                Saoma();
                break;
            case R.id.shengcheng:
                Shengcheng();
                break;
            case R.id.image_view:
                break;
            case R.id.edit_chazhao:
                break;
            case R.id.bengkui:
                bengkui();
                break;
        }
    }

    /*
    * 崩溃测试
    * */
    private void bengkui() {
        int a   = 1/0;
    }

    /*
     * 生成二维码
     * */
    private void Shengcheng() {
        String s = mEditChazhao.getText().toString();
        if (s.length() != 0) {
            Bitmap aaa = CodeUtils.createImage(s, 150, 150, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
            mImageView.setImageBitmap(aaa);
        } else {
            Toast.makeText(Main2Activity.this, "请你输入要生车为二位吗的数据", Toast.LENGTH_SHORT).show();
        }
    }

    /*
     * 扫描二维码
     * */
    private void Saoma() {
        Intent intent = new Intent(Main2Activity.this,CaptureActivity.class);
        startActivityForResult(intent,CESHI);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CESHI){
            if (data!=null){
                Bundle extras = data.getExtras();
                if (extras==null){
                    return;
                }
                if (extras.getInt(CodeUtils.RESULT_TYPE)==CodeUtils.RESULT_SUCCESS){
                    String result = extras.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(Main2Activity.this, "得到解析结果"+result, Toast.LENGTH_SHORT).show();
                }else if (extras.getInt(CodeUtils.RESULT_TYPE)==CodeUtils.RESULT_FAILED){
                    String result = extras.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(Main2Activity.this, "二维码解析失败"+result, Toast.LENGTH_SHORT).show();
                }
            }

        }

    }
}
