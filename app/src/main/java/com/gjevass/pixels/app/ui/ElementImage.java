package com.gjevass.pixels.app.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.gjevass.pixels.app.util.DisplayUtil;

public class ElementImage {

    private int width;
    private int height;
    private int x;
    private int y;
    private float rotation;
    private float scaleFactor;
    private float scaleFactorDimension;
    private int resourceId;
    private Bitmap bitmap;
    private Context context;

    public ElementImage(int x, int y, float rotation, float scaleFactor, float scaleFactorDimension, int resourceId, Context context) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.scaleFactor = scaleFactor;
        this.scaleFactorDimension = scaleFactorDimension;
        this.resourceId = resourceId;
        this.context = context;

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
        calc(bitmap);
    }

    public ElementImage(int x, int y, float rotation, float scaleFactor, float scaleFactorDimension, Bitmap bitmap, Context context) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.scaleFactor = scaleFactor;
        this.scaleFactorDimension = scaleFactorDimension;
        this.bitmap = bitmap;
        this.context = context;

        calc(bitmap);
    }

    private void calc(Bitmap bitmap) {
        this.x = Math.round(this.x * scaleFactor);
        this.y = Math.round(this.y * scaleFactor);

        DisplayUtil displayUtil = new DisplayUtil(context);
        float density = displayUtil.getDensity();

        this.height = Math.round((bitmap.getHeight() / density) * scaleFactor * scaleFactorDimension);
        this.width = Math.round((bitmap.getWidth() / density) * scaleFactor * scaleFactorDimension);
        this.bitmap = Bitmap.createScaledBitmap(bitmap, this.width, this.height, true);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public float getRotation() {
        return rotation;
    }

    public int getY() {
        return y;
    }

    public float getScaleFactor() {
        return scaleFactor;
    }

    public int getResourceId() {
        return resourceId;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public String toString() {
        return "Part1{" +
                "width=" + width +
                ", height=" + height +
                ", x=" + x +
                ", y=" + y +
                ", rotation=" + rotation +
                ", scaleFactor=" + scaleFactor +
                ", resourceId=" + resourceId +
                ", bitmap=" + bitmap +
                ", context=" + context +
                '}';
    }
}
