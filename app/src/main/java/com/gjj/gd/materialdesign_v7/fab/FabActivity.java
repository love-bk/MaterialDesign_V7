package com.gjj.gd.materialdesign_v7.fab;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.gjj.gd.materialdesign_v7.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FabActivity extends AppCompatActivity {

    @BindView(R.id.coll)
    CollapsingToolbarLayout mColl;
    @BindView(R.id.appbarlayout)
    AppBarLayout mAppbarlayout;
    @BindView(R.id.fab2)
    FloatingActionButton mFab2;
    @BindView(R.id.fab1)
    FloatingActionButton mFab1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);
        ButterKnife.bind(this);
        mColl.setTitle("詹妮弗·劳伦斯");


    }

    @OnClick({R.id.fab2, R.id.fab1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab2:
                break;
            case R.id.fab1:
                Snackbar.make(view,"SnackBar",Snackbar.LENGTH_LONG).show();
                break;
        }
    }
}
