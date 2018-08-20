package com.example.day12demozk3.di;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by lenovo on 2018/8/19.
 */

public class HttpUtils  {

    private  static  HttpUtils httpUtils;
    private OkHttpClient okHttpClient;
    private  HttpUtils(){
        okHttpClient =new OkHttpClient();
    }
    public  static  HttpUtils getinstance(){
        if(httpUtils==null){
            synchronized (HttpUtils.class){
                if(httpUtils==null){
                    httpUtils =new HttpUtils();
                }
            }
        }
        return  httpUtils;
    }
    public  void  postdata(String path, Callback callback){
        Request request = new Request.Builder().url(path).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
