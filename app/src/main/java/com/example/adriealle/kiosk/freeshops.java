package com.example.adriealle.kiosk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Adriealle on 19-07-2018.
 */

public class freeshops extends SQLiteOpenHelper {

    SQLiteDatabase db = this.getReadableDatabase();


    public freeshops(Context context) {
        super(context, "FREE", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE FREE ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,shop TEXT,floor TEXT)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "FREE");
        onCreate(db);
    }

    public int removefreeshop(String n, String s) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", n);
        return db.update("FREE", values, "shop" + " = ?",
                new String[] {s});
    }

    void addshops(String n, String s, String f) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", n);
        values.put("shop", s);
        values.put("floor", f);
        db.insert("FREE", null, values);
        db.close();


    }

    public ArrayList<String> getfreenames(String f) {
        String latQuery = "SELECT shop FROM FREE WHERE name="+ "'free'"+ "and floor="+f;

        ArrayList<String> results = new ArrayList<String>();
        //Cursor cursor = db.query("FREE", new String[] { "shop" },"name=free", null, null, null,null);

        Cursor cursor = db.rawQuery(latQuery,null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            results.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return results;
    }

    public int addfreeshop(String n) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", "free");       // updating rows
        return db.update("FREE", values, "name" + " = ?",
                new String[] {n});
    }

}