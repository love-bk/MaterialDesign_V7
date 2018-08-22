package com.gjj.gd.materialdesign_v7.recyclerview.other;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gjj.gd.materialdesign_v7.R;

/**
 * Created by gaojuanjuan on 2018/3/1.
 */

public class MyItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDrawable;
    private int space;

    public MyItemDecoration(Context context,int space) {
        mDrawable = context.getResources().getDrawable(R.drawable.item_decoration);
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0,0,0,mDrawable.getIntrinsicHeight());
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;
        int position = parent.getChildAdapterPosition(view);
        if (position == 0){
            outRect.top = space;
        }
    }
}
