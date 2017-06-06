package com.rongcheng.customview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rongcheng.customview.R;
import com.rongcheng.customview.customView.PieView;
import com.rongcheng.customview.model.PieData;

import java.util.ArrayList;

public class PieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);
        PieView pieView = (PieView) findViewById(R.id.pie_view);
        ArrayList<PieData> pieDatas = new ArrayList<>();
        pieDatas.add(new PieData("IT", 33));
        pieDatas.add(new PieData("金融", 25));
        pieDatas.add(new PieData("房地产", 27));
        pieDatas.add(new PieData("其他", 15));
        pieView.setData(pieDatas);
    }
}
