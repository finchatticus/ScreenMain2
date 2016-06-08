package com.gjevass.pixels.app.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.gjevass.pixels.app.R;

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
        lp.setMargins(0, backgroundImage.getMarginTop(), 0 ,backgroundImage.getMarginBottom());
        imageViewBackground.setLayoutParams(lp);
        imageViewBackground.setImageBitmap(backgroundImage.getBitmap());

        ElementImageView elementImageView0 = (ElementImageView) view.findViewById(R.id.elementImage0);
        ElementImageView elementImageView1 = (ElementImageView) view.findViewById(R.id.elementImage1);
        ElementImageView elementImageView2 = (ElementImageView) view.findViewById(R.id.elementImage2);
        ElementImageView elementImageView3 = (ElementImageView) view.findViewById(R.id.elementImage3);
        ElementImageView elementImageView4 = (ElementImageView) view.findViewById(R.id.elementImage4);

        System.out.println("i = " + i);

        if(elementImageList != null) {
            if(i == 1) {
                System.out.println("if 1");
                elementImageView0.setVisibility(View.VISIBLE);
                elementImageView1.setVisibility(View.VISIBLE);
                elementImageView2.setVisibility(View.VISIBLE);
                elementImageView3.setVisibility(View.VISIBLE);
                elementImageView4.setVisibility(View.VISIBLE);

                elementImageView0.setElementImage(elementImageList.get(0));
                elementImageView1.setElementImage(elementImageList.get(2));
                elementImageView2.setElementImage(elementImageList.get(1));
                elementImageView3.setElementImage(elementImageList.get(3));
                elementImageView4.setElementImage(elementImageList.get(4));
            }
/*            if(i == 3) {
                System.out.println("if 3");
                elementImageView0.setVisibility(View.VISIBLE);
                elementImageView1.setVisibility(View.VISIBLE);
                elementImageView2.setVisibility(View.VISIBLE);
                elementImageView3.setVisibility(View.VISIBLE);
                elementImageView4.setVisibility(View.GONE);

                elementImageView0.setElementImage(elementImageList.get(5));
                elementImageView1.setElementImage(elementImageList.get(6));
                elementImageView2.setElementImage(elementImageList.get(7));
                elementImageView3.setElementImage(elementImageList.get(8));
            }*/
/*            else {
                System.out.println("else");
                elementImageView0.setVisibility(View.INVISIBLE);
                elementImageView1.setVisibility(View.INVISIBLE);
                elementImageView2.setVisibility(View.INVISIBLE);
                elementImageView3.setVisibility(View.INVISIBLE);
                elementImageView4.setVisibility(View.INVISIBLE);
            }*/
        }

        return view;
    }

    public void setElementImageList(List<ElementImage> elementImageList) {
        this.elementImageList = elementImageList;
    }
}
