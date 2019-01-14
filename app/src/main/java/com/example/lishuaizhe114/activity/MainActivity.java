package com.example.lishuaizhe114.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lishuaizhe114.bean.Bean;
import com.example.lishuaizhe114.persenter.LoginPersenter;
import com.example.lishuaizhe114.R;
import com.example.lishuaizhe114.contrect.LoginContrect;
import com.google.gson.Gson;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,LoginContrect.Ilogin_View{

    /**
     * 登录
     */
    private Button mDenglu;
    /**
     * qq登录
     */
    private Button mQqdenglu;
    /**
     * 请输入账号
     */
    private EditText mName;
    /**
     * 请输入密码
     */
    private EditText mPass;
    private LoginPersenter persenter;
    private UMShareAPI umShareAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        initView();

        initData();

    }

    /*
    * 加载数据
    * */
    private void initData() {
        persenter = new LoginPersenter(this);

        umShareAPI = UMShareAPI.get(this);
    }

    /*
    * 获取资源id
    * */
    private void initView() {
        mDenglu = (Button) findViewById(R.id.denglu);
        mDenglu.setOnClickListener(this);
        mQqdenglu = (Button) findViewById(R.id.qqdenglu);
        mQqdenglu.setOnClickListener(this);
        mName = (EditText) findViewById(R.id.name);
        mPass = (EditText) findViewById(R.id.pass);
    }

    /*
    * 点击事件
    * */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.denglu:
                denglu();
                break;
            case R.id.qqdenglu:
                qqdenglu();
                break;
        }
    }

    /*
    * 三方登录
    * */
    private void qqdenglu() {
        umShareAPI.getPlatformInfo(MainActivity.this,SHARE_MEDIA.QQ, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {

            }
        });

    }

    //登录
    private void denglu() {
        String name = mName.getText().toString();
        String pass = mPass.getText().toString();
        if (name.length()!=0&pass.length()!=0){
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("mobile",name);
            hashMap.put("password",pass);
            persenter.Login_getData(hashMap);
        }else {
            Toast.makeText(MainActivity.this,"账号密码为空,请你输入",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void Successs(String s) {
        Bean bean = new Gson().fromJson(s, Bean.class);
        String msg = bean.getMsg();
        if (msg.equals("登录成功")){
            Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
            Intent intent  = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void Fuil(String s) {
        Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode,resultCode,data);
    }
}
