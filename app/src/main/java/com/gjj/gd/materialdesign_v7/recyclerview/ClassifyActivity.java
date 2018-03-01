package com.gjj.gd.materialdesign_v7.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.gjj.gd.materialdesign_v7.R;
import com.gjj.gd.materialdesign_v7.bean.TagBean;
import com.gjj.gd.materialdesign_v7.recyclerview.adapter.ClassifyAdapter;
import com.gjj.gd.materialdesign_v7.recyclerview.listener.ItemDragHelperCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClassifyActivity extends AppCompatActivity {


    @BindView(R.id.recy)
    RecyclerView mRecy;
    private List<TagBean> items = new ArrayList<>();
    private List<TagBean> otherItems = new ArrayList<>();
    private ClassifyAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify);
        ButterKnife.bind(this);
        initData();
        init();
    }

    private void initData() {
        items.add(new TagBean("推荐", 1));
        items.add(new TagBean("视频", 2));
        items.add(new TagBean("图片", 3));
        items.add(new TagBean("娱乐", 4));
        items.add(new TagBean("问答", 5));
        items.add(new TagBean("热点", 6));
        items.add(new TagBean("科技", 7));
        items.add(new TagBean("军事", 8));
        items.add(new TagBean("体育", 9));
        items.add(new TagBean("段子", 10));
        items.add(new TagBean("视频", 2));
        items.add(new TagBean("图片", 3));
        items.add(new TagBean("娱乐", 4));
        items.add(new TagBean("问答", 5));
        items.add(new TagBean("热点", 6));
        items.add(new TagBean("科技", 7));
        items.add(new TagBean("军事", 8));
        items.add(new TagBean("体育", 9));
        items.add(new TagBean("段子", 10));

        otherItems.add(new TagBean("小说", 1));
        otherItems.add(new TagBean("时尚", 2));
        otherItems.add(new TagBean("历史", 3));
        otherItems.add(new TagBean("育儿", 4));
        otherItems.add(new TagBean("搞笑", 5));
        otherItems.add(new TagBean("数码", 6));
        otherItems.add(new TagBean("养生", 7));
        otherItems.add(new TagBean("电影", 8));
        otherItems.add(new TagBean("手机", 9));
        otherItems.add(new TagBean("旅游", 10));
        otherItems.add(new TagBean("时尚", 2));
        otherItems.add(new TagBean("历史", 3));
        otherItems.add(new TagBean("育儿", 4));
        otherItems.add(new TagBean("搞笑", 5));
        otherItems.add(new TagBean("数码", 6));
        otherItems.add(new TagBean("养生", 7));
        otherItems.add(new TagBean("电影", 8));
        otherItems.add(new TagBean("手机", 9));
        otherItems.add(new TagBean("旅游", 10));
    }


    private void init() {


        GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecy.setLayoutManager(manager);

        ItemDragHelperCallback callback = new ItemDragHelperCallback();
        final ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mRecy);

        adapter = new ClassifyAdapter(this, helper, items, otherItems, 1);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                return viewType == ClassifyAdapter.TYPE_MY || viewType == ClassifyAdapter.TYPE_OTHER ? 1 : 4;
            }
        });
        mRecy.setAdapter(adapter);
        adapter.setOnMyChannelItemClickListener(new ClassifyAdapter.OnMyChannelItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(ClassifyActivity.this, "要跳转了", Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setmCompleteListener(new ClassifyAdapter.OnCompleteListener() {
            @Override
            public void onComplete(List<TagBean> list) {
                Toast.makeText(ClassifyActivity.this, "完成了", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
