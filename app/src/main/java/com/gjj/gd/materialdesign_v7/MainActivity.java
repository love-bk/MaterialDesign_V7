package com.gjj.gd.materialdesign_v7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.gjj.gd.materialdesign_v7.appbarlayout.AppbarLayoutActivity;
import com.gjj.gd.materialdesign_v7.cardview.CardViewActivity;
import com.gjj.gd.materialdesign_v7.constraintlayout.ConstraintlayoutActivity;
import com.gjj.gd.materialdesign_v7.coordinatorlayout.CoordinatorLayoutActivity;
import com.gjj.gd.materialdesign_v7.fab.FabActivity;
import com.gjj.gd.materialdesign_v7.recyclerview.ClassifyActivity;
import com.gjj.gd.materialdesign_v7.recyclerview.RecyclerViewMainActivity;
import com.gjj.gd.materialdesign_v7.snackbar.SnackBarActivity;
import com.gjj.gd.materialdesign_v7.tablayout.AllTabLayoutActivity;
import com.gjj.gd.materialdesign_v7.textinputlayout.TextInputLayoutActivity;
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
            R.id.constraintlayout_tv01,R.id.tv_appbar,R.id.tv_til,
            R.id.color_tv,R.id.tv_snackbar,R.id.tv_cardview,R.id.tv_fab,R.id.tv_rv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_rv:
                intent = new Intent(this, RecyclerViewMainActivity.class);
                break;
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
            case R.id.tv_fab:
                intent = new Intent(this, FabActivity.class);
                break;
            case R.id.tv_appbar:
                intent = new Intent(this, AppbarLayoutActivity.class);
                break;
            case R.id.tv_til:
                intent = new Intent(this, TextInputLayoutActivity.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
