package com.cwq.picturebanner.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cwq.picturebanner.R;

/**
 * Created by Administrator on 2018/2/23 0023.
 */

public class MyPagerAdapter extends PagerAdapter {
    private Context mContext;
    private int[] mImgRes;

    public MyPagerAdapter(Context context, int[] imgRes) {
        mContext = context;
        mImgRes = imgRes;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_vp, null, false);
        ImageView imageView = view.findViewById(R.id.item_lunbotu_iv);
        imageView.setImageResource(mImgRes[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mImgRes.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
