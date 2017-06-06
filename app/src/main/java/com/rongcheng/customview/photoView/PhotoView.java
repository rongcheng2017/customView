/*******************************************************************************
 * Copyright 2011, 2012 Chris Banes.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.rongcheng.customview.photoView;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.widget.ImageView;

import com.rongcheng.customview.R;

/**
 * A zoomable {@link ImageView}. See {@link PhotoViewAttacher} for most of the details on how the zooming
 * is accomplished
 */
public class PhotoView extends ImageView {
    private Paint mPaint = new Paint();

    private PhotoViewAttacher attacher;

    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attr) {
        this(context, attr, 0);
    }

    public PhotoView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        init();
        initPaint();
    }

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
        Rect rect = new Rect();
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
    @TargetApi(21)
    public PhotoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }



    private void init() {

        attacher = new PhotoViewAttacher(this);
        //We always pose as a Matrix scale type, though we can change to another scale type
        //via the attacher
        super.setScaleType(ScaleType.MATRIX);
    }

    /**
     * Get the current {@link PhotoViewAttacher} for this view. Be wary of holding on to references
     * to this attacher, as it has a reference to this view, which, if a reference is held in the
     * wrong place, can cause memory leaks.
     *
     * @return the attacher.
     */
    public PhotoViewAttacher getAttacher() {
        return attacher;
    }

    @Override
    public ScaleType getScaleType() {
        return attacher.getScaleType();
    }

    @Override
    public Matrix getImageMatrix() {
        return attacher.getImageMatrix();
    }

    @Override
    public void setOnLongClickListener(OnLongClickListener l) {
        attacher.setOnLongClickListener(l);
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        attacher.setOnClickListener(l);
    }

    @Override
    public void setScaleType(ScaleType scaleType) {
        attacher.setScaleType(scaleType);
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        // setImageBitmap calls through to this method
        attacher.update();
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        attacher.update();
    }

    @Override
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        attacher.update();
    }

    @Override
    protected boolean setFrame(int l, int t, int r, int b) {
        boolean changed = super.setFrame(l, t, r, b);
        if (changed) {
            attacher.update();
        }
        return changed;
    }

    public void setRotationTo(float rotationDegree) {
        attacher.setRotationTo(rotationDegree);
    }

    public void setRotationBy(float rotationDegree) {
        attacher.setRotationBy(rotationDegree);
    }

    @Deprecated
    public boolean isZoomEnabled() {
        return attacher.isZoomEnabled();
    }

    public boolean isZoomable() {
        return attacher.isZoomable();
    }

    public void setZoomable(boolean zoomable) {
        attacher.setZoomable(zoomable);
    }

    public RectF getDisplayRect() {
        return attacher.getDisplayRect();
    }

    public void getDisplayMatrix(Matrix matrix) {
        attacher.getDisplayMatrix(matrix);
    }

    public boolean setDisplayMatrix(Matrix finalRectangle) {
        return attacher.setDisplayMatrix(finalRectangle);
    }

    public float getMinimumScale() {
        return attacher.getMinimumScale();
    }

    public float getMediumScale() {
        return attacher.getMediumScale();
    }

    public float getMaximumScale() {
        return attacher.getMaximumScale();
    }

    public float getScale() {
        return attacher.getScale();
    }

    public void setAllowParentInterceptOnEdge(boolean allow) {
        attacher.setAllowParentInterceptOnEdge(allow);
    }

    public void setMinimumScale(float minimumScale) {
        attacher.setMinimumScale(minimumScale);
    }

    public void setMediumScale(float mediumScale) {
        attacher.setMediumScale(mediumScale);
    }

    public void setMaximumScale(float maximumScale) {
        attacher.setMaximumScale(maximumScale);
    }

    public void setScaleLevels(float minimumScale, float mediumScale, float maximumScale) {
        attacher.setScaleLevels(minimumScale, mediumScale, maximumScale);
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener listener) {
        attacher.setOnMatrixChangeListener(listener);
    }

    public void setOnPhotoTapListener(OnPhotoTapListener listener) {
        attacher.setOnPhotoTapListener(listener);
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener listener) {
        attacher.setOnOutsidePhotoTapListener(listener);
    }

    public void setOnViewTapListener(OnViewTapListener listener) {
        attacher.setOnViewTapListener(listener);
    }

    public void setScale(float scale) {
        attacher.setScale(scale);
    }

    public void setScale(float scale, boolean animate) {
        attacher.setScale(scale, animate);
    }

    public void setScale(float scale, float focalX, float focalY, boolean animate) {
        attacher.setScale(scale, focalX, focalY, animate);
    }

    public void setZoomTransitionDuration(int milliseconds) {
        attacher.setZoomTransitionDuration(milliseconds);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        attacher.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        attacher.setOnScaleChangeListener(onScaleChangedListener);
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        attacher.setOnSingleFlingListener(onSingleFlingListener);
    }

}
