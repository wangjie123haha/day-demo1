package com.example.day12demozk3.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.day12demozk3.Logdl;
import com.example.day12demozk3.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button translate;
    private Button scale;
    private Button route;
    private Button alpha;
    private Button animatot_et;
    private circleview cv_circlew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化
        translate = findViewById(R.id.translate);
        cv_circlew = findViewById(R.id.cv_circle);
        scale = findViewById(R.id.scale);
        route = findViewById(R.id.route);
        alpha = findViewById(R.id.alpha);
        animatot_et = findViewById(R.id.animatot_et);
        //添加监听事件
        translate.setOnClickListener(this);
        scale.setOnClickListener(this);
        route.setOnClickListener(this);
        alpha.setOnClickListener(this);
        animatot_et.setOnClickListener(this);
        cv_circlew.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
         switch (view.getId()){
             case R.id.translate:
                 bindanimator(R.animator.animator);
                 break;
             case R.id.scale:
                 bindanimator(R.animator.scale);
                break;
             case R.id.alpha:
                 bindanimator(R.animator.alpha);
                break;
             case R.id.route:
                 bindanimator(R.animator.route);
                break;
            case R.id.animatot_et:
                bindanimator(R.animator.set_animator);
                break;
             case  R.id.cv_circle:
                 Intent intent = new Intent(MainActivity.this, Logdl.class);
                 startActivity(intent);
                 finish();
             default:
                 break;
         }
    }

    private void bindanimator(int animatorId) {
        Animator animator = AnimatorInflater.loadAnimator(MainActivity.this,animatorId);
        animator.setTarget(cv_circlew);
        animator.start();
    }
}
