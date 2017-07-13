package com.nstosic.gimmelayouts;

import android.content.Context;
import android.view.View;

import com.nstosic.gimmelayouts.recyclerview.GimmeRecyclerView;
import com.nstosic.gimmelayouts.recyclerview.GimmeRecyclerViewImpl;

/**
 * Created by nstosic on 9/8/16.
 */
public class GimmeLayouts {
    public static <T> GimmeRecyclerView<T> generateRecyclerView(Context ctx, String url, int layout) {
        return generateRecyclerView(ctx, url, layout, false);
    }

    public static <T> GimmeRecyclerView<T> generateRecyclerView(Context ctx, String url, int layout, boolean autostart) {
        GimmeRecyclerView<T> recyclerView = new GimmeRecyclerViewImpl<T>(ctx);
        recyclerView.setUrl(url);
        return recyclerView;
    }

    public static View generate(LayoutType type, String resourceId) {
        return null;
    }

}
