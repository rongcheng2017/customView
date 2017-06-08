package com.rongcheng.customview.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rongcheng.customview.R;

public class BeiSaiActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bei_sai);


        findViewById(R.id.tv_one).setOnClickListener(this);
        findViewById(R.id.tv_two).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_one:
                startActivity(new Intent(this, BezierOne.class));
                break;
            case R.id.tv_two:
                Intent intent = new Intent(this, BezierTwoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
