package com.gjj.gd.materialdesign_v7.widget_study.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gjj.gd.materialdesign_v7.BaseActivity;
import com.gjj.gd.materialdesign_v7.Constant;
import com.gjj.gd.materialdesign_v7.R;
import com.gjj.gd.materialdesign_v7.widget_study.tablayout.adapter.MyFragmentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TbCustomeTabViewActivity extends BaseActivity {

    @BindView(R.id.tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    private String loadFlag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb_custome_tab_view);
        ButterKnife.bind(this);
        String flag = getIntent().getStringExtra(Constant.JUMP_FLAG);
        if ("1".equals(flag)){
            loadFlag = Constant.TABLAYOUT_XSTB;
        }else {
            loadFlag = Constant.TABLAYOUT_ZDYVIEW;
        }
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager(), this, loadFlag);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        if ("2".equals(flag)){
            for (int i = 0; i < mTabLayout.getTabCount(); i++) {
                mTabLayout.getTabAt(i).setCustomView(adapter.getTabView(i));
            }
        }
    }
}
