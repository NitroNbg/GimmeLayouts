package com.nstosic.gimmelayouts;

import com.nstosic.gimmelayouts.recyclerview.GimmeRecyclerViewImpl;

/**
 * Created by nstosic on 9/8/16.
 */
public interface Generator {
    android.support.v7.widget.RecyclerView generateRecyclerView();
    GimmeRecyclerViewImpl generateGimmeRecyclerView();

}
