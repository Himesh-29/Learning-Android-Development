package com.example.employeedatabaseusingsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataBase_Handler extends SQLiteOpenHelper {

    public DataBase_Handler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String cr="CREATE TABLE myemployee(sno INTEGER PRIMARY KEY, name TEXT, salary TEXT)";
        db.execSQL(cr);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop=String.valueOf("DROP TABLE IF EXISTS");
        db.execSQL(drop,new String[]{"myemployee"});
        onCreate(db);
    }

    public void addEmployee(Employee e){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("sno",e.getSno());
        values.put("name",e.getName());
        values.put("salary",e.getSalary());
        long k=db.insert("myemployee",null,values);
        Log.d("my tag",Long.toString(k));
        db.close();
    }

    public void getEmployee(int sno){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query("myemployee",new String[]{"sno","name","salary"},"sno=?",new String[]{String.valueOf(sno)},null,null,null);
        if(cursor!=null&&cursor.moveToFirst()){
            Log.d("mytag",cursor.getString(1));
            Log.d("mytag",cursor.getString(2));
        }
        else{
            Log.d("mytag","Some Error occurred!");
        }
    }
}
