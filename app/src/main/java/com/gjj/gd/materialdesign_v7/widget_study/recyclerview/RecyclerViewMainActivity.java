package com.gjj.gd.materialdesign_v7.widget_study.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gjj.gd.materialdesign_v7.BaseActivity;
import com.gjj.gd.materialdesign_v7.R;
import com.gjj.gd.materialdesign_v7.adapter.ItemAdapter;
import com.gjj.gd.materialdesign_v7.widget_study.recyclerview.AddRemoveItemActivity;
import com.gjj.gd.materialdesign_v7.widget_study.recyclerview.ClassifyActivity;
import com.gjj.gd.materialdesign_v7.widget_study.recyclerview.RefreshAndLoadMoreActivity;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewMainActivity extends BaseActivity implements ItemAdapter.OnItemClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private Intent mIntent;
    private HashMap<String, Class> itemMap;
    private String[] mItemTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);
        ButterKnife.bind(this);
        setTitle("RecyclerView的学习");
        initData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemAdapter adapter = new ItemAdapter(this, mItemTitles);
        recyclerView.setAdapter(adapter);
        adapter.setListener(this);
    }

    private void initData() {
        mItemTitles = getResources().getStringArray(R.array.recycler_view);
        itemMap = new HashMap<>();
        itemMap.put(getResources().getString(R.string.recyclerview_click_delete), ClassifyActivity.class);
        itemMap.put(getResources().getString(R.string.recyclerview_refresh), RefreshAndLoadMoreActivity.class);
        itemMap.put(getResources().getString(R.string.recyclerview_header_footer), HeaderAndFooterActivity.class);
        itemMap.put(getResources().getString(R.string.rv_add_remove_item), AddRemoveItemActivity.class);
    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(this,itemMap.get(mItemTitles[position])));
    }
}
