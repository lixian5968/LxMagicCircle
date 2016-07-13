package com.shadev.pierrebeziercircle.Demo4;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shadev.pierrebeziercircle.R;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity {


    private ViewPager mViewPager;
    private int[] mImgIds = new int[]{R.drawable.android_guide_step_1, R.drawable.android_guide_step_2, R.drawable.android_guide_step_3,R.drawable.android_guide_step_1};
    List<ImageView> mImageViews = new ArrayList<ImageView>();


    LxMagicCircle  mLxMagicCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initData();
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mLxMagicCircle = (LxMagicCircle) findViewById(R.id.mLxMagicCircle);

        mLxMagicCircle.setSize(mImageViews.size());

        mViewPager.setPageTransformer(true, new LxTransformer(mLxMagicCircle));
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                container.addView(mImageViews.get(position));
                return mImageViews.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(mImageViews.get(position));
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public int getCount() {
                return mImgIds.length;
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mLxMagicCircle.setCheck(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    private void initData() {
        for (int imgId : mImgIds) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(imgId);
            imageView.setTag(imgId);
            mImageViews.add(imageView);

        }
    }


}
