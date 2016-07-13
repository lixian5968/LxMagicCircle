package com.shadev.pierrebeziercircle.Demo5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shadev.pierrebeziercircle.R;

public class Main5Activity extends AppCompatActivity {


    BezierLinearPointsView ttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ttn = (BezierLinearPointsView) findViewById(R.id.ttn);


    }


    public void one(View v) {
        ttn.selectIndex(0);
    }


    public void two(View v) {
        ttn.selectIndex(1);
    }

    public void three(View v) {
        ttn.selectIndex(2);
    }

    public void four(View v) {
        ttn.selectIndex(3);
    }


}
