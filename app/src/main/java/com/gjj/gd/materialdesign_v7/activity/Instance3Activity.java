package com.gjj.gd.materialdesign_v7.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.gjj.gd.materialdesign_v7.R;
import com.gjj.gd.materialdesign_v7.adapter.MyPagerAdapter;
import com.gjj.gd.materialdesign_v7.fragment.MainFragment;
import com.gjj.gd.materialdesign_v7.view.CoordinatorTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Instance3Activity extends AppCompatActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.coordinatortablayout)
    CoordinatorTabLayout coordinatortablayout;

    private final String[] mTitles = {"霍建华","胡歌","翟天临","赵丽颖",};
    private List<Fragment> mFragments;
    private int[] mImageArray,mColorArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instance3);
        ButterKnife.bind(this);
        initFragments();
        initViewPager();


        mImageArray = new int[]{
                R.mipmap.bg_hjh,
                R.mipmap.bg_hg,
                R.mipmap.bg_ztl,
                R.mipmap.bg_zly};
        mColorArray = new int[]{
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light};

        coordinatortablayout.setTransulcentStatusBar(this)
                .setTitle("Demo")
                .setBackEnable(true)
                .setImageArray(mImageArray,mColorArray)
                .setupWithViewPager(vp);
    }

    private void initViewPager() {
        vp.setOffscreenPageLimit(4);
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),mFragments,mTitles));
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        for (String title : mTitles) {
            mFragments.add(MainFragment.newInstance(title));
        }
    }
}
