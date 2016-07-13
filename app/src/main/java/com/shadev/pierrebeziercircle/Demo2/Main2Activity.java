package com.shadev.pierrebeziercircle.Demo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shadev.pierrebeziercircle.R;

public class Main2Activity extends AppCompatActivity {


    LxCircle  mLxCircle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mLxCircle = (LxCircle) findViewById(R.id.mLxCircle);

    }

    int i=10;
    public void click(View v) {
//        mLxCircle.startAnimation();
        mLxCircle.addNumber(i);
        i+=10;
    }


}
