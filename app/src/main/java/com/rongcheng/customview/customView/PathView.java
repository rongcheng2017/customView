package com.rongcheng.customview.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author frc
 *         created at 17-6-6.
 */

public class PathView extends View {

    private Paint mPaint = new Paint();
    private float mWidth, mHeight;

    public PathView(Context context) {
        this(context, null);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth / 2, mHeight / 2);

        // lineTo
        Path path = new Path();

//        path.lineTo(200, 200);//第一次由于之前没有过操作，所以默认点就是坐标原点O

//        path.moveTo(200,100);//此时的起点原本应该是(200,200), 现在变成了(200,100)

//        path.setLastPoint(200, 100);//etLastPoint是重置上一次操作的最后一个点，在执行完第一次的lineTo的时候，最后一个点是A(200,200),而setLastPoint更改最后一个点为C(200,100),所以在实际执行的时候

//        path.lineTo(200, 0);

//        path.close();//close方法用于连接当前最后一个点和最初的一个点(如果两个点不重合的话)，最终形成一个封闭的图形。
        //注意：close的作用是封闭路径，与连接当前最后一个点和第一个点并不等价。如果连接了最后一个点和第一个点仍然无法形成封闭图形，则close什么 也不做。

//        Path.Direction.CCW 逆时针
//        Path.Direction.CW 顺时针
        path.addRect(-200,-200,200,200, Path.Direction.CW);

        path.setLastPoint(-300,300);

        canvas.drawPath(path, mPaint);
    }
}
