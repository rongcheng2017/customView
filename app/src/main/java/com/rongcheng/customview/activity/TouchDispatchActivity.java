package com.rongcheng.customview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.rongcheng.customview.R;

/**
 * 事件传递
 *
 * @author fengrongcheng
 *         created at 17-6-8 下午3:11
 */
public class TouchDispatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_dispatch);
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                Log.d("touch", "TouchDispatchActivity  dispatchTouchEvent : MotionEvent.ACTION_DOWN");
//                return super.dispatchTouchEvent(ev);
//            case MotionEvent.ACTION_UP:
//                Log.d("touch", "TouchDispatchActivity  dispatchTouchEvent : MotionEvent.ACTION_UP");
//                return super.dispatchTouchEvent(ev);
//            default:
//                return super.dispatchTouchEvent(ev);
//        }
//    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("touch", "TouchDispatchActivity onTouchEvent: MotionEvent.ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("touch", "TouchDispatchActivity onTouchEvent: MotionEvent.ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }
}
