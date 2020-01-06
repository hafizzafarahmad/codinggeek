package com.princedev.coddinggeek.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.princedev.coddinggeek.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class ImageSliderAdapter extends SliderViewAdapter<ImageSliderAdapter.SliderAdapterVH> {

    private Context context;

    public ImageSliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {

        switch (position){
            case 0:
                viewHolder.image.setBackgroundResource(R.drawable.quote1);
                break;
            case 1:
                viewHolder.image.setBackgroundResource(R.drawable.quote2);
                break;
            case 2:
                viewHolder.image.setBackgroundResource(R.drawable.quote3);
                break;
            case 3:
                viewHolder.image.setBackgroundResource(R.drawable.quote4);
                break;
        }

    }

    @Override
    public int getCount() {
        return 4;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        ImageView image;

        public SliderAdapterVH(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image_slider);
        }
    }
}
