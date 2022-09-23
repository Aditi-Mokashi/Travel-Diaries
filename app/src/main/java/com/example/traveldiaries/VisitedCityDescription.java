package com.example.traveldiaries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class VisitedCityDescription extends AppCompatActivity {

    TextView name,desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visited_city_description);

        name = findViewById(R.id.citynamedesc);
        desc = findViewById(R.id.citydescdesc);
        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        desc.setText(intent.getStringExtra("desc"));
    }
}