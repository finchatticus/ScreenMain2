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
    private List<BackgroundImage> listBackground;
    private List<ElementImage> elementImageList;

    public Adapter(Context context, List<BackgroundImage> listBackground) {
        this.context = context;
        this.listBackground = listBackground;
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

        BackgroundImage backgroundImage = (BackgroundImage) getItem(i);

        ImageView imageViewBackground = (ImageView) view.findViewById(R.id.imageBackground);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(imageViewBackground.getLayoutParams());
        lp.setMargins(0, backgroundImage.getMarginTop(), 0, backgroundImage.getMarginBottom());
        imageViewBackground.setImageBitmap(backgroundImage.getBitmap());

        ElementImageView elementImageView0 = (ElementImageView) view.findViewById(R.id.elementImage0);
        ElementImageView elementImageView1 = (ElementImageView) view.findViewById(R.id.elementImage1);
        ElementImageView elementImageView2 = (ElementImageView) view.findViewById(R.id.elementImage2);
        ElementImageView elementImageView3 = (ElementImageView) view.findViewById(R.id.elementImage3);
        ElementImageView elementImageView4 = (ElementImageView) view.findViewById(R.id.elementImage4);

        if(elementImageList != null) {
            if(i == 1) {
                elementImageView0.setElementImage(elementImageList.get(2));
                elementImageView1.setElementImage(elementImageList.get(3));
                elementImageView2.setElementImage(elementImageList.get(0));
                elementImageView3.setElementImage(elementImageList.get(1));
                elementImageView4.setElementImage(elementImageList.get(4));
            }
            if(i == 3) {
                elementImageView0.setElementImage(elementImageList.get(5));
                elementImageView1.setElementImage(elementImageList.get(6));
                elementImageView2.setElementImage(elementImageList.get(7));
                elementImageView3.setElementImage(elementImageList.get(8));
                elementImageView4.setVisibility(View.INVISIBLE);
            }
        }

        return view;
    }

    public void setElementImageList(List<ElementImage> elementImageList) {
        this.elementImageList = elementImageList;
    }
}
