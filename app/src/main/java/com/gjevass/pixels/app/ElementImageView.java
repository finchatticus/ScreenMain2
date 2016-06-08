package com.gjevass.pixels.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class ElementImageView extends ImageView {

    public ElementImageView(Context context) {
        super(context);
    }

    public ElementImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ElementImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setElementImage(ElementImage elementImage) {
        int marginLeft = elementImage.getX();
        int marginTop = elementImage.getY();
        float rotate = elementImage.getRotation();
        Bitmap bitmap = elementImage.getBitmap();
/*        System.out.println("bitmap_height " + bitmap.getHeight());
        System.out.println("bitmap_width " + bitmap.getWidth());*/

        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(this.getLayoutParams());
        lp.setMargins(marginLeft, marginTop, 0, 0);
        super.setLayoutParams(lp);
        super.setRotation(rotate);
        super.setImageBitmap(bitmap);
    }
}
