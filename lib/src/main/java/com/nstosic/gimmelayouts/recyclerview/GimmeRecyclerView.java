package com.nstosic.gimmelayouts.recyclerview;

/**
 * Created by nstosic on 3/14/17.
 */

public interface GimmeRecyclerView <T> {
    boolean fireRequest();
    void setUrl(String url);
    String getUrl();
    void setAutofire(boolean autofire);
    boolean isAutofire();
}
