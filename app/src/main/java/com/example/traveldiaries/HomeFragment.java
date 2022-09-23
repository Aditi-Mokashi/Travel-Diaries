package com.example.traveldiaries;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment extends Fragment {
    ImageView imageView;
    TextView textView;

    public interface homFragmentListerner{
        void sendData(String[] name,int[] images);
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private homFragmentListerner listerner;
    final String[] name = {"Agra","Amritsar","Darjeeling","Munnar","New Delhi","Pune","Kerala","Manali","Jaipur","Leh-Ladhak","Udaipur","Varanasi","Mumbai","Andaman"};
    final int[] images = {
            R.drawable.agra_background,
            R.drawable.amritsar_background,
            R.drawable.darjeeling_background,
            R.drawable.munnar_background,
            R.drawable.newdelhi_background,
            R.drawable.pune_background,
            R.drawable.kerala_background,
            R.drawable.manali,
            R.drawable.jaipur_background,
            R.drawable.lehladhak_background,
            R.drawable.udaipur,
            R.drawable.varanasi,
            R.drawable.mumbai_background,
            R.drawable.andaman
    };
    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view1 = inflater.inflate(R.layout.fragment_home, container, false);
        gridView = view1.findViewById(R.id.city_list);

        gridView.setAdapter(new HomeGridAdapter(name,images,getContext()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @SuppressLint("ResourceType")
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setMessage("Have you been to "+name[arg2]+" ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {

                                Toast.makeText(getContext(),"Added to My trips",Toast.LENGTH_LONG).show();

                                //passing name of the city to my_trips activity
                                Intent in = new Intent(getActivity().getBaseContext(), MyTrips.class);
                                in.putExtra("name", name[arg2]);

                                //passing contents from this frgament to city_information activity
                                Intent intent = new Intent(getActivity().getBaseContext(),
                                        CityInformation.class);
                                intent.putExtra("name", name[arg2]);
                                intent.putExtra("images", images[arg2]);
                                getActivity().startActivity(intent);
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getContext(),"Do visit during holidays",Toast.LENGTH_LONG).show();

                        //passing contents from this frgament to city_information activity
                        Intent intent = new Intent(getActivity().getBaseContext(),
                                CityInformation.class);
                        intent.putExtra("name", name[arg2]);
                        intent.putExtra("images", images[arg2]);
                        getActivity().startActivity(intent);
                    }
                });
                AlertDialog alert1 = alert.create();
                alert1.show();

            }
        }) ;
        // Inflate the layout for this fragment
        return view1;
    }
}
