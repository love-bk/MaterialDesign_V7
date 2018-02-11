package com.gjj.gd.materialdesign_v7.toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gjj.gd.materialdesign_v7.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToolBarActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        ButterKnife.bind(this);
        setTitle(R.string.toolbar_study);
    }

    @OnClick({R.id.toolbar_btn, R.id.zhifu_btn, R.id.toolbar_btn01, R.id.toolbar_btn02, R.id.toolbar_btn03})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_btn:
                intent = new Intent(this, JichuActivity.class);
                break;
            case R.id.zhifu_btn:
                intent = new Intent(this, ZhifuActivity.class);
                break;
            case R.id.toolbar_btn01:
                intent = new Intent(this, ToolbarInstance1Activity.class);
                break;
            case R.id.toolbar_btn02:
                intent = new Intent(this, ToolbarInstance2Activity.class);
                break;
            case R.id.toolbar_btn03:
                intent = new Intent(this, ToolbarInstance3Activity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
