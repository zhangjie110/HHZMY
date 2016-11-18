package com.bwei.hhzmy.loader;

import android.app.Application;

import com.bwei.hhzmy.tools.ImageLoaderUtils;

/**
 * Created by zhangjie on 2016/11/14.
 */
public class MyImageLoader extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        onitimageloader();
    }

    private void onitimageloader() {
        // TODO Auto-generated method stub

        ImageLoaderUtils.initConfiguration(getApplicationContext());
    }
}
