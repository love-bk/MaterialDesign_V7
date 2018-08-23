package com.gjj.gd.materialdesign_v7.widget_study.toolbar;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.view.MenuItem;
import android.widget.Toast;

import com.gjj.gd.materialdesign_v7.BaseActivity;
import com.gjj.gd.materialdesign_v7.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ToolbarInstance3Activity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    /**
     * 也可以用onOptionsItemSelected实现菜单item的点击事件
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_instance3);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        //与drawerLayout的结合使用
        //显示左侧菜单图标
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()){
        case R.id.ab_search:
            Toast.makeText(ToolbarInstance3Activity.this, "ab_search", Toast.LENGTH_SHORT).show();
            break;
        case R.id.action_shares:
            Toast.makeText(ToolbarInstance3Activity.this, "action_shares", Toast.LENGTH_SHORT).show();
            break;
        case R.id.action_settings:
            Toast.makeText(ToolbarInstance3Activity.this, "action_settings", Toast.LENGTH_SHORT).show();
            break;

    }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.instance3_menu,menu);
        return true;
    }
}
