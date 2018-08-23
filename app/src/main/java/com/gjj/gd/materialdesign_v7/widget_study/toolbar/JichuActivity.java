package com.gjj.gd.materialdesign_v7.widget_study.toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.gjj.gd.materialdesign_v7.BaseActivity;
import com.gjj.gd.materialdesign_v7.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JichuActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_jichu);
        ButterKnife.bind(this);

        mToolbar.inflateMenu(R.menu.toolbar_menu);          //设置右上角的填充菜单
        mToolbar.setNavigationIcon(R.mipmap.ic_drawer_home);//设置导航栏图标
        mToolbar.setLogo(R.mipmap.ic_launcher);             //设置app的logo

        mToolbar.setTitle("Title");                         //设置主标题
        mToolbar.setTitleTextColor(Color.MAGENTA);
        mToolbar.setSubtitle("Subtitle");                   //设置子标题
        mToolbar.setSubtitleTextColor(Color.WHITE);

        //设置菜单的点击事件
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_search:
                        Toast.makeText(JichuActivity.this, R.string.menu_search, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_notification:
                        Toast.makeText(JichuActivity.this, R.string.menu_notifications, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_item01:
                        Toast.makeText(JichuActivity.this, R.string.item01, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_item02:
                        Toast.makeText(JichuActivity.this, R.string.item02, Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
}
