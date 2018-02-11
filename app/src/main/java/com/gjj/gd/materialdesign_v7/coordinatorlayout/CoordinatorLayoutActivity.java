package com.gjj.gd.materialdesign_v7.coordinatorlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gjj.gd.materialdesign_v7.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CoordinatorLayoutActivity extends AppCompatActivity {

    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
        ButterKnife.bind(this);
        setTitle(R.string.coordinatorlayout_study);
    }

    @OnClick({R.id.tv_behavior1,R.id.tv_snackbar,R.id.tv_appbarlayout})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.tv_behavior1:
                mIntent = new Intent(this,BehaviorInstance1Activity.class);
                break;
            case R.id.tv_snackbar:
                mIntent = new Intent(this,CombineSnackbarActivity.class);
                break;
             case R.id.tv_appbarlayout:
                mIntent = new Intent(this,TestActivity.class);
                break;


        }
        if (mIntent != null)
            startActivity(mIntent);
    }
}
