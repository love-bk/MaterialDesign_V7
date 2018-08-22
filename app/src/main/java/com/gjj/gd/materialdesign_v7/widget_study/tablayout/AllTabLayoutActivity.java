package com.gjj.gd.materialdesign_v7.widget_study.tablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gjj.gd.materialdesign_v7.Constant;
import com.gjj.gd.materialdesign_v7.R;
import com.gjj.gd.materialdesign_v7.adapter.ItemAdapter;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllTabLayoutActivity extends AppCompatActivity implements ItemAdapter.OnItemClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private Intent intent;
    private String[] mItemTitles;
    private HashMap<String, Class> itemMap;
    private ItemAdapter mItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tab_layout);
        ButterKnife.bind(this);
        setTitle(R.string.tablayout_study);
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mItemAdapter = new ItemAdapter(this, mItemTitles);
        mItemAdapter.setListener(this);
        recyclerView.setAdapter(mItemAdapter);
    }

    private void initData() {
        mItemTitles = getResources().getStringArray(R.array.tablayout);
        itemMap = new HashMap<>();
        itemMap.put(getResources().getString(R.string.tablayout_base_user), TabLayoutActivity.class);
        itemMap.put(getResources().getString(R.string.display_icon), TbCustomeTabViewActivity.class);
        itemMap.put(getResources().getString(R.string.tablayout_custome_tab), TbCustomeTabViewActivity.class);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, itemMap.get(mItemTitles[position]));
        if (mItemTitles[position].equals(getResources().getString(R.string.display_icon))) {
            intent.putExtra(Constant.JUMP_FLAG, "1");
        } else if (mItemTitles[position].equals(getResources().getString(R.string.display_icon))) {
            intent.putExtra(Constant.JUMP_FLAG, "2");
        }
        startActivity(intent);
    }
}
