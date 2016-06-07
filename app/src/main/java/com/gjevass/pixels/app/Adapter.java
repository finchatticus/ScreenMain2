package com.gjevass.pixels.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class Adapter extends BaseAdapter {

    private Context context;
    private List<Bitmap> bitmapList;
    private List<ElementImage> elementImageList;

    public Adapter(Context context, List<Bitmap> bitmapList, List<ElementImage> elementImageList) {
        this.context = context;
        this.bitmapList = bitmapList;
        this.elementImageList = elementImageList;
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

        ImageView imageViewBackground = (ImageView) view.findViewById(R.id.imageBackground);
        ElementImageView elementImageView0 = (ElementImageView) view.findViewById(R.id.elementImage0);
        ElementImageView elementImageView1 = (ElementImageView) view.findViewById(R.id.elementImage1);
        imageViewBackground.setImageBitmap(bitmapList.get(0));

        elementImageView0.setElementImage(elementImageList.get(0));
        elementImageView1.setElementImage(elementImageList.get(1));

        return view;
    }
}
