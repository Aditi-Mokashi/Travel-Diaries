package com.example.traveldiaries;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    public SQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public void insertData(String name, String desc, byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO DIARIES VALUES (null,?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.bindString(1,name);
        statement.bindString(2,desc);
        statement.bindBlob(3,image);
        statement.executeInsert();
    }

    public void updatedata(String name, String desc, byte[] image,int id){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE DIARIES SET name = ?, desc = ?, image = ? WHERE ID = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.bindString(1,name);
        statement.bindString(2,desc);
        statement.bindBlob(3,image);
        statement.bindDouble(4,(double)id);
        statement.execute();
        database.close();
    }

    public void deletedata(int id){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "DELETE FROM DIARIES WHERE ID = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1,(double)id);
        statement.execute();
        database.close();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
