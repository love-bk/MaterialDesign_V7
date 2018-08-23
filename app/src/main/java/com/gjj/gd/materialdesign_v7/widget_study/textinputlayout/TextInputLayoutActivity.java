package com.gjj.gd.materialdesign_v7.widget_study.textinputlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gjj.gd.materialdesign_v7.BaseActivity;
import com.gjj.gd.materialdesign_v7.R;

import butterknife.ButterKnife;

public class TextInputLayoutActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);
        ButterKnife.bind(this);
        setTitle("TextInputLayout的学习");
    }

}
