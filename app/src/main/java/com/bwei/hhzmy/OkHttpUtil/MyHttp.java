package com.bwei.hhzmy.OkHttpUtil;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by zhangjie on 2016/11/9.
 */
public class MyHttp {

    private static OkHttpClient mclient;
    private static final MediaType JSON = MediaType.parse("application/json;charset=utf-8");

    public static OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mclient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
        return mclient;
    }

    /**
     * 异步 post
     */

    public static void post(String url, Object object, Callback callback){
        post(url,new Gson().toJson(object),callback);
    }
    /**
     * 异步post  参数为json
     * @param url
     * @param json
     * @param callback
     */
    public static void post(String url,String json,Callback callback){
        RequestBody body = RequestBody.create(JSON,json);
        Request request =new Request.Builder()
                .url(url)
                .post(body)
                .build();
        getOkHttpClient().newCall(request).enqueue(callback);
    }

    /**
     * 异步post 参数为Map
     * @param url
     * @param map
     * @param callback
     */
    public static void post(String url, Map<String,String> map, Callback callback){
        FormBody.Builder builder = new FormBody.Builder();
        for(String key:map.keySet())
            builder.add(key,map.get(key));

        RequestBody body = builder.build();

        Request request =new Request.Builder()
                .url(url)
                .post(body)
                .build();
        getOkHttpClient().newCall(request).enqueue(callback);
    }

    /**
     * 异步get
     * @param url
     * @return
     */
    public static void get(String url,Callback callback){

        Request request =new Request.Builder()
                .url(url)
                .build();
        getOkHttpClient().newCall(request).enqueue(callback);

    }

    /**
     * 同步get
     * @param url
     * @return
     */
    public static String get(String url){

        Request request =new Request.Builder()
                .url(url)
                .build();
        try {
            Call call = getOkHttpClient().newCall(request);
            Response response = call.execute();
            if(response.isSuccessful()){
                return response.body().string();
            }else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
