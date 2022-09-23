package com.example.traveldiaries;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginUser extends AppCompatActivity
{
    TextView register;
    EditText email, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        register = findViewById(R.id.Register_Here);
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        login = findViewById(R.id.submit_login);

        email.requestFocus();

        password.setTransformationMethod(new PasswordTransformationMethod());

        String text = "New to Travel Diaries? REGISTER.";
        SpannableString ss = new SpannableString(text);
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(getApplicationContext(), SignupUser.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#ffffff"));
            }
        };

        ss.setSpan(clickableSpan1,23,31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        register.setText(ss);
        register.setMovementMethod(LinkMovementMethod.getInstance());

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textEmail = email.getText().toString();
                String textPassword = password.getText().toString();

                if(textEmail.length() != 0 && textPassword.length() != 0)
                {
                    DatabaseHelper databaseHelper = new DatabaseHelper(LoginUser.this);
                    Cursor cursor = databaseHelper.getRecordForLogin(textEmail);
                    if (cursor.getCount() != 0)
                    {
                        // check whether the password is correct or not
                        cursor.moveToFirst();
                        int index = cursor.getColumnIndex("password");
                        if(cursor.getString(index).equals(textPassword))
                        {
                            Intent intent = new Intent(getApplicationContext(), UserGuide.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),
                                    "Invalid password",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),
                                "User does not exist please sign up",
                                Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),
                            "Please fill all the fields!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}

/*
2021-06-10 23:52:19.168 22394-22394/com.example.traveldiaries E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.example.traveldiaries, PID: 22394
    android.database.CursorIndexOutOfBoundsException: Index -1 requested, with a size of 1
        at android.database.AbstractCursor.checkPosition(AbstractCursor.java:468)
        at android.database.AbstractWindowedCursor.checkPosition(AbstractWindowedCursor.java:136)
        at android.database.AbstractWindowedCursor.getString(AbstractWindowedCursor.java:50)
        at com.example.traveldiaries.LoginUser$2.onClick(LoginUser.java:77)
        at android.view.View.performClick(View.java:6297)
        at android.view.View$PerformClick.run(View.java:24797)
        at android.os.Handler.handleCallback(Handler.java:790)
        at android.os.Handler.dispatchMessage(Handler.java:99)
        at android.os.Looper.loop(Looper.java:164)
        at android.app.ActivityThread.main(ActivityThread.java:6626)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:438)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:811)
 */