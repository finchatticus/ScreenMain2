package com.gjevass.pixels.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class Part1 {

    private int width;
    private int height;
    private int x;
    private int y;
    private float rotation;
    private float scaleFactorCoord;
    private float scaleFactorDimension;
    private int resourceId;
    private Bitmap bitmap;
    private Context context;

    public Part1(int x, int y, float rotation, float scaleFactorCoord, float scaleFactorDimension, int resourceId, Context context) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.scaleFactorCoord = scaleFactorCoord;
        this.scaleFactorDimension = scaleFactorDimension;
        this.resourceId = resourceId;
        this.context = context;

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
        calc(bitmap);
    }

    public Part1(int x, int y, float rotation, float scaleFactorCoord, float scaleFactorDimension, Bitmap bitmap, Context context) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.scaleFactorCoord = scaleFactorCoord;
        this.scaleFactorDimension = scaleFactorDimension;
        this.bitmap = bitmap;
        this.context = context;
    }

    private void calc(Bitmap bitmap) {
        this.x = Math.round(this.x * scaleFactorCoord);
        this.y = Math.round(this.y * scaleFactorCoord);

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        float density = displayMetrics.density;

        this.height = Math.round((bitmap.getHeight() / density) * scaleFactorDimension);
        this.width = Math.round((bitmap.getWidth() / density) * scaleFactorDimension);

        this.bitmap = Bitmap.createScaledBitmap(bitmap, this.width, this.height, true);
    }

    @Override
    public String toString() {
        return "Part1{" +
                "width=" + width +
                ", height=" + height +
                ", x=" + x +
                ", y=" + y +
                ", rotation=" + rotation +
                ", scaleFactorCoord=" + scaleFactorCoord +
                ", scaleFactorDimension=" + scaleFactorDimension +
                ", resourceId=" + resourceId +
                ", bitmap=" + bitmap +
                ", context=" + context +
                '}';
    }
}
