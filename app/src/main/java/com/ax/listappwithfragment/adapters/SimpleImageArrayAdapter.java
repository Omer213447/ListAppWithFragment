package com.ax.listappwithfragment.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class SimpleImageArrayAdapter extends ArrayAdapter<Integer> {
    private Integer[] images;
    private Integer width = -1;
    private Integer height = -1;

    public SimpleImageArrayAdapter(Context context, Integer[] images) {
        super(context, android.R.layout.simple_spinner_item, images);
        this.images = images;
    }

    public SimpleImageArrayAdapter(Context context, Integer[] images, Integer width, Integer height) {
        super(context, android.R.layout.simple_spinner_item, images);
        this.images = images;
        this.width = width;
        this.height = height;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getImageForPosition(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getImageForPosition(position);
    }

    private View getImageForPosition(int position) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(images[position]);
        if(width == -1 && height == -1){
            imageView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }else {
            imageView.setLayoutParams(new AbsListView.LayoutParams(width, height));
        }
        return imageView;
    }
}
