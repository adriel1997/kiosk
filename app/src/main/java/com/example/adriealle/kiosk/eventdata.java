package com.example.adriealle.kiosk;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Adriealle on 05-07-2018.
 */

public class eventdata extends SQLiteOpenHelper {


    public eventdata(Context context) {
        super(context, "EVENT", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE EVENT ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,startdate TEXT,finishdate TEXT,starttime TEXT,finishtime TEXT)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "EVENT");
        onCreate(db);
    }

    void addevent(String n, String s, String f, String st, String ft) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", n);
        values.put("startdate", s);
        values.put("finishdate", f);
        values.put("starttime", st);
        values.put("finishtime", ft);

        db.insert("EVENT", null, values);
        db.close();


    }

    void delete (String id){
        SQLiteDatabase db = this.getWritableDatabase();
db.delete("EVENT","_id = ?",
        new String[] {id});


    }

}