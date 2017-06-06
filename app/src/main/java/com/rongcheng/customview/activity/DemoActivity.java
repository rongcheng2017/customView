package com.rongcheng.customview.activity;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.rongcheng.customview.R;
import com.rongcheng.customview.customView.TestView;

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {
    PopupWindow mCancelPopupWindow;
    TestView mTestView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        mTestView = (TestView) findViewById(R.id.drew_line);
        mTestView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showCancelPopupWindow(DemoActivity.this);
                return false;
            }
        });
    }


    private void showCancelPopupWindow(Activity context) {
        if (mCancelPopupWindow == null) {
            View pop = LayoutInflater.from(context).inflate(R.layout.pop_ask_cancel_layout, null);
            pop.findViewById(R.id.tv_line_one).setOnClickListener(this);
            pop.findViewById(R.id.tv_line_two).setOnClickListener(this);
            pop.findViewById(R.id.tv_line_three).setOnClickListener(this);
            pop.findViewById(R.id.tv_show_mark).setOnClickListener(this);
            pop.findViewById(R.id.tv_show_text).setOnClickListener(this);
            mCancelPopupWindow = new PopupWindow(pop, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            mCancelPopupWindow.setAnimationStyle(R.style.pop_anim);
//            mCancelPopupWindow.setFocusable(true);
            mCancelPopupWindow.setOutsideTouchable(true);
            mCancelPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        }
        mCancelPopupWindow.showAtLocation(context.getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_line_one:
                if (mTestView.isFristLineShow) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        mTestView.dismissFristLine();
                    }
                } else {
                    mTestView.showFirstLine();
                }
                break;
            case R.id.tv_line_two:
                if (mTestView.isSecondLineShow) {
                    mTestView.dismissSecondLine();
                } else {
                    mTestView.showSecondLine();
                }
                break;
            case R.id.tv_line_three:
                if (mTestView.isThridLineShow) {
                    mTestView.dismissThirdLine();
                } else {
                    mTestView.showThirdLine();
                }
                break;
            case R.id.tv_show_mark:
                if(mTestView.isMarksShow) {
                    mTestView.dismissMarks();
                }else {
                    mTestView.showMarks();
                }
                break;
            case R.id.tv_show_text:
                if(mTestView.isLinkTextsShow) {
                    mTestView.dismissLinkText();
                }else {
                    mTestView.showLinkText();
                }
                break;

        }
        mCancelPopupWindow.dismiss();
    }
}
