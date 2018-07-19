package com.gjj.gd.materialdesign_v7.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.gjj.gd.materialdesign_v7.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZFBHomeTelescopicActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {


    @BindView(R.id.bg_content)
    View bgContent;                 //大布局背景遮罩层
    @BindView(R.id.iv_search)
    ImageView ivSearch;             //
    @BindView(R.id.iv_plus)
    ImageView ivPlus;
    @BindView(R.id.iv_contact)
    ImageView ivContact;
    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.iv_pay)
    ImageView ivPay;
    @BindView(R.id.iv_charge)
    ImageView ivCharge;
    @BindView(R.id.bg_toolbar_close)
    View bgToolbarClose;                    //收缩状态下toolbar的遮罩层
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.bg_toolbar_open)         //展开状态下toolbar的遮罩层
    View bgToolbarOpen;
    private View toolbarOpen;               //展开状态下toolbar显示的内容
    private View toolbarClose;              //收缩状态下toolbar显示的内容

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zfbhome_telescopic);
        ButterKnife.bind(this);
        toolbarOpen = findViewById(R.id.include_toolbar_open);
        toolbarClose = findViewById(R.id.include_toolbar_close);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        appBar.addOnOffsetChangedListener(this);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        //垂直方向偏移
        int offset = Math.abs(verticalOffset);
        //最大偏移距离
        int scrollRange = appBarLayout.getTotalScrollRange();
        //当滑动没超过一半时，展开状态下toolbar显示内容，根据收缩位置，改变透明值
        if (offset <= scrollRange / 2){
            toolbarOpen.setVisibility(View.VISIBLE);
            toolbarClose.setVisibility(View.GONE);
            //根据偏移百分比，计算透明值
            float scale2 = (float) offset / (scrollRange / 2);
            int alpha2 = (int) (255 * scale2);
            bgToolbarOpen.setBackgroundColor(Color.argb(alpha2,25,131,209));

        }else {//当滑动超过一半，收缩状态下toolbar显示内容，根据收缩位置，改变透明值
            toolbarClose.setVisibility(View.VISIBLE);
            toolbarOpen.setVisibility(View.GONE);
            float scale3 = (float) (scrollRange - offset) / (scrollRange / 2);
            int alpha3 = (int) (255 * scale3);
            bgToolbarClose.setBackgroundColor(Color.argb(alpha3,25,131,209));
        }
        //根据偏移值百分比计算扫一扫布局的透明度值
        float scale = (float) offset / scrollRange;
        int alpha = (int) (255 * scale);
        bgContent.setBackgroundColor(Color.argb(alpha,25,131,209));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appBar.removeOnOffsetChangedListener(this);
    }
}
