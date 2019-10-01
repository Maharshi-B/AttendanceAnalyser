package com.example.maharshi.attendanceanalyser;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "attendance.db";
    public static final String TABLE_NAME = "attendance_table";
    public static final String V0 = "ID";
    public static final String V1 = "PRE";
    public static final String V2 = "TOT";
    public static final String V3 = "TAR";
    public static final String V4 = "NAME";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + TABLE_NAME + " ( ID INTEGER PRIMARY KEY, PRE TEXT , TOT TEXT , TAR TEXT , NAME TEXT)" );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String total,String present,String tar,String name){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(V1,present);
        contentvalues.put(V2,total);
        contentvalues.put(V3,tar);
        contentvalues.put(V4,name);
        long r = db.insert(TABLE_NAME,null,contentvalues);
        if(r == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME,null);
        return res;
    }
}
