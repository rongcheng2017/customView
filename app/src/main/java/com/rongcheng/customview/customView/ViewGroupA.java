package com.rongcheng.customview.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * @author frc
 *         created at 17-6-8.
 */

public class ViewGroupA extends RelativeLayout {
    public ViewGroupA(Context context) {
        this(context, null);
    }

    public ViewGroupA(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewGroupA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 传递事件
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("touch", "ViewGroupA : dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);

    }

    /**
     * 拦截事件
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        Log.d("touch", "ViewGroupA :   onInterceptTouchEvent");
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("touch", "ViewGroupA :   onInterceptTouchEvent    MotionEvent.ACTION_DOWN    ");
                return true;
            case MotionEvent.ACTION_UP:
                Log.d("touch", "ViewGroupA :   onInterceptTouchEvent    MotionEvent.ACTION_UP ");
                return false;
            default:
                return false;
        }
    }

    /**
     * 处理事件
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("touch", "ViewGroupA :   onTouchEvent   MotionEvent.ACTION_DOWN ");
                return true;
            case MotionEvent.ACTION_UP:
                Log.d("touch", "ViewGroupA :   onTouchEvent   MotionEvent.ACTION_UP ");
                break;
        }
        return super.onTouchEvent(event);
    }
}
