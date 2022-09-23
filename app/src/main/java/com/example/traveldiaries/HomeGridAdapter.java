package com.example.traveldiaries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeGridAdapter extends BaseAdapter {



    private final String[] city_names;
    private final int[] city_images;
    Context context;

    public HomeGridAdapter(String[] city_names, int[] city_images, Context context) {
        this.city_names = city_names;
        this.city_images = city_images;
        this.context = context;
    }

    @Override
    public int getCount() {
        return city_images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //passing
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.city_row_items,null);

        ImageView img = view.findViewById(R.id.image);
        TextView city = view.findViewById(R.id.name);

        img.setImageResource(city_images[position]);
        city.setText(city_names[position]);

        return view;
    }
}
