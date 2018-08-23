package com.gjj.gd.materialdesign_v7.widget_study.recyclerview;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;

import com.gjj.gd.materialdesign_v7.BaseActivity;
import com.gjj.gd.materialdesign_v7.R;
import com.gjj.gd.materialdesign_v7.widget_study.recyclerview.adapter.HeaderAndFooterWrapper;
import com.gjj.gd.materialdesign_v7.widget_study.recyclerview.adapter.HeaderAndFotterAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeaderAndFooterActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_and_footer);
        ButterKnife.bind(this);
        setTitle("添加Header和Footer");
        //创建处理正常数据的adapter
        HeaderAndFotterAdapter adapter = new HeaderAndFotterAdapter(this);

        //创建负责处理Header和footer的adpapter
        HeaderAndFooterWrapper headerAndFooterWrapper = new HeaderAndFooterWrapper(adapter);
        TextView t1 = new TextView(this);
        t1.setText("Header 1");
        TextView t2 = new TextView(this);
        t2.setText("Header 2");
        TextView t3 = new TextView(this);
        t3.setText("Footer 1");
        TextView t4 = new TextView(this);
        t4.setText("Footer 2");
        headerAndFooterWrapper.addHeaderView(t1);
        headerAndFooterWrapper.addHeaderView(t2);
        headerAndFooterWrapper.addFooterView(t3);
        headerAndFooterWrapper.addFooterView(t4);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));

        //RecyclerView的Adapter被赋值为headerAndFooterWrapper，
        // 而正常处理数据的adapter在headerAndFooterWrapper中被调用
        mRecyclerView.setAdapter(headerAndFooterWrapper);
    }
}
