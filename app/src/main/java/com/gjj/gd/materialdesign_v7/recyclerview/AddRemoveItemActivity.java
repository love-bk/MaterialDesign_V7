package com.gjj.gd.materialdesign_v7.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gjj.gd.materialdesign_v7.R;
import com.gjj.gd.materialdesign_v7.anim.CustomItemAnimator;
import com.gjj.gd.materialdesign_v7.recyclerview.adapter.AddRemoveItemAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddRemoveItemActivity extends AppCompatActivity {

    @BindView(R.id.rv_goods_list)
    RecyclerView rvGoodsList;

    private List<String> list = new ArrayList<>();
    private AddRemoveItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_remove_item);
        ButterKnife.bind(this);

        list.add("我是商品0");
        list.add("我是商品1");
        mAdapter = new AddRemoveItemAdapter(this, list);
        rvGoodsList.setLayoutManager(new LinearLayoutManager(this));
        rvGoodsList.setAdapter(mAdapter);

        //默认动画
//        DefaultItemAnimator itemAnimator = new DefaultItemAnimator();
        CustomItemAnimator itemAnimator = new CustomItemAnimator();
        itemAnimator.setAddDuration(500);
        itemAnimator.setRemoveDuration(500);

        rvGoodsList.setItemAnimator(itemAnimator);

    }

    @OnClick(R.id.ll_add_goods)
    public void onViewClicked() {
        mAdapter.addData(list.size());
    }
}
