package com.gjj.gd.materialdesign_v7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.gjj.gd.materialdesign_v7.cardview.CardViewActivity;
import com.gjj.gd.materialdesign_v7.constraintlayout.ConstraintlayoutActivity;
import com.gjj.gd.materialdesign_v7.coordinatorlayout.CoordinatorLayoutActivity;
import com.gjj.gd.materialdesign_v7.snackbar.SnackBarActivity;
import com.gjj.gd.materialdesign_v7.tablayout.AllTabLayoutActivity;
import com.gjj.gd.materialdesign_v7.toolbar.ToolBarActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }


    @OnClick({R.id.tv_col, R.id.tv_toolbar, R.id.tv_tablayout,
            R.id.constraintlayout_tv01,
            R.id.color_tv,R.id.tv_snackbar,R.id.tv_cardview})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_col:
                intent = new Intent(this, CoordinatorLayoutActivity.class);
                break;
            case R.id.tv_toolbar:
                intent = new Intent(this, ToolBarActivity.class);
                break;
            case R.id.tv_tablayout:
                intent = new Intent(this, AllTabLayoutActivity.class);
                break;
            case R.id.constraintlayout_tv01:
                intent = new Intent(this, ConstraintlayoutActivity.class);
                break;
            case R.id.color_tv:
                intent = new Intent(this, ColorPaletteActivity.class);
                break;
            case R.id.tv_snackbar:
                intent = new Intent(this, SnackBarActivity.class);
                break;
            case R.id.tv_cardview:
                intent = new Intent(this, CardViewActivity.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
