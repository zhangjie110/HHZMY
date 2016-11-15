package com.bwei.hhzmy.loader;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by zhangjie on 2016/11/14.
 */
public class MyImageLoader extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration=ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(configuration);
    }
}
