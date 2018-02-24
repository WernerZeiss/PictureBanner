package com.cwq.picturebanner.widgets;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2018/2/23 0023.
 * viewpager翻页效果
 */

public class BookPageTransformer implements ViewPager.PageTransformer {


    @Override
    public void transformPage(View page, float position) {
        int width = page.getWidth();
        if (position < -1) {//滑出的页面
            page.setScrollX((int) (width * 0.75 * -1));
        } else if (position <= 1) {//[-1,1]
            if (position < 0) {//[-1,0)
                page.setScrollX((int) (width * 0.75 * position));
            } else {//[0,1]
                page.setScrollX((int) (width * 0.75 * position));
            }
        } else {//即将滑入的页面
            page.setScrollX((int) (width * 0.75));
        }
    }
}
