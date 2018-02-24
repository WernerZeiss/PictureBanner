package com.cwq.picturebanner;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cwq.picturebanner.adapter.MyPagerAdapter;
import com.cwq.picturebanner.widgets.BookPageTransformer;
import com.cwq.picturebanner.widgets.CubePageTransformer;
import com.cwq.picturebanner.widgets.ScalePageTransformer;
import com.cwq.picturebanner.widgets.ViewPagerIndicator;

public class MainActivity extends AppCompatActivity {

    ViewPager vp1, vp2, vp3;
    ViewPagerIndicator indicator;
    TextView tv_info1, tv_info3;

    private int[] imgRes = {R.mipmap.girl1, R.mipmap.girl2, R.mipmap.girl3, R.mipmap.girl4, R.mipmap.girl5};
    private String[] strRes = {"第一个", "第二个", "第三个", "第四个", "第五个"};

    MyPagerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //透明状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar)
            actionBar.hide();


        vp1 = findViewById(R.id.vp_1);
        vp2 = findViewById(R.id.vp_2);
        vp3 = findViewById(R.id.vp_3);
        indicator = findViewById(R.id.indicator);
        tv_info1 = findViewById(R.id.tv_info1);
        tv_info3 = findViewById(R.id.tv_info3);


        mAdapter = new MyPagerAdapter(this, imgRes);
        initViewPager1();
        initViewPager2();
        initViewPager3();
    }


    private void initViewPager1() {
        indicator.setItemCount(imgRes.length);
        tv_info1.setText(strRes[0]);
        vp1.setOffscreenPageLimit(3);
        vp1.setAdapter(mAdapter);
        vp1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                indicator.setPositionAndOffset(position, positionOffset);
            }

            @Override
            public void onPageSelected(int position) {
                tv_info1.setText(strRes[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        vp1.setPageTransformer(false, new BookPageTransformer());
    }


    private void initViewPager2() {
        vp2.setOffscreenPageLimit(3);
        vp2.setPageMargin(20);
        vp2.setAdapter(mAdapter);

        vp2.setPageTransformer(true, new ScalePageTransformer());
    }


    private void initViewPager3() {
        vp3.setOffscreenPageLimit(3);
        vp3.setAdapter(mAdapter);
        tv_info3.setText(strRes[0]);
        vp3.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tv_info3.setText(strRes[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        vp3.setPageTransformer(false, new CubePageTransformer());
    }
}
