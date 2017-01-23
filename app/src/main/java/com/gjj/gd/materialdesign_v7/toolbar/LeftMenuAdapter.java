package com.gjj.gd.materialdesign_v7.toolbar;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gjj.gd.materialdesign_v7.R;

/**
 * Created by 高娟娟 on 2017/1/23.
 */

public class LeftMenuAdapter extends ArrayAdapter<MenuItem> {
    private final LayoutInflater mInflater;
    private final Context mContext;
    private int mSelected;
    public LeftMenuAdapter(Context context, MenuItem[] objects) {
        super(context, -1,objects);
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_left_menu,parent,false);
        }
        ImageView icon = (ImageView) convertView.findViewById(R.id.item_icon);
        TextView title = (TextView) convertView.findViewById(R.id.item_title);
        title.setText(getItem(position).text);
        icon.setImageResource(getItem(position).icon);
        convertView.setBackgroundColor(Color.TRANSPARENT);
        if (position == mSelected){
            icon.setImageResource(getItem(position).iconSelected);
            convertView.setBackgroundColor(mContext.getResources().getColor(R.color.state_menu_item_selected));
        }
        return convertView;
    }
    public void setSelected(int position) {
        this.mSelected = position;
        notifyDataSetChanged();
    }




}

