package com.nstosic.gimmelayouts;

/**
 * Created by nstosic on 9/8/16.
 */
public enum LayoutType {
    TEXT_VIEW,
    IMAGE_VIEW;

    public String toString() {
        if(this == TEXT_VIEW) {
            return "TextView";
        }
        else if(this == IMAGE_VIEW) {
            return "ImageView";
        }
        return "";
    }
}
