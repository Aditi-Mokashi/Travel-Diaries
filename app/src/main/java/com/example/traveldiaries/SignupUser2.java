package com.example.traveldiaries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupUser2 extends AppCompatActivity
{
    Button register;
    EditText pass,cpass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_user2);

        register = findViewById(R.id.submit_signup);
        pass = findViewById(R.id.signup_password);
        cpass = findViewById(R.id.signup_confirm_password);

        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String textPassword = pass.getText().toString();
                String textConfirmPassword = cpass.getText().toString();
                String textEmail = getIntent().getStringExtra("email");
                String textUsername = getIntent().getStringExtra("username");

                if(textPassword.length() != 0 && textConfirmPassword.length() != 0)
                {
                    if (textPassword.equals(textConfirmPassword))
                    {
                        DatabaseHelper databaseHelper = new DatabaseHelper(SignupUser2.this);
                        if (databaseHelper.insertData(textEmail, textUsername, textPassword))
                        {
                            Toast.makeText(getApplicationContext(),
                                    "User created",
                                    Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(), UserGuide.class));
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),
                                    "Error in creating user!",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),
                            "Fill all the fields",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}