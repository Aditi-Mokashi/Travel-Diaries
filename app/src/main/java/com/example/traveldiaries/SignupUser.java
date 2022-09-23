package com.example.traveldiaries;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupUser extends AppCompatActivity
{
    TextView login;
    Button next;
    EditText name,email,pass,cpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        login = findViewById(R.id.Login_Here);
        name = findViewById(R.id.signup_username);
        email = findViewById(R.id.signup_email);
        next = findViewById(R.id.signup_next);

        String text = "Already Registered to TD? LOGIN.";
        SpannableString ss = new SpannableString(text);
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(getApplicationContext(), LoginUser.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#ffffff"));
            }
        };

        ss.setSpan(clickableSpan1,27,32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        login.setText(ss);
        login.setMovementMethod(LinkMovementMethod.getInstance());

        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String textUsername = name.getText().toString();
                String textEmail = email.getText().toString();

                if(textUsername.length() != 0 && textEmail.length() != 0)
                {
                    Intent intent = new Intent(getApplicationContext(), SignupUser2.class);
                    intent.putExtra("email", textEmail);
                    intent.putExtra("username", textUsername);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),
                            "Fill all the fields!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}