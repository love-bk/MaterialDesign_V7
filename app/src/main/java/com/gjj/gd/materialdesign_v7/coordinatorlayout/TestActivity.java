package com.gjj.gd.materialdesign_v7.coordinatorlayout;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.gjj.gd.materialdesign_v7.R;
import com.gjj.gd.materialdesign_v7.coordinatorlayout.adapter.TestRecyclerViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.appbar_layout)
    AppBarLayout mAppbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        mToolbar.setTitle("Material Design");
        setSupportActionBar(mToolbar);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        TestRecyclerViewAdapter adapter = new TestRecyclerViewAdapter();
        mRecycler.setLayoutManager(manager);
        mRecycler.setAdapter(adapter);
    }

}
