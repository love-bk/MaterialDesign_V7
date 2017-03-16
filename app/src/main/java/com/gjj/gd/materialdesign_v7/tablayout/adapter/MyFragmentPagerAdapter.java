package com.gjj.gd.materialdesign_v7.tablayout.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;

import com.gjj.gd.materialdesign_v7.Constant;
import com.gjj.gd.materialdesign_v7.R;
import com.gjj.gd.materialdesign_v7.tablayout.MyTabView;
import com.gjj.gd.materialdesign_v7.tablayout.fragment.PageFragment;

/**
 * Created by 高娟娟 on 2017/3/15.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    public final int COUNT = 5;
    private  String flag;
    private Context context;
    private String[] titles = new String[]{"Tab1","Tab2","Tab3","Tab4","Tab5"};
    private int[] resIds = new int[]{R.mipmap.heart_01,R.mipmap.heart_02,R.mipmap.heart_03,
            R.mipmap.heart_04,R.mipmap.heart_05};
    public MyFragmentPagerAdapter(FragmentManager fm, Context context,String flag) {
        super(fm);
        this.context = context;
        this.flag = flag;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position+1);
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (Constant.TABLAYOUT_JBSY.equals(flag)){
            return titles[position];
        }else if (Constant.TABLAYOUT_XSTB.equals(flag)){
            return getIcon(position);
        }else {
            return titles[position];
        }
    }

    private SpannableString getIcon(int position){
        Drawable drawable = null;
        switch (position){
            case 0:
                drawable = ContextCompat.getDrawable(context, R.mipmap.heart_01);
                break;
            case 1:
                drawable = ContextCompat.getDrawable(context, R.mipmap.heart_02);
                break;
            case 2:
                drawable = ContextCompat.getDrawable(context, R.mipmap.heart_03);
                break;
            case 3:
                drawable = ContextCompat.getDrawable(context, R.mipmap.heart_04);
                break;
            case 4:
                drawable = ContextCompat.getDrawable(context, R.mipmap.heart_05);
                break;
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
        SpannableString spannableString = new SpannableString(" ");
        spannableString.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    public View getTabView(int position) {
        MyTabView myTabView = new MyTabView(context);
        myTabView.setData(resIds[position],titles[position]);
        return myTabView;
    }
}
