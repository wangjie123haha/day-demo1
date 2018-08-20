package com.example.day12demozk3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.day12demozk3.R;


/**
 * Created by lenovo on 2018/8/19.
 */

public class circleview extends View {


    private int radius;
    private int color;

    public circleview(Context context) {
        super(context);
    }

    public circleview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //操作属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.circleview);
        //通过tapearray属性来设置
        for (int i = 0; i < typedArray.length(); i++) {
            int index = typedArray.getIndex(i);
            switch (index){
                case   R.styleable.circleview_radius :
                    radius = typedArray.getInt(index, 20);
                    break;
                case  R.styleable.circleview_clolor:
                    color = typedArray.getInt(index, Color.RED);
                    break;
            }
        }

    }
    //测量

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
       setMeasuredDimension(getMeasuredWidth(widthMeasureSpec),getMeasuredHeight(heightMeasureSpec));
    }

    private int getMeasuredHeight(int heightMeasureSpec) {
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        int size = MeasureSpec.getSize(heightMeasureSpec);
        int result =0;
        if(mode==MeasureSpec.AT_MOST){
            result =getPaddingTop()+getPaddingBottom()+2*radius;
        }else  if(mode==MeasureSpec.EXACTLY){
            result =size;
        }
        return  result;
     }

    private int getMeasuredWidth(int widthMeasureSpec) {
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int result =0;
        if(mode==MeasureSpec.AT_MOST){
            result =getPaddingLeft()+getPaddingRight()+2*radius;
        }else  if(mode==MeasureSpec.EXACTLY){
             result = size;
        }
        return   result;
    }

    //绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        canvas.drawCircle(radius,radius,radius,paint);
    }
}
