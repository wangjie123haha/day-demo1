package com.example.day12demozk3.ui;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.adapter.myadapter;
import com.example.bean.news;
import com.example.day12demozk3.R;
import com.example.day12demozk3.di.icontract;
import com.example.day12demozk3.di.presenterimp;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;


import java.util.List;

public class zs extends AppCompatActivity implements icontract.iview {

    private RecyclerView recycley;
    private presenterimp presenterimp;
    private SmartRefreshLayout sml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zs);
        presenterimp = new presenterimp();
        presenterimp.attachview(this);
        presenterimp.requestinfo();
        //初始化
        recycley = findViewById(R.id.recycley);
        sml = findViewById(R.id.sml);

    }

    @Override
    public void showdata(final String s) {
       runOnUiThread(new Runnable() {
           @Override
           public void run() {
               Gson gson = new Gson();
               news news = gson.fromJson(s, news.class);
               List<com.example.bean.news.DataBean> data = news.getData();
               myadapter myadapter = new myadapter(zs.this,data);
               myadapter.setOnItemClickListen(new myadapter.onItemClickListen() {
                   @Override
                   public void onItemClick(int layoutPosition) {
                       Intent intent = new Intent(zs.this, map.class);
                       startActivity(intent);
                       finish();
                   }
               });
               LinearLayoutManager manager = new LinearLayoutManager(zs.this, LinearLayoutManager.VERTICAL, false);
               recycley.setLayoutManager(manager);
               recycley.setAdapter(myadapter);
           }
       });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      presenterimp.detachview(this);
    }
}
