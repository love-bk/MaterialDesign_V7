package com.gjj.gd.materialdesign_v7.toolbar;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.gjj.gd.materialdesign_v7.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ToolbarInstance2Activity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    PopupWindow mPopupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_menu_layout);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(android.view.MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_edit:
                        Toast.makeText(ToolbarInstance2Activity.this, "点击了编辑", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_share:
                        Toast.makeText(ToolbarInstance2Activity.this, "点击了分享", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_overflow:
                        //弹出自定义overflow
                        popUpMyOverFlow();
                        return true;

                }
                return true;
            }
        });
    }

    //弹出自定义的Popwindow
    private void popUpMyOverFlow() {
        //获取状态栏高度
        Rect frame = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        //状态栏高度+toolbar的高度
        int yOffset = frame.top+mToolbar.getHeight();
        if (null == mPopupWindow){
            //初始化PopupWindow的布局
            View popView = getLayoutInflater().inflate(R.layout.action_overflow_popwindow, null);
            //popView即popupWindow的布局，true设置focusable
            mPopupWindow = new PopupWindow(popView,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    true);
            //必须设置BackgroundDrawable后setOutsideTouchable（true）才会有效
            mPopupWindow.setBackgroundDrawable(new ColorDrawable());
            //点击外部关闭
            mPopupWindow.setOutsideTouchable(true);
            //设置一个动画
            mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
            //设置Gravity，让他显示在右上角
            mPopupWindow.showAtLocation(mToolbar,Gravity.RIGHT|Gravity.TOP,20,yOffset);
            //设置item的点击监听
            popView.findViewById(R.id.ll_item1).setOnClickListener(this);
            popView.findViewById(R.id.ll_item2).setOnClickListener(this);
            popView.findViewById(R.id.ll_item3).setOnClickListener(this);
        }else {
            mPopupWindow.showAtLocation(mToolbar,Gravity.RIGHT|Gravity.TOP,20,yOffset);
        }
    }


    //如果有Menu，创建完之后，系统会自动添加到Toolbar上
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.custom_menu,menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_item1:
                Toast.makeText(this, "哈哈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_item2:
                Toast.makeText(this, "呵呵", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_item3:
                Toast.makeText(this, "嘻嘻", Toast.LENGTH_SHORT).show();
                break;
        }
        //点击PopWindow的item后，关闭此PopWindow
        if (null!=mPopupWindow && mPopupWindow.isShowing()){
            mPopupWindow.dismiss();
        }
    }
}
