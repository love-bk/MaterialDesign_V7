package com.gjj.gd.materialdesign_v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.gjj.gd.materialdesign_v7.R;
import com.gjj.gd.materialdesign_v7.listener.LoadHeaderImagesListener;
import com.gjj.gd.materialdesign_v7.util.SystemView;

public class CoordinatorTabLayout extends CoordinatorLayout {
    private  Context mContext;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private TabLayout mTabLayout;
    private ImageView mImageView;
    private Toolbar mToolbar;
    private ActionBar mActionBar;
    private int[] mImageArray;
    private int[] mColorArray;
    private LoadHeaderImagesListener mLoadHeaderImagesListener;

    public CoordinatorTabLayout(Context context) {
        super(context);
        mContext = context;
    }

    public CoordinatorTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        if (!isInEditMode()){
            initView(context);
            initWidget(context,attrs);
        }
    }


    public CoordinatorTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        if (!isInEditMode()){
            initView(context);
            initWidget(context,attrs);
        }
    }

    private void initWidget(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CoordinatorTabLayout);
        TypedValue typedValue = new TypedValue();
        mContext.getTheme().resolveAttribute(R.attr.colorPrimary,typedValue,true);
        int contentScrimColor = typedArray.getColor(R.styleable.CoordinatorTabLayout_contentScrim, typedValue.data);
        mCollapsingToolbarLayout.setContentScrimColor(contentScrimColor);

        int tabIndicatorColor = typedArray.getColor(R.styleable.CoordinatorTabLayout_tabIndicatorColor, Color.WHITE);
        mTabLayout.setSelectedTabIndicatorColor(tabIndicatorColor);

        int tabTextColor = typedArray.getColor(R.styleable.CoordinatorTabLayout_tabTextColor, Color.WHITE);
        mTabLayout.setTabTextColors(ColorStateList.valueOf(tabTextColor));

        typedArray.recycle();
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_coordiantortablayout,this,true);
        initToolbar();
        mCollapsingToolbarLayout = ((CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbarlayout));
        mTabLayout = ((TabLayout) findViewById(R.id.tablayout));
        mImageView = ((ImageView) findViewById(R.id.imageview));
    }

    private void initToolbar() {
        mToolbar = ((Toolbar) findViewById(R.id.toolbar));
        ((AppCompatActivity) mContext).setSupportActionBar(mToolbar);
        mActionBar = ((AppCompatActivity) mContext).getSupportActionBar();
    }

    /**
     * 设置标题
     * @param title
     * @return
     */
    public CoordinatorTabLayout setTitle(String title){
        if (mActionBar != null){
            mActionBar.setTitle(title);
        }
        return this;
    }

    /**
     * 设置toolbar显示返回按钮
     * @param canBack
     * @return
     */
    public CoordinatorTabLayout setBackEnable(Boolean canBack){
        if (canBack && mActionBar != null){
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_white_24dp);
        }
        return this;
    }
    /**
     * 设置每个tab对应的头部照片
     * @param imageArray
     * @return
     */
    public CoordinatorTabLayout setImageArray(@NonNull int[] imageArray){
        mImageArray = imageArray;
        setupTabLayout();
        return this;
    }

    /**
     * 设置每个tab对应的头部照片和contentScrimColor
     * @param imageArray
     * @param colorArray
     * @return
     */
    public CoordinatorTabLayout setImageArray(@NonNull int[] imageArray,@NonNull int[] colorArray){
        mImageArray = imageArray;
        mColorArray = colorArray;
        setupTabLayout();
        return this;
    }

    public CoordinatorTabLayout setContentScrimColorArray(@NonNull int[] colorArray){
        mColorArray = colorArray;
        return this;
    }
    private void setupTabLayout() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mImageView.startAnimation(AnimationUtils.loadAnimation(mContext,R.anim.anim_dismiss));
                if (mLoadHeaderImagesListener == null){
                    if (mImageArray != null){
                        mImageView.setImageResource(mImageArray[tab.getPosition()]);
                    }
                }else {
                    mLoadHeaderImagesListener.loadHeaderImages(mImageView,tab);
                }
                if (mColorArray != null){
                    mCollapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(
                            mContext,mColorArray[tab.getPosition()]));
                }
                mImageView.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.anim_show));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public TabLayout getTabLayout() {
        return mTabLayout;
    }

    public ImageView getImageView() {
        return mImageView;
    }

    public ActionBar getActionBar() {
        return mActionBar;
    }

    /**
     * 设置于该组件搭配的viewPager
     * @param viewPager
     * @return
     */
    public CoordinatorTabLayout setupWithViewPager(ViewPager viewPager){
        mTabLayout.setupWithViewPager(viewPager);
        return this;
    }
    public CoordinatorTabLayout setLoadHeaderImagesListener(LoadHeaderImagesListener loadHeaderImagesListener) {
        mLoadHeaderImagesListener = loadHeaderImagesListener;
        setupTabLayout();
        return this;
    }

    public CoordinatorTabLayout setTransulcentStatusBar(@NonNull Activity activity){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
            return this;
        }else {
            mToolbar.setPadding(0, SystemView.getStatusBarHeight(activity)/2,0,0);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        return this;
    }
}
