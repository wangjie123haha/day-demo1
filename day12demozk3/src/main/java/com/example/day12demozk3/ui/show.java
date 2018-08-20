package com.example.day12demozk3.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.day12demozk3.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class show extends AppCompatActivity {

    private TextView yong;
    private TextView nicheng;
    private ImageView img;
    private Button btn_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        //初始化
        yong = findViewById(R.id.yong);
        nicheng = findViewById(R.id.nicheng);
        img = findViewById(R.id.img);
        btn_01 = findViewById(R.id.btn_01);
        Intent intent = getIntent();
        yong.setText(intent.getStringExtra("name"));
        nicheng.setText(intent.getStringExtra("sex"));
        Picasso.get().load(intent.getStringExtra("icon")).into(img);
        btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转
                Intent intent1 = new Intent(show.this, zs.class);
                startActivity(intent1);
                finish();
            }
        });

    }
}
