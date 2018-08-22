package com.gjj.gd.materialdesign_v7.widget_study.snackbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gjj.gd.materialdesign_v7.R;
import com.gjj.gd.materialdesign_v7.adapter.ItemAdapter;
import com.gjj.gd.materialdesign_v7.widget_study.toolbar.JichuActivity;
import com.gjj.gd.materialdesign_v7.widget_study.toolbar.ToolbarInstance1Activity;
import com.gjj.gd.materialdesign_v7.widget_study.toolbar.ZhifuActivity;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SnackBarActivity extends AppCompatActivity implements ItemAdapter.OnItemClickListener {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private Snackbar snackbar3;
    private ItemAdapter mItemAdapter;
    private String[] mItemTitles;
    private HashMap<String, Class> itemMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
        ButterKnife.bind(this);
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mItemAdapter = new ItemAdapter(this, mItemTitles);
        mItemAdapter.setListener(this);
        recyclerView.setAdapter(mItemAdapter);
    }

    private void initData() {
        mItemTitles = getResources().getStringArray(R.array.snackbar);
        itemMap = new HashMap<>();
        itemMap.put(getResources().getString(R.string.snackbar_bg_color), JichuActivity.class);
        itemMap.put(getResources().getString(R.string.snackbar_ordinary), ZhifuActivity.class);
        itemMap.put(getResources().getString(R.string.snackbar_with_button), ToolbarInstance1Activity.class);
    }

    @OnClick({ R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab:
                Snackbar.make(view, "结合CoordinatorLayout使用", Snackbar.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onItemClick(int position) {
        if (mItemTitles[position].equals(getResources().getString(R.string.snackbar_with_button))){
            Snackbar.make(recyclerView, "还有两天就要回家过年了", Snackbar.LENGTH_LONG)
                    .setAction("右侧按钮", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(SnackBarActivity.this, "点击了Snackbar右侧的按钮", Toast.LENGTH_SHORT).show();
                        }
                    }).show();

        }else if (mItemTitles[position].equals(getResources().getString(R.string.snackbar_ordinary))){
            Snackbar.make(recyclerView, "我是普通的Snackbar", Snackbar.LENGTH_SHORT).show();
        }else {
            Snackbar snackbar = Snackbar.make(recyclerView, "还有两天就要回家过年了", Snackbar.LENGTH_LONG)
                    .setAction("右侧按钮", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(SnackBarActivity.this, "点击了Snackbar右侧的按钮", Toast.LENGTH_SHORT).show();
                        }
                    });
            //获取Snackbar的view
            View snackbarView = snackbar.getView();
            snackbarView.setBackgroundColor(Color.parseColor("#1E8AE8"));
            //改变文字颜色
            ((TextView) snackbarView.findViewById(R.id.snackbar_text)).setTextColor(Color.RED);
            //改变右侧按钮的字体颜色
            Button rightBtn = ((Button) snackbarView.findViewById(R.id.snackbar_action));
            rightBtn.setTextColor(Color.RED);
            snackbar.show();
        }
    }
}
