package com.nstosic.gimmelayouts;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by nstosic on 9/12/16.
 */
public class GimmeRecyclerView<T> extends RecyclerView {

    public GimmeRecyclerView(Context context) {
        this(context, null);
    }

    public GimmeRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, null, android.R.style.Theme_Holo);
    }

    public GimmeRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private class GimmeRecyclerViewAdapter<T> extends RecyclerView.Adapter {

        private List<T> list;

        public GimmeRecyclerViewAdapter() {
            list = new LinkedList<>();
        }

        public GimmeRecyclerViewAdapter(List<T> list) {
            this.list = list;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            if(list == null) {
                throw new NullPointerException(this.getClass().getCanonicalName() + " list not initialized!");
            }
            else if(position < 0 || position > list.size()) {
                throw new ArrayIndexOutOfBoundsException(String.format("Cannot get element %d of %s list. The list contains %d element(s).", position, this.getClass().getCanonicalName(), this.list.size()));
            }
            else {
                //Regular case - handle data-to-view binding
            }
        }

        @Override
        public int getItemCount() {
            if(list == null) {
                Log.w(Constants.TAG, this.getClass().getCanonicalName() + ".getItemCount() method called before initializing the list with data.");
                return 0;
            }
            return list.size();
        }
    }
}
