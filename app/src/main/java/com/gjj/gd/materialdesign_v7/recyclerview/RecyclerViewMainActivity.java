package com.gjj.gd.materialdesign_v7.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gjj.gd.materialdesign_v7.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerViewMainActivity extends AppCompatActivity {

    private Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rv_1, R.id.rv_2,R.id.rv_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rv_1:
                mIntent = new Intent(RecyclerViewMainActivity.this,ClassifyActivity.class);
                break;
            case R.id.rv_2:
                mIntent = new Intent(RecyclerViewMainActivity.this,RefreshAndLoadMoreActivity.class);
                break;
            case R.id.rv_3:
                mIntent = new Intent(RecyclerViewMainActivity.this,HeaderAndFooterActivity.class);
                break;
        }

        if (mIntent != null){
            startActivity(mIntent);
        }
    }
}
