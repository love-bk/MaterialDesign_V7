package com.gjj.gd.materialdesign_v7.coordinatorlayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gjj.gd.materialdesign_v7.R;

/**
 * Created by gaojuanjuan on 2018/2/10.
 */

public class TestRecyclerViewAdapter extends RecyclerView.Adapter<TestRecyclerViewAdapter.MyViewHolder>{


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.text.setText(""+position);
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text;

        public MyViewHolder(View itemView) {
            super(itemView);
            text = ((TextView) itemView.findViewById(R.id.text));
        }
    }
}
