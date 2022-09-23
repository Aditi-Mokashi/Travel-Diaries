package com.example.traveldiaries;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class VisitedCitiesList extends AppCompatActivity {
    GridView gridView;
    ArrayList<Cities> cities;
    CityListAdapter adapter = null;
    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visited_cities_list);
        gridView = (GridView)findViewById(R.id.gridview);
        cities = new ArrayList<>();
        adapter = new CityListAdapter(getApplicationContext(), R.layout.activity_visited_city_description,cities);
        gridView.setAdapter(adapter);

        //get data from sqlite

        Cursor cursor = MyTrips.sqLiteHelper.getData("SELECT * FROM DIARIES");
        cities.clear();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String desc = cursor.getString(2);
            byte[] image = cursor.getBlob(3);
            cities.add(new Cities(id,name,desc,image));
        }
        adapter.notifyDataSetChanged();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = MyTrips.sqLiteHelper.getData("SELECT name,  desc FROM DIARIES");
                Intent intent = new Intent(getApplicationContext(),VisitedCityDescription.class);
                while (cursor.moveToNext()){
                    intent.putExtra("name",cursor.getString(0));
                    intent.putExtra("desc",cursor.getString(1));
                }
                startActivity(intent);
            }
        });

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                CharSequence[] items = {"Update","Delete"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(VisitedCitiesList.this);
                dialog.setTitle("choose an action");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if(item==0){
                            Cursor c = MyTrips.sqLiteHelper.getData("SELECT id from DIARIES");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while(c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            //showing dialog update
                            showdialogupdate(VisitedCitiesList.this,arrID.get(position));
                        }
                        else {
                            Cursor c = MyTrips.sqLiteHelper.getData("SELECT id from DIARIES");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while(c.moveToNext()) {
                                arrID.add(c.getInt(0));
                            }
                            showdialogdelete(arrID.get(position));
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });
    }
    ImageView imageViewup;
    Button updatebtn;
    public void showdialogupdate(Activity activity,int position){
        Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.updated_visited_list);
        dialog.setTitle("Update");
        imageViewup = (ImageView)dialog.findViewById(R.id.imageViewupdated);
        EditText editname = (EditText)dialog.findViewById(R.id.updatecityname);
        EditText editdesc = (EditText)dialog.findViewById(R.id.updatecitydesc);
        updatebtn = (Button)dialog.findViewById(R.id.buttonupdate);

        int width = (int)(activity.getResources().getDisplayMetrics().widthPixels * 0.95);
        int height =  (int)(activity.getResources().getDisplayMetrics().heightPixels * 0.7);
        dialog.getWindow().setLayout(width,height);
        dialog.show();
        imageViewup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        VisitedCitiesList.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        888);
            }
        });
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    MyTrips.sqLiteHelper.updatedata(
                            editname.getText().toString().trim(),
                            editdesc.getText().toString().trim(),
                            MyTrips.imageViewtoByte(imageViewup),
                            position
                    );
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Updated successfully",Toast.LENGTH_LONG).show();

                }
                catch (Exception e){
                    Log.d("Update error",e.getMessage());
                }
                updatecitylist();
            }
        });
    }

    private void showdialogdelete(final int idCity){
        AlertDialog.Builder dialogdelete = new AlertDialog.Builder(VisitedCitiesList.this);
        dialogdelete.setTitle("Alert!");
        dialogdelete.setMessage("Are you sure you want to delete your memory?");
        dialogdelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try{
                    MyTrips.sqLiteHelper.deletedata(idCity);
                    Toast.makeText(getApplicationContext(),"Deleted successfully",Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    Log.e("Error",e.getMessage());
                }
                updatecitylist();
            }
        });
        dialogdelete.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogdelete.show();
    }



    private void updatecitylist(){

        //get data from sqlite
        Cursor cursor = MyTrips.sqLiteHelper.getData("SELECT * FROM DIARIES");
        cities.clear();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String desc = cursor.getString(2);
            byte[] image = cursor.getBlob(3);
            cities.add(new Cities(id,name,desc,image));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull  int[] grantResults) {
        if(requestCode==888){
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,888);
            }
            else {
                Toast.makeText(this,"You don't have permission",Toast.LENGTH_LONG).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        if(requestCode==888 && resultCode == RESULT_OK && data!=null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageViewup.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
