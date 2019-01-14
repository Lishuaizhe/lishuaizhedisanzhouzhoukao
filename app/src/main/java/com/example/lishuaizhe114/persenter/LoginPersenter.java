package com.example.lishuaizhe114.persenter;

import com.example.lishuaizhe114.contrect.LoginContrect;
import com.example.lishuaizhe114.model.LoginModel;
import com.example.lishuaizhe114.net.OkhttpCallBack;

import java.util.HashMap;

public class LoginPersenter extends LoginContrect.Ilogin_Persenter{


    private LoginModel model;
    private LoginContrect.Ilogin_View view;

    public LoginPersenter(LoginContrect.Ilogin_View view) {
        this.view = view;
        model = new LoginModel();
    }

    @Override
    public void Login_getData(HashMap<String, String> hashMap) {
        model.Login_getData(hashMap, new OkhttpCallBack() {
            @Override
            public void Success(String s) {
                view.Successs(s);
            }

            @Override
            public void Fuil(String s) {
                view.Fuil(s);
            }
        });
    }
}
