package com.cwq.picturebanner.widgets;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2018/2/23 0023.
 * 立方体翻转效果
 */

public class CubePageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        page.setRotationX(0);
        page.setRotationY(0);
        page.setRotation(0);
        page.setScaleX(1);
        page.setScaleY(1);
        page.setPivotX(0);
        page.setPivotY(0);
        page.setTranslationY(0);
        page.setTranslationX(0f);

        page.setAlpha(position <= -1f || position >= 1f ? 0f : 1f);

        page.setPivotX(position < 0f ? page.getWidth() : 0f);
        page.setPivotY(page.getHeight() * 0.5f);
        page.setRotationY(90f * position);
    }
}
