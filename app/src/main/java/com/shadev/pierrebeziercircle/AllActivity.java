package com.shadev.pierrebeziercircle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shadev.pierrebeziercircle.Demo1.MainActivity;
import com.shadev.pierrebeziercircle.Demo2.Main2Activity;
import com.shadev.pierrebeziercircle.Demo3.Main3Activity;
import com.shadev.pierrebeziercircle.Demo4.Main4Activity;
import com.shadev.pierrebeziercircle.Demo5.Main5Activity;
import com.shadev.pierrebeziercircle.Demo6.Main6Activity;

public class AllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);


        //demo 4 小圆点跳跃
    }


    public void demo1(View v) {
        startActivity(new Intent(AllActivity.this, MainActivity.class));
    }


    public void demo2(View v) {
        startActivity(new Intent(AllActivity.this, Main2Activity.class));
    }

    public void demo3(View v) {
        startActivity(new Intent(AllActivity.this, Main3Activity.class));
    }


    public void demo4(View v) {
        startActivity(new Intent(AllActivity.this, Main4Activity.class));
    }

    public void demo5(View v) {
        startActivity(new Intent(AllActivity.this, Main5Activity.class));
    }


    public void demo6(View v) {
        startActivity(new Intent(AllActivity.this, Main6Activity.class));
    }

}
