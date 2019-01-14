package com.example.lishuaizhe114.model;

import com.example.lishuaizhe114.contrect.LoginContrect;
import com.example.lishuaizhe114.net.OkhttpCallBack;
import com.example.lishuaizhe114.net.OkhttpUtils;

import java.util.HashMap;

public class LoginModel implements LoginContrect.Ilogin_Model {

    private static final String Api = "http://www.zhaoapi.cn/user/login";

    @Override
    public void Login_getData(HashMap<String, String> hashMap, final OkhttpCallBack callBack) {
        OkhttpUtils.getInstance().doPost(Api, hashMap, new OkhttpCallBack() {
            @Override
            public void Success(String s) {
                callBack.Success(s);
            }

            @Override
            public void Fuil(String s) {
                callBack.Fuil(s);
            }
        });
    }
}
