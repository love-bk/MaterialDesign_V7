package com.gjj.gd.materialdesign_v7.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gjj.gd.materialdesign_v7.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddRemoveItemAdapter extends RecyclerView.Adapter<AddRemoveItemAdapter.AddRemoveItemViewHolder> {
    private Context mContext;
    private List<String> data;

    public AddRemoveItemAdapter(Context context, List<String> data) {
        mContext = context;
        this.data = data;
    }

    @Override
    public AddRemoveItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_add_remove, parent, false);
        return new AddRemoveItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AddRemoveItemViewHolder holder, final int position) {
        holder.tvGoods.setText(data.get(position));
        holder.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rmoveData(position);
            }
        });
    }

    private void rmoveData(int position) {
        data.remove(position);
        //删除动画
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());//必须添加这一行，否则删除会有问题
    }

    public void  addData(int position){
        data.add(position,"我是商品"+data.size());
        //添加动画
        notifyItemInserted(position);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class AddRemoveItemViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_goods)
        TextView tvGoods;
        @BindView(R.id.tv_delete)
        TextView tvDelete;

        AddRemoveItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
