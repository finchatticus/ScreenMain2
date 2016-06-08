package com.gjevass.pixels.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.gjevass.pixels.app.util.DisplayUtil;
import com.gjevass.pixels.app.util.ImageUtil;

public class BackgroundImage {
    private int marginTop;
    private int marginBottom;
    private int resourceId;
    private float scaleFactor;
    private Bitmap bitmap;
    private Context context;

    public BackgroundImage(int resourceId, int marginTop, int marginBottom, Context context) {
        this.resourceId = resourceId;
        this.marginBottom = marginBottom;
        this.marginTop = marginTop;

        DisplayUtil displayUtil = new DisplayUtil(context);
        ImageUtil imageUtil = new ImageUtil(resourceId, context);

        int imageWidth = imageUtil.getRealWidth();
        int imageHeight = imageUtil.getRealHeight();
/*        int displayWidth = displayUtil.getWidth();
        int displayHeight = displayUtil.getHeight();*/

        //my
/*        int displayWidth = 800;
        int displayHeight = 1216;*/

        //sem
        int displayWidth = 320;
        int displayHeight = 480;

        //fullHD
/*        int displayWidth = 1080;
        int displayHeight = 1920;*/

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);

        if(displayWidth < imageWidth) {
            float scale = imageHeight / (float)imageWidth;
            int scalledImageWidth = displayWidth;
            int scalledImageHeight = Math.round(displayWidth * scale);
            this.scaleFactor = ((float)displayWidth / (float) imageWidth);
            this.bitmap = Bitmap.createScaledBitmap(bitmap, scalledImageWidth, scalledImageHeight, true);
        }
        else {
            this.scaleFactor = displayWidth / (float) imageWidth;
            int scalledImageWidth = displayWidth;
            int scalledImageHeight = Math.round(imageHeight * this.scaleFactor);
            this.bitmap = Bitmap.createScaledBitmap(bitmap, scalledImageWidth, scalledImageHeight, true);
        }

    }

    public int getMarginTop() {
        return marginTop;
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    public int getResourceId() {
        return resourceId;
    }

    public float getScaleFactor() {
        return scaleFactor;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setMarginTop(int marginTop) {
        System.out.println("set margin top " + marginTop);
        this.marginTop = marginTop;
    }

    public void setMarginBottom(int marginBottom) {
        System.out.println("set margin bottom " + marginTop);
        this.marginBottom = marginBottom;
    }

    @Override
    public String toString() {
        return "BackgroundImage{" +
                "marginTop=" + marginTop +
                ", marginBottom=" + marginBottom +
                ", resourceId=" + resourceId +
                ", scaleFactor=" + scaleFactor +
                '}';
    }
}
