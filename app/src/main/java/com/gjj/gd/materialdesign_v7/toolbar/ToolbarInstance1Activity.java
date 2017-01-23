package com.gjj.gd.materialdesign_v7.toolbar;

import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;

import com.gjj.gd.materialdesign_v7.R;

import java.util.List;

public class ToolbarInstance1Activity extends AppCompatActivity {

    private static final java.lang.String KEY_TITLE = "key_title";
    private String mTitle;
    private ContentFragment mCurrentFragment;
    private LeftMenuFragment mLeftMenuFragment;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_instance1);
        initToolBar();
        initViews();
        //恢复title
        restoreTitle(savedInstanceState);
        FragmentManager fm = getSupportFragmentManager();
        //查找当前显示的Fragment
        mCurrentFragment = (ContentFragment) fm.findFragmentByTag(mTitle);
        if (mCurrentFragment == null) {
            mCurrentFragment = ContentFragment.newInstance(mTitle);
            fm.beginTransaction().add(R.id.content_container,mCurrentFragment,mTitle).commit();
        }

        mLeftMenuFragment = (LeftMenuFragment) fm.findFragmentById(R.id.left_menu_container);
        if (mLeftMenuFragment == null) {
            mLeftMenuFragment = new LeftMenuFragment();
            fm.beginTransaction().add(R.id.left_menu_container,mLeftMenuFragment).commit();
        }
        //隐藏别的Fragment，如果存在的话
        List<Fragment> fragments = fm.getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment == mCurrentFragment || fragment==mLeftMenuFragment) continue;;
                fm.beginTransaction().hide(fragment).commit();
            }
        }

        mLeftMenuFragment.setOnMenuItemSelectedListener(new LeftMenuFragment.OnMenuItemSelectedListener() {
            @Override
            public void menuItemSelected(String title) {
                FragmentManager fm = getSupportFragmentManager();
                ContentFragment fragment = (ContentFragment) fm.findFragmentByTag(title);
                if (fragment == mCurrentFragment) {
                    mDrawerLayout.closeDrawer(Gravity.LEFT);
                    return;
                }

                FragmentTransaction transaction = fm.beginTransaction();
                transaction.hide(mCurrentFragment);
                if (fragment == null) {
                    fragment = ContentFragment.newInstance(title);
                    transaction.add(R.id.content_container,fragment,title);
                }else {
                    transaction.show(fragment);
                }
                transaction.commit();
                mCurrentFragment = fragment;
                mTitle = title;
                mToolbar.setTitle(mTitle);
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            }
        });
    }

    private void restoreTitle(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mTitle = savedInstanceState.getString(KEY_TITLE);
        }

        if (TextUtils.isEmpty(mTitle)){
            mTitle = getResources().getStringArray(R.array.menu_title)[0];
        }
        mToolbar.setTitle(mTitle);
    }

    private void initViews() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,mToolbar,
                R.string.open,
                R.string.close);
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);

    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar = toolbar;
        toolbar.setTitle(getResources().getStringArray(R.array.menu_title)[0]);

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_home_icon);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString(KEY_TITLE,mTitle);
    }
}
