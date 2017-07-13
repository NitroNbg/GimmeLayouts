package com.nstosic.gimmelayouts.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nstosic.gimmelayouts.Constants;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by nstosic on 3/14/17.
 */

public class GimmeRecyclerViewAdapterImpl<T> extends RecyclerView.Adapter<GimmeRecyclerViewHolder<T>> implements GimmeRecyclerViewAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<T> list;
    private int child_layout;

    public GimmeRecyclerViewAdapterImpl(Context context) {
        this(context, LayoutInflater.from(context), new LinkedList<T>());
    }

    public GimmeRecyclerViewAdapterImpl(Context context, List<T> list) {
        this(context, LayoutInflater.from(context), list);
    }

    public GimmeRecyclerViewAdapterImpl(Context context, LayoutInflater inflater, List<T> list) {
        this.context = context;
        this.inflater = inflater;
        this.list = list;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public LayoutInflater getInflater() {
        return inflater;
    }

    public void setInflater(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getChildLayout() {
        return child_layout;
    }

    public void setChildLayout(int child_layout) {
        this.child_layout = child_layout;
    }

    @Override
    public GimmeRecyclerViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context.getResources().getLayout(child_layout) == null) {
            Log.e(Constants.TAG, "GimmeRecyclerViewAdapter's child_layout does not reference a valid layout file. Unable to create GimmeRecyclerView");
        }
        View view = inflater.inflate(child_layout, parent, false);
        GimmeRecyclerViewHolder<T> holder = new GimmeRecyclerViewHolderImpl<T>(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(GimmeRecyclerViewHolder<T> holder, int position) {
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
