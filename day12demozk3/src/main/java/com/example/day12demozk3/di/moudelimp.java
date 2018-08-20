package com.example.day12demozk3.di;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by lenovo on 2018/8/19.
 */

public class moudelimp implements icontract.imoudel {
   String path ="http://www.zhaoapi.cn/product/searchProducts?keywords=手机&page=1&sort=0";
    @Override
    public void response(final calllistten calllistten) {
        HttpUtils httpUtils = HttpUtils.getinstance();
        httpUtils.postdata(path, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                 calllistten.responsemsg(s);
            }
        });
    }
}
