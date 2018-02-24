package com.cwq.picturebanner.widgets;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

/**
 * Created by Administrator on 2018/2/23 0023.
 * 缩放效果
 */

public class ScalePageTransformer implements PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        if (position < -1) {//滑出的页面
            page.setScaleX(0.75f);
            page.setScaleY(0.75f);
        } else if (position <= 1) {//[-1,1]
            if (position < 0) {//[-1,0)
                page.setScaleX(1 + 0.25f * position);
                page.setScaleY(1 + 0.25f * position);
            } else {//[0,1]
                page.setScaleX(1 - 0.25f * position);
                page.setScaleY(1 - 0.25f * position);
            }
        } else {//即将滑入的页面
            page.setScaleX(0.75f);
            page.setScaleY(0.75f);
        }
    }
}
