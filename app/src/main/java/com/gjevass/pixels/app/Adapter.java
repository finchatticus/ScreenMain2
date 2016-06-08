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
        imageViewBackground.setImageBitmap(listBackground.get(i).getBitmap());

        ElementImageView elementImageView0 = (ElementImageView) view.findViewById(R.id.elementImage0);
        ElementImageView elementImageView1 = (ElementImageView) view.findViewById(R.id.elementImage1);
        ElementImageView elementImageView2 = (ElementImageView) view.findViewById(R.id.elementImage2);
        ElementImageView elementImageView3 = (ElementImageView) view.findViewById(R.id.elementImage3);
        ElementImageView elementImageView4 = (ElementImageView) view.findViewById(R.id.elementImage4);




        elementImageView0.setElementImage(elementImageList.get(0));
        elementImageView1.setElementImage(elementImageList.get(1));
        elementImageView2.setElementImage(elementImageList.get(2));
        elementImageView3.setElementImage(elementImageList.get(3));
        elementImageView4.setElementImage(elementImageList.get(4));

        return view;
    }
}
