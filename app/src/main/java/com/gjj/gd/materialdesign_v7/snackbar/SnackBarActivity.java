package com.gjj.gd.materialdesign_v7.snackbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gjj.gd.materialdesign_v7.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SnackBarActivity extends AppCompatActivity {
    private Snackbar snackbar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.snackbar1, R.id.snackbar2, R.id.snackbar3,R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.snackbar1:
                Snackbar.make(view,"我是普通的Snackbar",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.snackbar2:
                Snackbar.make(view,"还有两天就要回家过年了",Snackbar.LENGTH_LONG)
                        .setAction("右侧按钮", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(SnackBarActivity.this, "点击了Snackbar右侧的按钮", Toast.LENGTH_SHORT).show();
                            }
                        }).show();

                break;
            case R.id.snackbar3:
                Snackbar snackbar = Snackbar.make(view, "还有两天就要回家过年了", Snackbar.LENGTH_LONG)
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
                break;
            case R.id.fab:
                Snackbar.make(view, "结合CoordinatorLayout使用", Snackbar.LENGTH_LONG).show();
                break;

        }
    }
}
