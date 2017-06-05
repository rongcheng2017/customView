package com.rongcheng.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.method.Touch;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import uk.co.senab.photoview.PhotoView;

/**
 * @author frc
 *         created at 17-6-5.
 */

public class TestView extends PhotoView {
    private Paint mPaint = new Paint();

    public TestView(Context context) {
        this(context, null);
    }

    public TestView(Context context, AttributeSet attr) {
        this(context, attr, 0);
    }

    public TestView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            initPaint();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void initPaint() {
        mPaint.setColor(Color.RED);//设置画笔颜色
        mPaint.setStyle(Paint.Style.FILL);//设置画笔模式为填充
        mPaint.setStrokeWidth(10f);//设置画笔宽度为10px
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.raw);
        Bitmap tmpBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas tmpCanvas = new Canvas(tmpBitmap);

        tmpCanvas.drawBitmap(bitmap, 0, 0, null);
        tmpCanvas.drawLine(dip2px(383), dip2px(870), dip2px(507), dip2px(870), mPaint);// 在坐标(300,300)(500,600)之间绘制一条直线
        drawLine(tmpCanvas, 172, 1077, 488, 1077, mPaint);
        drawLine(tmpCanvas, 714, 1414, 1020, 1414, mPaint);
        drawLine(tmpCanvas, 623, 1445, 806, 1445, mPaint);

        tmpCanvas.drawBitmap(getNewMarkIcon(R.drawable.mark_small), dip2px(500 - 16), dip2px(838 - 18), null);
        tmpCanvas.drawBitmap(getNewMarkIcon(R.drawable.mark_big), dip2px(476 - 16), dip2px(1046 - 18), null);

        mPaint.setColor(Color.BLUE);
        tmpCanvas.drawRect(dip2px(500 - 20), dip2px(838 + 18), dip2px(630), dip2px(838 + 50), mPaint);


        mPaint.setColor(Color.RED);
        mPaint.setTextSize(dip2px(18));
        mPaint.setStrokeWidth(20f);//设置画笔宽度为10px
        tmpCanvas.drawText("hello world!", dip2px(500), dip2px(838 + 36), mPaint);

        tmpCanvas.save(Canvas.ALL_SAVE_FLAG);
        tmpCanvas.restore();
        setImageDrawable(new BitmapDrawable(getResources(), tmpBitmap));
    }

    void drawLine(Canvas canvas, float x0, float y0, float x1, float y1, Paint p) {
        canvas.drawLine(dip2px(x0), dip2px(y0), dip2px(x1), dip2px(y1), p);
    }

    public void Restore() {

    }

    public int dip2px(float dipValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public int dp2px(int dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, getResources().getDisplayMetrics());
    }


    private Bitmap getNewMarkIcon(int rid) {
        Bitmap iconBig = BitmapFactory.decodeResource(getResources(), rid);
        int w = iconBig.getWidth();
        int h = iconBig.getHeight();
        //设置想要的大小
        int rw = dip2px(33);
        int rh = dip2px(36);
        //计算缩放比
        float scaleWidth = ((float) rw / w);
        float scaleHeight = ((float) rh / h);
        //取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        //得到新的图片
        iconBig = Bitmap.createBitmap(iconBig, 0, 0, w, h, matrix, true);

        return iconBig;
    }


    public void dismissLineAndText() {
        mPaint.setColor(Color.RED);//设置画笔颜色
        mPaint.setStyle(Paint.Style.FILL);//设置画笔模式为填充
        mPaint.setStrokeWidth(10f);//设置画笔宽度为10px
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.raw);
        Bitmap tmpBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas tmpCanvas = new Canvas(tmpBitmap);

        tmpCanvas.drawBitmap(bitmap, 0, 0, null);
        tmpCanvas.drawLine(dip2px(383), dip2px(870), dip2px(507), dip2px(870), mPaint);// 在坐标(300,300)(500,600)之间绘制一条直线
        drawLine(tmpCanvas, 172, 1077, 488, 1077, mPaint);
        drawLine(tmpCanvas, 714, 1414, 1020, 1414, mPaint);
        drawLine(tmpCanvas, 623, 1445, 806, 1445, mPaint);

        tmpCanvas.drawBitmap(getNewMarkIcon(R.drawable.mark_small), dip2px(500 - 16), dip2px(838 - 18), null);
        tmpCanvas.drawBitmap(getNewMarkIcon(R.drawable.mark_big), dip2px(476 - 16), dip2px(1046 - 18), null);

//        mPaint.setColor(Color.BLUE);
//        tmpCanvas.drawRect(dip2px(500 - 20), dip2px(838 + 18), dip2px(630), dip2px(838 + 50), mPaint);


//        mPaint.setColor(Color.RED);
//        mPaint.setTextSize(dip2px(18));
//        mPaint.setStrokeWidth(20f);//设置画笔宽度为10px
//        tmpCanvas.drawText("hello world!", dip2px(500), dip2px(838 + 36), mPaint);

        tmpCanvas.save(Canvas.ALL_SAVE_FLAG);
        tmpCanvas.restore();
        setImageDrawable(new BitmapDrawable(getResources(), tmpBitmap));
        invalidate();
    }
}
