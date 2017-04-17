package com.nstosic.gimmelayouts.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by nstosic on 3/14/17.
 */

public abstract class GimmeRecyclerViewHolder<T> extends RecyclerView.ViewHolder {
    public GimmeRecyclerViewHolder(View itemView) {
        super(itemView);
    }
    abstract void bindView(View view);
}
