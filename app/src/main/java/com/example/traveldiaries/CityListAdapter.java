package com.example.traveldiaries;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CityListAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Cities> citieslist;

    public CityListAdapter(Context context, int layout, ArrayList<Cities> citieslist) {
        this.context = context;
        this.layout = layout;
        this.citieslist = citieslist;
    }

    @Override
    public int getCount() {
        return citieslist.size();
    }

    @Override
    public Object getItem(int position) {
        return citieslist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtDesc;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = new ViewHolder();
        if(row==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(layout,null);
            holder.txtName = (TextView)row.findViewById(R.id.cityname2);
            //holder.txtDesc = (TextView)row.findViewById(R.id.citydesc2);
            holder.imageView = (ImageView)row.findViewById(R.id.cityimage);
            row.setTag(holder);
        }
        else{
            holder = (ViewHolder)row.getTag();
        }
        Cities cities = citieslist.get(position);
        holder.txtName.setText(cities.getName());
        //holder.txtDesc.setText(cities.getDesc());
        byte[] cityimage = cities.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(cityimage,0,cityimage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
