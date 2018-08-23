package com.gjj.gd.materialdesign_v7.widget_study.coordinatorlayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gjj.gd.materialdesign_v7.BaseActivity;
import com.gjj.gd.materialdesign_v7.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CombineSnackbarActivity extends BaseActivity {

    @BindView(R.id.fab)
    FloatingActionButton mFab;
    private Snackbar mSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combine_snackbar);
        ButterKnife.bind(this);
        mFab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mSnackbar == null){
                    mSnackbar = Snackbar.make(v,"快来往这边看，哈哈哈",Snackbar.LENGTH_LONG).setAction("cancel", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                }
                if (mSnackbar.isShown())
                    mSnackbar.dismiss();
                else {
                    mSnackbar.show();
                }
            }
        });
    }


}
