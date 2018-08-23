package com.gjj.gd.materialdesign_v7.widget_study.toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gjj.gd.materialdesign_v7.BaseActivity;
import com.gjj.gd.materialdesign_v7.R;
import com.gjj.gd.materialdesign_v7.adapter.ItemAdapter;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ToolBarActivity extends BaseActivity implements ItemAdapter.OnItemClickListener {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private Intent intent;
    private String[] mItemTitles;
    private ItemAdapter mItemAdapter;
    private HashMap<String, Class> itemMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        ButterKnife.bind(this);
        setTitle(R.string.toolbar_study);
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mItemAdapter = new ItemAdapter(this, mItemTitles);
        mItemAdapter.setListener(this);
        recyclerView.setAdapter(mItemAdapter);
    }

    private void initData() {
        mItemTitles = getResources().getStringArray(R.array.toolbar);
        itemMap = new HashMap<>();
        itemMap.put(getResources().getString(R.string.main_toolbar), JichuActivity.class);
        itemMap.put(getResources().getString(R.string.zhihu_toolbar), ZhifuActivity.class);
        itemMap.put(getResources().getString(R.string.toolbar_1), ToolbarInstance1Activity.class);
        itemMap.put(getResources().getString(R.string.toolbar_2), ToolbarInstance2Activity.class);
        itemMap.put(getResources().getString(R.string.toolbar_3), ToolbarInstance3Activity.class);
    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(this,itemMap.get(mItemTitles[position])));
    }
}
