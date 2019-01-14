package com.example.lishuaizhe114.contrect;

import com.example.lishuaizhe114.net.OkhttpCallBack;

import java.util.HashMap;

public interface LoginContrect {

    abstract class Ilogin_Persenter{
      public  abstract void Login_getData(HashMap<String,String> hashMap);
    }

    interface Ilogin_Model{
        void Login_getData(HashMap<String,String> hashMap,OkhttpCallBack callBack );
    }


    interface Ilogin_View{
        void Successs(String s);
        void Fuil(String s);
    }

}
