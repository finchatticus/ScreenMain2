package com.gjevass.pixels.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
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

        List<BackgroundImage> listBackground = new ArrayList<BackgroundImage>();
        for (int i = 0; i < 5; i++) {
            listBackground.add(new BackgroundImage(drawables[i], this));
            System.out.println("scale " + listBackground.get(i).getScaleFactor());
        }
        listBackground.get(0).setMarginTop(-1000);
        listBackground.get(4).setMarginBottom(-1000);

        float scaleFactor = listBackground.get(0).getScaleFactor();

        List<ElementImage> elementImageList = new ArrayList<ElementImage>();
        elementImageList.add(new ElementImage(130, 617, 3, scaleFactor, R.drawable.test_pst, this));
        elementImageList.add(new ElementImage(334, 677, -1, scaleFactor, R.drawable.test_pst, this));

        Adapter adapter = new Adapter(this, listBackground, elementImageList);
        listView.setAdapter(adapter);
    }
}
