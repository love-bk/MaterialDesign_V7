package com.gjj.gd.materialdesign_v7.widget_study.tablayout;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.gjj.gd.materialdesign_v7.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 高娟娟 on 2017/3/16.
 */

public class MyTabView extends FrameLayout {
    @BindView(R.id.title_tv)
    TextView title_tv;
    @BindView(R.id.heart_iv)
    ImageView heart_iv;

    public MyTabView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public MyTabView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        View.inflate(context,R.layout.custome_tab_view,this);
        ButterKnife.bind(this,this);
    }

    public void setData(int iconResId,String title){
        heart_iv.setImageResource(iconResId);
        title_tv.setText(title);
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected){
            title_tv.setTextColor(Color.RED);
        }else {
            title_tv.setTextColor(Color.BLACK);
        }
    }
}
