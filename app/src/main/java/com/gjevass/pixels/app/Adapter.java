package com.gjevass.pixels.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.List;

public class Adapter extends BaseAdapter {

    private Context context;
    private List<Bitmap> bitmapList;

    public Adapter(Context context, List<Bitmap> bitmapList) {
        this.context = context;
        this.bitmapList = bitmapList;
    }

    @Override
    public int getCount() {
        return bitmapList.size();
    }

    @Override
    public Object getItem(int i) {
        return bitmapList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view == null) {
            view = layoutInflater.inflate(R.layout.item, viewGroup, false);
        }
        ImageView imageView1 = (ImageView) view.findViewById(R.id.image1);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.image2);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.image3);
        imageView1.setImageBitmap(bitmapList.get(0));

        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(imageView2.getLayoutParams());
        lp.setMargins(55,264,0,0);
        //lp.setMargins(130,617,0,0);
        imageView2.setLayoutParams(lp);
        imageView2.setRotation(3);
        imageView2.setImageBitmap(bitmapList.get(1));

        FrameLayout.LayoutParams lp1 = new FrameLayout.LayoutParams(imageView3.getLayoutParams());
        lp1.setMargins(143,289,0,0);
        //lp1.setMargins(334,677,0,0);
        imageView3.setLayoutParams(lp1);
        imageView3.setRotation(-1);
        imageView3.setImageBitmap(bitmapList.get(1));

        return view;
    }
}
