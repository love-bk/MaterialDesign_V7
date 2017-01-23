package com.gjj.gd.materialdesign_v7.toolbar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gjj.gd.materialdesign_v7.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {


    private static final String KEY_TITLE = "key_title";
    private String mTitle;
    public ContentFragment() {
        // Required empty public constructor
    }

    public static ContentFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString(KEY_TITLE,title);
        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        TextView tv = (TextView) view.findViewById(R.id.menu_title);
        String title = (String) getArguments().get(KEY_TITLE);
        if (!TextUtils.isEmpty(title)) {
            tv.setText(title);
        }
        return view;
    }

}
