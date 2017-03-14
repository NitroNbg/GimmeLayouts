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

    private String url;
    private String child_layout;
    private List<T> list;

    public GimmeRecyclerView(Context context) {
        this(context, null);
    }

    public GimmeRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, android.R.style.Theme_Holo);
    }

    public GimmeRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if(!attrs.getAttributeValue("com.nstosic", "url").isEmpty()) {
            url = attrs.getAttributeValue("com.nstosic", "url");
        }
        if(!attrs.getAttributeValue("com.nstosic", "child_layout").isEmpty()) {
            child_layout = attrs.getAttributeValue("com.nstosic", "child_layout");
        }
    }

    public GimmeRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle, String url, String child_layout) {
        super(context, attrs, defStyle);
        this.url = url;
        this.child_layout = child_layout;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getChild_layout() {
        return child_layout;
    }

    public void setChild_layout(String child_layout) {
        this.child_layout = child_layout;
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
