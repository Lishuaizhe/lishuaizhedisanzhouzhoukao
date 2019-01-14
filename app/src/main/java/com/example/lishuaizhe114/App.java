package com.example.lishuaizhe114;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        UMConfigure.init(this,"5c3336e1f1f5567b30001667\t","Ument",UMConfigure.DEVICE_TYPE_PHONE,null);
        PlatformConfig.setQQZone("100424468","c7394704798a158208a74ab60104f0ba");

        KqwException kqwException = new KqwException(this);
        Thread.setDefaultUncaughtExceptionHandler(kqwException);


        UMConfigure.setLogEnabled(true);
    }
}
