package com.kuch.ulanie;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME ="Database";
    private static final int DB_VERSION=1;
    private static final String Table_Name="Workout";
    private static final String Workout_Name="Workout_Name";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="CREATE TABLE "+ Table_Name+" ("+
                "ID INT PRIMARY KEY NOT NULL,"+
                Workout_Name +" TEXT)";

        db.execSQL(query);
    }

    public void newWorkout(String workoutName){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Workout_Name,workoutName);
        db.insert(Table_Name,null,values);
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
        onCreate(db);
    }
}
