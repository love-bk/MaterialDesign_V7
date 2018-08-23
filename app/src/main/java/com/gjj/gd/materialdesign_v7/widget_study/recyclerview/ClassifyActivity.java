package com.gjj.gd.materialdesign_v7.widget_study.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.gjj.gd.materialdesign_v7.BaseActivity;
import com.gjj.gd.materialdesign_v7.R;
import com.gjj.gd.materialdesign_v7.bean.TagBean;
import com.gjj.gd.materialdesign_v7.widget_study.recyclerview.adapter.ClassifyAdapter;
import com.gjj.gd.materialdesign_v7.widget_study.recyclerview.listener.ItemDragHelperCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClassifyActivity extends BaseActivity {


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
        setTitle("拖拽排序，点击删除");
        initData();
        init();
    }

    private void init() {

        GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecy.setLayoutManager(manager);

        ItemDragHelperCallback callback = new ItemDragHelperCallback();
        final ItemTouchHelper helper = new ItemTouchHelper(callback);
        //将ItemTouchHelper和RecyclerView建立关联
        helper.attachToRecyclerView(mRecy);

        adapter = new ClassifyAdapter(this, helper, items, otherItems, 1);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                //从效果可知，当是两个头布局的时候要占据一行
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

        otherItems.add(new TagBean("小说", 11));
        otherItems.add(new TagBean("时尚", 12));
        otherItems.add(new TagBean("历史", 13));
        otherItems.add(new TagBean("育儿", 14));
        otherItems.add(new TagBean("搞笑", 15));
        otherItems.add(new TagBean("数码", 16));
        otherItems.add(new TagBean("养生", 17));
        otherItems.add(new TagBean("电影", 18));
        otherItems.add(new TagBean("手机", 19));
        otherItems.add(new TagBean("旅游", 20));
        otherItems.add(new TagBean("时尚", 21));
        otherItems.add(new TagBean("历史", 22));
        otherItems.add(new TagBean("育儿", 23));
        otherItems.add(new TagBean("搞笑", 24));
        otherItems.add(new TagBean("数码", 25));
        otherItems.add(new TagBean("养生", 26));
        otherItems.add(new TagBean("电影", 27));
        otherItems.add(new TagBean("手机", 28));
        otherItems.add(new TagBean("旅游", 29));
    }
}
