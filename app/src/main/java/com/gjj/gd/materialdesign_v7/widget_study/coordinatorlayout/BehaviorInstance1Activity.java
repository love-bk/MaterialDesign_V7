package com.gjj.gd.materialdesign_v7.widget_study.coordinatorlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.gjj.gd.materialdesign_v7.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BehaviorInstance1Activity extends AppCompatActivity {

    @BindView(R.id.btn)
    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior_instance1);
        ButterKnife.bind(this);
        mBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE){
                    v.setX(event.getRawX()-v.getWidth()/2);
                    v.setY(event.getRawY() - v.getHeight()/2);
                }
                return true;
            }
        });
    }
}
