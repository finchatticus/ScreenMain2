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
import com.gjevass.pixels.app.util.DisplayUtil;
import com.gjevass.pixels.app.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listView = (ListView) findViewById(R.id.listView);

        int [] drawables = {
                R.drawable.main_part_0,
                R.drawable.main_part_1,
                R.drawable.main_part_2,
                R.drawable.main_part_3,
                R.drawable.main_part_4,
                R.drawable.main_poster_frame,
                R.drawable.main_sticks,
                R.drawable.main_pin,
                R.drawable.main_light
        };

        List<Bitmap> bitmapList = new ArrayList<Bitmap>();

        Bitmap bitmap1 = BitmapFactory.decodeResource(this.getResources(),R.drawable.main_part_1);

        DisplayUtil displayUtil = new DisplayUtil(this);
        System.out.println(displayUtil);
        ImageUtil imageUtil = new ImageUtil(R.drawable.main_part_1, this);
        System.out.println(imageUtil);
        int imageWidth = imageUtil.getRealWidth();
        int imageHeight = imageUtil.getRealHeight();
        //int displayWidth = displayUtil.getWidth();
        //int displayHeight = displayUtil.getHeight();

        //my
        /*int displayWidth = 800;
        int displayHeight = 1216;*/

        //sem
        /*int displayWidth = 320;
        int displayHeight = 480;*/

        //fullHD
        int displayWidth = 1080;
        int displayHeight = 1920;

        float scaleFactor = 1;

        Bitmap bitmap1Scalled;
        ElementImage elementImage0;
        ElementImage elementImage1;

        if(displayWidth < imageWidth) {
            System.out.println("displayWidth < imageWidth");
            float scale = imageHeight / (float)imageWidth;
            int scalledImageWidth = displayWidth;
            int scalledImageHeight = Math.round(displayWidth * scale);
            scaleFactor = ((float)displayWidth / (float) imageWidth);
            bitmap1Scalled = Bitmap.createScaledBitmap(bitmap1, scalledImageWidth, scalledImageHeight, true);

            elementImage0 = new ElementImage(130, 617, 3, scaleFactor, R.drawable.test_pst, this);
            elementImage1 = new ElementImage(334, 677, -1, scaleFactor, R.drawable.test_pst, this);
        }
        else {
            System.out.println("displayWidth > imageWidth");
            float scale = displayWidth / (float) imageWidth;
            int scalledImageWidth = displayWidth;
            int scalledImageHeight = Math.round(imageHeight * scale);
            System.out.println(scale);
            bitmap1Scalled = Bitmap.createScaledBitmap(bitmap1, scalledImageWidth, scalledImageHeight, true);

            elementImage0 = new ElementImage(130, 617, 3, scale, R.drawable.test_pst, this);
            elementImage1 = new ElementImage(334, 677, -1, scale, R.drawable.test_pst, this);
        }

        List<ElementImage> elementImageList = new ArrayList<ElementImage>();
        elementImageList.add(elementImage0);
        elementImageList.add(elementImage1);

        bitmapList.add(bitmap1Scalled);

        Adapter adapter = new Adapter(this, bitmapList, elementImageList);
        listView.setAdapter(adapter);
    }
}
