package com.nstosic.gimmelayouts.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

import com.nstosic.gimmelayouts.Constants;
import com.nstosic.gimmelayouts.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by nstosic on 9/12/16.
 */
public class GimmeRecyclerViewImpl<T> extends RecyclerView implements GimmeRecyclerView {
    private boolean autofire;
    private String url;
    private com.nstosic.gimmelayouts.recyclerview.GimmeRecyclerViewAdapter adapter;

    public GimmeRecyclerViewImpl(Context context) {
        this(context, null);
    }

    public GimmeRecyclerViewImpl(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, android.R.style.Theme_Holo);
    }

    public GimmeRecyclerViewImpl(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        adapter = new GimmeRecyclerViewAdapterImpl<T>(context, new LinkedList<T>());
        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.GimmeRecyclerViewImpl, 0, 0);
        try {
            autofire = attributes.getBoolean(R.styleable.GimmeRecyclerViewImpl_autofire, false);
            url = attributes.getString(R.styleable.GimmeRecyclerViewImpl_url);
            String child_layout = attributes.getString(R.styleable.GimmeRecyclerViewImpl_child_layout);

        }
        finally {
            attributes.recycle();
        }

    }

    public GimmeRecyclerViewImpl(Context context, @Nullable AttributeSet attrs, int defStyle, String url) {
        super(context, attrs, defStyle);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isAutofire() {
        return autofire;
    }

    @Override
    public void setAutofire(boolean autofire) {
        this.autofire = autofire;
    }

    //MARK - GimmeRecyclerView methods

    @Override
    public boolean fireRequest() {
        if (getContext() == null) {
            Log.e(Constants.TAG, "GimmeRecyclerView " + this + " doesn't have valid Context, unable to fetch network data");
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            Log.e(Constants.TAG, "No ConnectivityManager found, unable to fetch network data");
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            Log.e(Constants.TAG, "No active connection found on this device, unable to fetch network data");
            return false;
        }
        if (!activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnectedOrConnecting()) {
            Log.e(Constants.TAG, "Device doesn't have active internet connection, unable to fetch network data");
            return false;
        }
        //TODO Fetch network data from url
        return true;
    }


}
