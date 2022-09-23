package com.example.traveldiaries;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class UserGuide extends AppCompatActivity {
    Toolbar tb;
    DrawerLayout DrawerLayout;
    ActionBarDrawerToggle Toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_guide);

        tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        DrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);

        Toggle = new ActionBarDrawerToggle(UserGuide.this,DrawerLayout,tb,R.string.open,R.string.close);
        DrawerLayout.addDrawerListener(Toggle);
        Toggle.syncState();

        Toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new HomeFragment()).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Fragment fragment=null;
                switch (id)
                {
                    case R.id.home:fragment = new Fragment();
                        tb.setTitle("Home");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new HomeFragment()).commit();
                        DrawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.profile:startActivity(new Intent(getApplicationContext(),Profile.class));
                        DrawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.my_trips:startActivity(new Intent(getApplicationContext(),MyTrips.class));
                        DrawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.logout:fragment = new Fragment();
                        tb.setTitle("Logout");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new LogoutFragment()).commit();
                        DrawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.about_us:startActivity(new Intent(getApplicationContext(),AboutUs.class));
                        DrawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    default: return true;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(Toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}