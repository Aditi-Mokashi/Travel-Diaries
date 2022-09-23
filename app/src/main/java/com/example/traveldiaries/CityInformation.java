package com.example.traveldiaries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class CityInformation extends AppCompatActivity {

    ImageView img;
    TextView name,desc;
    RelativeLayout r1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_information);

//        img = findViewById(R.id.gridimage);
        name = findViewById(R.id.gridname);
        desc = findViewById(R.id.citydesc);
        r1 = (RelativeLayout) findViewById(R.id.city_information);


        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
//        img.setImageResource(intent.getIntExtra("images",0));


//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle(Html.fromHtml("<font color='#000000'>"+intent.getStringExtra("name")));
//        actionBar.setHomeAsUpIndicator(R.drawable.back);
//
//        // showing the back button in action bar
//        actionBar.setDisplayHomeAsUpEnabled(true);

        String name = intent.getStringExtra("name");
        //int i = intent.getIntExtra("images",0);


        if(name.equals("Agra")) {
            r1.setBackgroundResource((R.drawable.agra_background));
            desc.setText("It is generally accepted that Agra was both an ancient city from the times of the Mahabharata (see above) and yet nevertheless Sultan Sikandar Lodī, the Muslim ruler of the Delhi Sultanate, founded Agra in the year 1504. After the Sultan’s death, the city passed on to his son, Sultan Ibrāhīm Lodī. He ruled his Sultanate from Agra until he fell fighting to Mughal Badshah (emperor) Bābar in the First battle of Panipat fought in 1526.\n");
        }else if(name.equals("Amritsar")){
            r1.setBackgroundResource((R.drawable.amritsar_background));
            desc.setText("It is generally accepted that Agra was both an ancient city from the times of the Mahabharata (see above) and yet nevertheless Sultan Sikandar Lodī, the Muslim ruler of the Delhi Sultanate, founded Agra in the year 1504. After the Sultan’s death, the city passed on to his son, Sultan Ibrāhīm Lodī. He ruled his Sultanate from Agra until he fell fighting to Mughal Badshah (emperor) Bābar in the First battle of Panipat fought in 1526.\n");
        }else if(name.equals("Darjeeling")){
            r1.setBackgroundResource((R.drawable.darjeeling_background));
            desc.setText("It is generally accepted that Agra was both an ancient city from the times of the Mahabharata (see above) and yet nevertheless Sultan Sikandar Lodī, the Muslim ruler of the Delhi Sultanate, founded Agra in the year 1504. After the Sultan’s death, the city passed on to his son, Sultan Ibrāhīm Lodī. He ruled his Sultanate from Agra until he fell fighting to Mughal Badshah (emperor) Bābar in the First battle of Panipat fought in 1526.\n");
        }else if(name.equals("Munnar")){
            r1.setBackgroundResource((R.drawable.munnar_background));
            desc.setText("It is generally accepted that Agra was both an ancient city from the times of the Mahabharata (see above) and yet nevertheless Sultan Sikandar Lodī, the Muslim ruler of the Delhi Sultanate, founded Agra in the year 1504. After the Sultan’s death, the city passed on to his son, Sultan Ibrāhīm Lodī. He ruled his Sultanate from Agra until he fell fighting to Mughal Badshah (emperor) Bābar in the First battle of Panipat fought in 1526.\n");
        }else if(name.equals("New Delhi")){
            r1.setBackgroundResource((R.drawable.newdelhi_background));
            desc.setText("It is generally accepted that Agra was both an ancient city from the times of the Mahabharata (see above) and yet nevertheless Sultan Sikandar Lodī, the Muslim ruler of the Delhi Sultanate, founded Agra in the year 1504. After the Sultan’s death, the city passed on to his son, Sultan Ibrāhīm Lodī. He ruled his Sultanate from Agra until he fell fighting to Mughal Badshah (emperor) Bābar in the First battle of Panipat fought in 1526.\n");
        }else if(name.equals("Pune")){
            r1.setBackgroundResource((R.drawable.pune_background));
            desc.setText("It is generally accepted that Agra was both an ancient city from the times of the Mahabharata (see above) and yet nevertheless Sultan Sikandar Lodī, the Muslim ruler of the Delhi Sultanate, founded Agra in the year 1504. After the Sultan’s death, the city passed on to his son, Sultan Ibrāhīm Lodī. He ruled his Sultanate from Agra until he fell fighting to Mughal Badshah (emperor) Bābar in the First battle of Panipat fought in 1526.\n");
        } else if(name.equals("Kerala")){
            r1.setBackgroundResource((R.drawable.kerala_background));
            desc.setText("It is generally accepted that Agra was both an ancient city from the times of the Mahabharata (see above) and yet nevertheless Sultan Sikandar Lodī, the Muslim ruler of the Delhi Sultanate, founded Agra in the year 1504. After the Sultan’s death, the city passed on to his son, Sultan Ibrāhīm Lodī. He ruled his Sultanate from Agra until he fell fighting to Mughal Badshah (emperor) Bābar in the First battle of Panipat fought in 1526.\n");
        }else if(name.equals("Manali")){
            r1.setBackgroundResource((R.drawable.mumbai_background));
            desc.setText("It is generally accepted that Agra was both an ancient city from the times of the Mahabharata (see above) and yet nevertheless Sultan Sikandar Lodī, the Muslim ruler of the Delhi Sultanate, founded Agra in the year 1504. After the Sultan’s death, the city passed on to his son, Sultan Ibrāhīm Lodī. He ruled his Sultanate from Agra until he fell fighting to Mughal Badshah (emperor) Bābar in the First battle of Panipat fought in 1526.\n");
        }else if(name.equals("Jaipur")){
            r1.setBackgroundResource((R.drawable.jaipur_background));
            desc.setText("It is generally accepted that Agra was both an ancient city from the times of the Mahabharata (see above) and yet nevertheless Sultan Sikandar Lodī, the Muslim ruler of the Delhi Sultanate, founded Agra in the year 1504. After the Sultan’s death, the city passed on to his son, Sultan Ibrāhīm Lodī. He ruled his Sultanate from Agra until he fell fighting to Mughal Badshah (emperor) Bābar in the First battle of Panipat fought in 1526.\n");
        }else if(name.equals("Leh-Ladhak")){
            r1.setBackgroundResource((R.drawable.lehladhak_background));
            desc.setText("It is generally accepted that Agra was both an ancient city from the times of the Mahabharata (see above) and yet nevertheless Sultan Sikandar Lodī, the Muslim ruler of the Delhi Sultanate, founded Agra in the year 1504. After the Sultan’s death, the city passed on to his son, Sultan Ibrāhīm Lodī. He ruled his Sultanate from Agra until he fell fighting to Mughal Badshah (emperor) Bābar in the First battle of Panipat fought in 1526.\n");
        }else if(name.equals("Udaipur")){
            r1.setBackgroundResource((R.drawable.mumbai_background));
            desc.setText("It is generally accepted that Agra was both an ancient city from the times of the Mahabharata (see above) and yet nevertheless Sultan Sikandar Lodī, the Muslim ruler of the Delhi Sultanate, founded Agra in the year 1504. After the Sultan’s death, the city passed on to his son, Sultan Ibrāhīm Lodī. He ruled his Sultanate from Agra until he fell fighting to Mughal Badshah (emperor) Bābar in the First battle of Panipat fought in 1526.\n");
        }else if(name.equals("Varanasi")){
            r1.setBackgroundResource((R.drawable.mumbai_background));
            desc.setText("It is generally accepted that Agra was both an ancient city from the times of the Mahabharata (see above) and yet nevertheless Sultan Sikandar Lodī, the Muslim ruler of the Delhi Sultanate, founded Agra in the year 1504. After the Sultan’s death, the city passed on to his son, Sultan Ibrāhīm Lodī. He ruled his Sultanate from Agra until he fell fighting to Mughal Badshah (emperor) Bābar in the First battle of Panipat fought in 1526.\n");
        }else if(name.equals("Mumbai")){
            r1.setBackgroundResource((R.drawable.mumbai_background));
            desc.setText("It is generally accepted that Agra was both an ancient city from the times of the Mahabharata (see above) and yet nevertheless Sultan Sikandar Lodī, the Muslim ruler of the Delhi Sultanate, founded Agra in the year 1504. After the Sultan’s death, the city passed on to his son, Sultan Ibrāhīm Lodī. He ruled his Sultanate from Agra until he fell fighting to Mughal Badshah (emperor) Bābar in the First battle of Panipat fought in 1526.\n");
        }else if(name.equals("Andaman")){
            r1.setBackgroundResource((R.drawable.mumbai_background));
            desc.setText("It is generally accepted that Agra was both an ancient city from the times of the Mahabharata (see above) and yet nevertheless Sultan Sikandar Lodī, the Muslim ruler of the Delhi Sultanate, founded Agra in the year 1504. After the Sultan’s death, the city passed on to his son, Sultan Ibrāhīm Lodī. He ruled his Sultanate from Agra until he fell fighting to Mughal Badshah (emperor) Bābar in the First battle of Panipat fought in 1526.\n");
        }


    }
}