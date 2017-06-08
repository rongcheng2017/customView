package com.rongcheng.customview.customView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author frc
 *         created at 17-6-8.
 */

public class ViewB extends View {
    public ViewB(Context context) {
        super(context);
    }

    public ViewB(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewB(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 事件传递
     *
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("touch", "ViewB : dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    /**
     * 事件处理
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("touch", "ViewB onTouchEvent:  ACTION_DOWN ");
                return true;
            case MotionEvent.ACTION_UP:
                Log.d("touch", "ViewB onTouchEvent: ACTION_UP ");
                return true;
            default:
                return false;
        }
    }
}
