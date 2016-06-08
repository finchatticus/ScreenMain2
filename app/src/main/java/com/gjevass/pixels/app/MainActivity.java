package com.gjevass.pixels.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import com.gjevass.pixels.app.json.JSONParser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private Adapter adapter;
    private float scaleFactor;

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
        };

        List<BackgroundImage> listBackground = new ArrayList<BackgroundImage>();
        for (int i = 0; i < 5; i++) {
            listBackground.add(new BackgroundImage(drawables[i], 0, 0, this));
        }
        listBackground.get(0).setMarginTop(Math.round(-1000 * scaleFactor));
        listBackground.get(4).setMarginBottom(Math.round(-1000 * scaleFactor));
        System.out.println(listBackground.get(0).toString());
        System.out.println(listBackground.get(4).toString());

        scaleFactor = listBackground.get(0).getScaleFactor();

        adapter = new Adapter(this, listBackground);
        listView.setAdapter(adapter);

        ElementsTask elementsTask = new ElementsTask();
        elementsTask.execute();
    }

    private class ElementsTask extends AsyncTask<Void, Void, List<Bitmap>> {
        private Context context = getApplicationContext();

        @Override
        protected List<Bitmap> doInBackground(Void... voids) {
            JSONParser jsonParser = new JSONParser(context);
            List<Bitmap> posters = jsonParser.getPosters();
            Bitmap bitmap0 = posters.get(0);
            System.out.println("bitmap_width " + bitmap0.getWidth());
            System.out.println("bitmap_height " + bitmap0.getHeight());
/*            Bitmap bitmapScalled0 = Bitmap.createScaledBitmap(bitmap0, 222, 325, true);

            Bitmap bitmap1 = posters.get(1);
            Bitmap bitmapScalled1 = Bitmap.createScaledBitmap(bitmap1, 212, 300, true);

            Bitmap bitmap2 = posters.get(2);
            Bitmap bitmapScalled2 = Bitmap.createScaledBitmap(bitmap2, 212, 300, true);

            Bitmap bitmap3 = posters.get(3);
            Bitmap bitmapScalled3 = Bitmap.createScaledBitmap(bitmap3, 212, 300, true);

            posters.set(0, bitmapScalled0);
            posters.set(1, bitmapScalled1);
            posters.set(2, bitmapScalled2);
            posters.set(3, bitmapScalled3);*/

            return posters;
        }

        @Override
        protected void onPostExecute(List<Bitmap> posters) {
            super.onPostExecute(posters);

            List<ElementImage> elementImageList = new ArrayList<ElementImage>();
            //poster1
            elementImageList.add(new ElementImage( 130 , 617 , 3, scaleFactor, 1.35f, posters.get(0), context));
            //poster2
            elementImageList.add(new ElementImage(334, 677, -1, scaleFactor, 1.35f, posters.get(1), context));
            //poster1 frame
            elementImageList.add(new ElementImage(124, 611, 3, scaleFactor, 1, R.drawable.main_poster_frame, context));
            //poster2 frame
            elementImageList.add(new ElementImage(328, 671, -1, scaleFactor, 1, R.drawable.main_poster_frame, context));
            //sticks frame
            elementImageList.add(new ElementImage(110, 595, 0, scaleFactor, 1, R.drawable.main_sticks, context));

            //poster3
            elementImageList.add(new ElementImage(84, 1100, 2, scaleFactor, 1.35f, posters.get(2), context));
            //poster4
            elementImageList.add(new ElementImage(372, 1098, 2.5f, scaleFactor, 1.35f, posters.get(3), context));
            //pin
            elementImageList.add(new ElementImage(212, 206, 0, scaleFactor, 1, R.drawable.main_pin, context));
            //light
            elementImageList.add(new ElementImage(344, 495, 0, scaleFactor, 1, R.drawable.main_light, context));
            //sticker
            //elementImageList.add(new ElementImage(372, 1098, 2.5f, scaleFactor, R.drawable.test_pst, context));

            adapter.setElementImageList(elementImageList);
            adapter.notifyDataSetChanged();
        }
    }
}
