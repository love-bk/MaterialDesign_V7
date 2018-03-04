package com.gjj.gd.materialdesign_v7.recyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.gjj.gd.materialdesign_v7.R;
import com.gjj.gd.materialdesign_v7.recyclerview.adapter.RefreshLoadMoreAdpater;
import com.gjj.gd.materialdesign_v7.recyclerview.other.MyItemDecoration;
import com.gjj.gd.materialdesign_v7.recyclerview.view.RefreshLoadMaoreRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RefreshAndLoadMoreActivity extends AppCompatActivity {

    @BindView(R.id.custom_rv)
    RefreshLoadMaoreRecyclerView mRecyclerView;

    private RecyclerView.Adapter adapter;
    private ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_and_load_more);
        ButterKnife.bind(this);
        setTitle("下拉刷新，上拉加载更多");

//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));

        list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3434000068,2874621746&fm=116&gp=0.jpg");

        adapter = new RefreshLoadMoreAdpater(this, list);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new MyItemDecoration(this,10));

        //下拉刷新的监听
        mRecyclerView.setPullToRefreshListener(new RefreshLoadMaoreRecyclerView.PullToRefreshListener() {
            @Override
            public void onRefreshing() {
                refreshData();
            }
        });
        //上拉加载更多的监听
        mRecyclerView.setLoadMoreListener(new RefreshLoadMaoreRecyclerView.LoadMoreListener() {
            @Override
            public void onLoadMore() {
                loadMoreData();
            }
        });

    }

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1){
                for (int i = 0; i < 2; i++)
                    list.add(0, "http://img15.3lian.com/2015/a1/16/d/202.jpg");
                //刷新完成
                mRecyclerView.setRefreshComplete();
            }
            if (msg.what == 2){
                for (int i = 0; i < 2; i++)
                    list.add("http://img15.3lian.com/2015/a1/16/d/202.jpg");
                //加载更多完成
                mRecyclerView.setLoadMoreComplete();
            }
        }
    };

    public void refreshData(){
        mHandler.sendEmptyMessageDelayed(1,3000);
    }

    public void loadMoreData(){
        mHandler.sendEmptyMessageDelayed(2,3000);
    }

}

