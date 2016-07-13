package com.shadev.pierrebeziercircle.Demo3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shadev.pierrebeziercircle.R;

public class Main3Activity extends AppCompatActivity {
    LxView mLxView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mLxView = (LxView) findViewById(R.id.mLxView);
    }

    public void left(View v) {
        mLxView.setLeft();
    }

    public void mleft(View v) {
        mLxView.setMleft();
    }

    public void middle(View v) {
        mLxView.setMiddle();
    }

    public void mright(View v) {
        mLxView.setMRight();
    }

    public void right(View v) {
        mLxView.setRight();
    }


}
