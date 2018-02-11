package com.gjj.gd.materialdesign_v7.tablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gjj.gd.materialdesign_v7.Constant;
import com.gjj.gd.materialdesign_v7.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AllTabLayoutActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tab_layout);
        ButterKnife.bind(this);
        setTitle(R.string.tablayout_study);
    }

    @OnClick({R.id.tablayout_btn01, R.id.tablayout_btn02, R.id.tablayout_btn03})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tablayout_btn01:
                intent = new Intent(this, TabLayoutActivity.class);
                break;
            case R.id.tablayout_btn02:
                intent = new Intent(this, TbCustomeTabViewActivity.class);
                intent.putExtra(Constant.JUMP_FLAG,"1");
                break;
            case R.id.tablayout_btn03:
                intent = new Intent(this, TbCustomeTabViewActivity.class);
                intent.putExtra(Constant.JUMP_FLAG,"2");
                break;
        }

        if (intent != null)
            startActivity(intent);
    }
}
