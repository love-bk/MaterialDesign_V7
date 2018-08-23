package com.gjj.gd.materialdesign_v7.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gjj.gd.materialdesign_v7.R;
import com.gjj.gd.materialdesign_v7.adapter.ItemAdapter;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComprehensiveExampleActivity extends AppCompatActivity implements ItemAdapter.OnItemClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private ItemAdapter mAdapter;
    private String[] itemDatas;
    private HashMap<String, Class> itemMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprehensive_example);
        ButterKnife.bind(this);
        setTitle(getString(R.string.comprehensive_example));
        initData();
        mAdapter = new ItemAdapter(this, itemDatas);
        mAdapter.setListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        //https://github.com/MaterialDesignGjj/CoordinatortablayoutDemo
        itemDatas = getResources().getStringArray(R.array.comprehensive_example);
        itemMap = new HashMap<>();
        itemMap.put(getResources().getString(R.string.zhifubao_home_telescopic), ZFBHomeTelescopicActivity.class);
        itemMap.put(getResources().getString(R.string.copy_airbnb_app_home_navigation), CopyAirbnbAppHomeNavActivity.class);
        itemMap.put(getResources().getString(R.string.instance3), Instance3Activity.class);
    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(this,itemMap.get(itemDatas[position])));
    }
}
