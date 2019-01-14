package com.example.lishuaizhe114;

import android.content.Context;
import android.util.Log;

public class KqwException implements Thread.UncaughtExceptionHandler {


    private static  KqwException kqwException;

    private Context context;

    public KqwException(Context context) {
        this.context = context;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        long id = t.getId();
        String message = e.getMessage();
        String localizedMessage = e.getLocalizedMessage();
        Log.i("Ke","==================================================");
        Log.i("Ke","Thread"+id);
        Log.i("Ke","==================================================");
        Log.i("Ke","Thread"+message);
        Log.i("Ke","==================================================");
        Log.i("Ke","Thread"+localizedMessage);
        Log.i("Ke","==================================================");
        e.printStackTrace();
        Log.i("Ke","应用被重新启动");
        context.startActivity(context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()));
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
