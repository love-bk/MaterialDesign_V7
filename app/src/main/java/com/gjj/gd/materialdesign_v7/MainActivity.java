package com.gjj.gd.materialdesign_v7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.WindowManager;

import com.gjj.gd.materialdesign_v7.activity.ComprehensiveExampleActivity;
import com.gjj.gd.materialdesign_v7.adapter.ItemAdapter;
import com.gjj.gd.materialdesign_v7.widget_study.appbarlayout.AppbarLayoutActivity;
import com.gjj.gd.materialdesign_v7.widget_study.cardview.CardViewActivity;
import com.gjj.gd.materialdesign_v7.widget_study.constraintlayout.ConstraintlayoutActivity;
import com.gjj.gd.materialdesign_v7.widget_study.coordinatorlayout.CoordinatorLayoutActivity;
import com.gjj.gd.materialdesign_v7.widget_study.fab.FabActivity;
import com.gjj.gd.materialdesign_v7.widget_study.recyclerview.RecyclerViewMainActivity;
import com.gjj.gd.materialdesign_v7.widget_study.snackbar.SnackBarActivity;
import com.gjj.gd.materialdesign_v7.widget_study.tablayout.AllTabLayoutActivity;
import com.gjj.gd.materialdesign_v7.widget_study.textinputlayout.TextInputLayoutActivity;
import com.gjj.gd.materialdesign_v7.widget_study.toolbar.ToolBarActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements ItemAdapter.OnItemClickListener {
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
