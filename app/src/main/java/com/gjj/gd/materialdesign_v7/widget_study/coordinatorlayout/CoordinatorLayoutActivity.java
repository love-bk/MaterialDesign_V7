package com.gjj.gd.materialdesign_v7.widget_study.coordinatorlayout;

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

public class CoordinatorLayoutActivity extends BaseActivity implements ItemAdapter.OnItemClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private Intent mIntent;
    private String[] mItemTitles;
    private HashMap<String, Class> itemMap;
    private ItemAdapter mItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
        ButterKnife.bind(this);
        setTitle(R.string.coordinatorlayout_study);
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mItemAdapter = new ItemAdapter(this, mItemTitles);
        mItemAdapter.setListener(this);
        recyclerView.setAdapter(mItemAdapter);
    }

    private void initData() {
        mItemTitles = getResources().getStringArray(R.array.coordinator_layout);
        itemMap = new HashMap<>();
        itemMap.put(getResources().getString(R.string.with_snackbar), CombineSnackbarActivity.class);
        itemMap.put(getResources().getString(R.string.with_appbarlayout), TestActivity.class);
        itemMap.put(getResources().getString(R.string.custom_behavior), BehaviorInstance1Activity.class);
    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(this,itemMap.get(mItemTitles[position])));
    }
}
