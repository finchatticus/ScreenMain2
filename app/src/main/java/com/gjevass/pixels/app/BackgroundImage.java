package com.gjevass.pixels.app;

import android.graphics.Bitmap;

public class BackgroundImage {
    private int marginTop;
    private int marginBottom;
    private int resourceId;
    private Bitmap bitmap;

    public BackgroundImage(int marginTop, int resourceId, int marginBottom) {
        this.marginTop = marginTop;
        this.resourceId = resourceId;
        this.marginBottom = marginBottom;
    }
}
