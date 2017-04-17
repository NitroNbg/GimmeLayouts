package com.nstosic.gimmelayouts.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.nstosic.gimmelayouts.GimmeLayouts;
import com.nstosic.gimmelayouts.R;
import com.nstosic.gimmelayouts.errors.GimmeRecyclerViewException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nstosic on 3/14/17.
 */

public class GimmeRecyclerViewHolderImpl<T> extends GimmeRecyclerViewHolder {
    private HashMap<Integer, View> items;

    public GimmeRecyclerViewHolderImpl(View itemView) {
        super(itemView);
        items = new HashMap<>();
    }

    @Override
    void bindView(View view) {
        if (!(view instanceof ViewGroup)) {
            throw new GimmeRecyclerViewException("GimmeRecyclerView::bindView - actual parameter isn't a ViewGroup");
        }
        ViewGroup container = (ViewGroup)view;
        int childCount = container.getChildCount();
        for(int i = 0; i < childCount; i++) {
            View child = container.getChildAt(i);
            items.put(child.getId(), child);
        }
        
    }
}
