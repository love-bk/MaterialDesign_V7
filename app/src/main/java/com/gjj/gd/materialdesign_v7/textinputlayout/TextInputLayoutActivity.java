package com.gjj.gd.materialdesign_v7.textinputlayout;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.gjj.gd.materialdesign_v7.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TextInputLayoutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);
        ButterKnife.bind(this);
        setTitle("TextInputLayout的学习");
    }

}
