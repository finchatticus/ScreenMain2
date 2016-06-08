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
    private List<BackgroundImage> listBackground;
    private List<ElementImage> elementImageList;

    public Adapter(Context context, List<BackgroundImage> listBackground, List<ElementImage> elementImageList) {
        this.context = context;
        this.listBackground = listBackground;
        this.elementImageList = elementImageList;
    }

    @Override
    public int getCount() {
        return listBackground.size();
    }

    @Override
    public Object getItem(int i) {
        return listBackground.get(i);
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
        imageViewBackground.setImageBitmap(listBackground.get(i).getBitmap());

        elementImageView0.setElementImage(elementImageList.get(0));
        elementImageView1.setElementImage(elementImageList.get(1));

        return view;
    }
}
