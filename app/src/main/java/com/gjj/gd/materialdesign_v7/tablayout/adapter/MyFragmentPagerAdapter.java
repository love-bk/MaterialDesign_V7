package com.gjj.gd.materialdesign_v7.tablayout.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gjj.gd.materialdesign_v7.tablayout.fragment.PageFragment;

/**
 * Created by 高娟娟 on 2017/3/15.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    public final int COUNT = 5;
    private Context context;
    private String[] titles = new String[]{"Tab1","Tab2","Tab3","Tab4","Tab5"};
    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
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
        return titles[position];
    }
}
