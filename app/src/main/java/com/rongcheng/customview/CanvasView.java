package com.rongcheng.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author frc
 *         created at 17-6-2.
 */

public class CanvasView extends View {
    private Paint mPaint = new Paint();

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint.setColor(Color.BLACK);//设置画笔颜色
        mPaint.setStyle(Paint.Style.FILL);//设置画笔模式为填充
        mPaint.setStrokeWidth(10f);//设置画笔宽度为10px
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onDraw(Canvas canvas) {
        //        canvas.drawColor(Color.BLUE);//画布颜色
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.raw);
//        bitmap.setConfig(Bitmap.Config.ARGB_8888);
//        bitmap.setHeight(1600);
//        bitmap.setWidth(1200);
        canvas.drawBitmap(bitmap, 0, 0, mPaint);


//        canvas.drawPoint(200, 200, mPaint);//在坐标(200,200)位置绘制一个点
//        canvas.drawPoints(new float[]{500, 500, 500, 600, 500, 700}, mPaint);//绘制一组点，坐标位置由float数组指定
        mPaint.setColor(Color.RED);
        canvas.drawLine(300, 300, 500, 600, mPaint);// 在坐标(300,300)(500,600)之间绘制一条直线
//        canvas.drawLines(new float[]{               // 绘制一组线 每四数字(两个点的坐标)确定一条线
//                100, 200, 200, 200,
//                100, 300, 200, 300
//        }, mPaint);

        //关于绘制矩形，Canvas提供了三种重载方法，
        // 第一种就是提供四个数值(矩形左上角和右下角两个点的坐标)来确定一个矩形进行绘制。
        // 其余两种是先将矩形封装为Rect或RectF(实际上仍然是用两个坐标点来确定的矩形)，然后传递给Canvas绘制

//        canvas.drawRect(100,100,300,200,mPaint);
//
//        Rect rect= new Rect(100,220,300,320);
//        canvas.drawRect(rect,mPaint);
//
//        RectF rectF= new RectF(100,400,400,700);
//        canvas.drawRect(rectF,mPaint);


        //矩形
        // RectF rectF = new RectF(100, 100, 800, 400);

        //绘制矩形背景
        //mPaint.setColor(Color.GRAY);
        //canvas.drawRect(rectF, mPaint);

        //绘制圆角矩形
        // mPaint.setColor(Color.BLUE);
        // canvas.drawRoundRect(rectF, 700, 400, mPaint);

        // 绘制一个圆心坐标在(500,500)，半径为400 的圆。
        // canvas.drawCircle(500,500,400,mPaint);

    }
}
