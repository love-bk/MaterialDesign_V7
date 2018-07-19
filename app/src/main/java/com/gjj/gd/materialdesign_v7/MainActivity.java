package com.gjj.gd.materialdesign_v7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gjj.gd.materialdesign_v7.activity.ComprehensiveExampleActivity;
import com.gjj.gd.materialdesign_v7.adapter.ItemAdapter;
import com.gjj.gd.materialdesign_v7.appbarlayout.AppbarLayoutActivity;
import com.gjj.gd.materialdesign_v7.cardview.CardViewActivity;
import com.gjj.gd.materialdesign_v7.constraintlayout.ConstraintlayoutActivity;
import com.gjj.gd.materialdesign_v7.coordinatorlayout.CoordinatorLayoutActivity;
import com.gjj.gd.materialdesign_v7.fab.FabActivity;
import com.gjj.gd.materialdesign_v7.recyclerview.RecyclerViewMainActivity;
import com.gjj.gd.materialdesign_v7.snackbar.SnackBarActivity;
import com.gjj.gd.materialdesign_v7.tablayout.AllTabLayoutActivity;
import com.gjj.gd.materialdesign_v7.textinputlayout.TextInputLayoutActivity;
import com.gjj.gd.materialdesign_v7.toolbar.ToolBarActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ItemAdapter.OnItemClickListener {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private Intent intent = null;
    private ItemAdapter mAdapter;
    private Map<String,Class> itemMap;
    private String[] itemDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initData();
        itemDatas = getResources().getStringArray(R.array.home_items);
        mAdapter = new ItemAdapter(this, itemDatas);
        mAdapter.setListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        itemMap = new HashMap<>();
        itemMap.put(getResources().getString(R.string.recycler_study),RecyclerViewMainActivity.class);
        itemMap.put(getResources().getString(R.string.til_study),TextInputLayoutActivity.class);
        itemMap.put(getResources().getString(R.string.appbar_study),AppbarLayoutActivity.class);
        itemMap.put(getResources().getString(R.string.fab_study),FabActivity.class);
        itemMap.put(getResources().getString(R.string.cardview_study),CardViewActivity.class);
        itemMap.put(getResources().getString(R.string.coordinatorlayout_study),CoordinatorLayoutActivity.class);
        itemMap.put(getResources().getString(R.string.toolbar_study),ToolBarActivity.class);
        itemMap.put(getResources().getString(R.string.snackbar_study),SnackBarActivity.class);
        itemMap.put(getResources().getString(R.string.tablayout_study),AllTabLayoutActivity.class);
        itemMap.put(getResources().getString(R.string.constraintlayout_study),ConstraintlayoutActivity.class);
        itemMap.put(getResources().getString(R.string.colorpalette),ColorPaletteActivity.class);
        itemMap.put(getResources().getString(R.string.comprehensive_example),ComprehensiveExampleActivity.class);
    }


    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(this,itemMap.get(itemDatas[position])));
    }
}
