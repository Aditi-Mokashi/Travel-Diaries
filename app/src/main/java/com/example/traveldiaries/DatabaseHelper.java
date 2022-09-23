package com.example.traveldiaries;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    SQLiteDatabase sqLiteDatabase;

    public DatabaseHelper(Context context)
    {
        super(context, "Users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table user (email text primary key, username text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists user");
    }

    public Boolean insertData(String email, String username, String password)
    {
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("password", password);

        return sqLiteDatabase.insert("user",null, contentValues) != -1;
    }


    public Boolean updateData(String email, String username, String password)
    {
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("password", password);

        Cursor cursor = sqLiteDatabase.rawQuery("select * from user where email = ? ",
                new String[]{email});

        if(cursor.getCount() > 0)
        {
            return sqLiteDatabase.update("user", contentValues, "email=?",
                    new String[]{email}) != -1;
        }
        else
        {
            return false;
        }
    }

    public Boolean deleteData(String email)
    {
        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from user where email = ? ",
                new String[]{email});

        if(cursor.getCount() > 0)
        {
            return sqLiteDatabase.delete("user",  "email=?",
                    new String[]{email}) != -1;
        }
        else
        {
            return false;
        }
    }

    public Cursor getData()
    {
        sqLiteDatabase = this.getWritableDatabase();

        return sqLiteDatabase.rawQuery("select * from user ",null);
    }

    // check whether the user exists in the table
    public Cursor getRecordForLogin(String email) {
        sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.rawQuery("select * from user where email = ? ",
                new String[]{email});
    }
}