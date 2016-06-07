package com.gjevass.pixels.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        float density = displayMetrics.density;
        System.out.println("width " + width);
        System.out.println("height " + height);
        System.out.println("density " + density);

        ListView listView = (ListView) findViewById(R.id.listView);

        List<Bitmap> bitmapList = new ArrayList<Bitmap>();

        Bitmap bitmap1 = BitmapFactory.decodeResource(this.getResources(),R.drawable.main_part_1);
        Bitmap bitmap2 = BitmapFactory.decodeResource(this.getResources(),R.drawable.test_pst);

        int realHeight = Math.round(bitmap1.getHeight() / density);
        int realWidth = Math.round(bitmap1.getWidth() / density);
        int densityHeight = bitmap1.getHeight();
        int densityWidth = bitmap1.getWidth();

        System.out.println("realHeight " + realHeight);
        System.out.println("realWidth " + realWidth);
        System.out.println("densityHeight " + densityHeight);
        System.out.println("densityWidth " + densityWidth);

        Bitmap bitmap1Scalled;
        Bitmap bitmap2Scalled;

        if(realWidth > width) {
            System.out.println("realWidth > width");
            bitmap1Scalled = Bitmap.createScaledBitmap(bitmap1, realWidth, realHeight, true);
            bitmap2Scalled = Bitmap.createScaledBitmap(bitmap2, realWidth, realHeight, true);
        } else {
            System.out.println("realWidth < width");
            bitmap1Scalled = Bitmap.createScaledBitmap(bitmap1, 320, 966, true);
            //bitmap1Scalled = Bitmap.createScaledBitmap(bitmap1, width, realHeight, true);
            bitmap2Scalled = Bitmap.createScaledBitmap(bitmap2, 90, 128, true);
            //bitmap2Scalled = Bitmap.createScaledBitmap(bitmap2, 212, 300, true);
        }



        ElementImage elementImage0 = new ElementImage(130, 617, 3, 1 / 2.34f, R.drawable.test_pst, this);
        ElementImage elementImage1 = new ElementImage(334, 677, -1, 1 / 2.34f, R.drawable.test_pst, this);

        List<ElementImage> elementImageList = new ArrayList<ElementImage>();
        elementImageList.add(elementImage0);
        elementImageList.add(elementImage1);
        
        bitmapList.add(bitmap1Scalled);
        bitmapList.add(bitmap2Scalled);

        Adapter adapter = new Adapter(this, bitmapList, elementImageList);
        listView.setAdapter(adapter);
    }
}
