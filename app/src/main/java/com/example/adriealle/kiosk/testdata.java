package com.example.adriealle.kiosk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Adriealle on 28-06-2018.
 */

public class testdata extends SQLiteOpenHelper {


    public testdata(Context context) {
        super(context, "SAMPLE", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE SAMPLE ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,shop TEXT,floor TEXT,cat TEXT,img BLOB)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "SAMPLE");
        onCreate(db);
    }

    void addContact(String n, String s, String f, String c, byte[] p) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", n);
        values.put("shop", s);
        values.put("floor", f);
        values.put("cat", c);
        values.put("img", p);

        db.insert("SAMPLE", null, values);
        db.close();


    }
/*
    public ArrayList<String> findbycat(String category){
        ArrayList<String> results = new ArrayList<String>();

        String quer="select DISTINCT name from REG where category is"+category;
        Cursor pol=getReadableDatabase().rawQuery(quer,null);
        pol.moveToFirst();
        while(!pol.isAfterLast())
        {
            results.add(pol.getString(0));
            pol.moveToNext();
        }
        pol.close();
        return  results;
    }

*/

    public ArrayList<String> getprobnames() {
        ArrayList<String> results = new ArrayList<String>();

        String quer = "select DISTINCT name from SAMPLE";
        Cursor pol = getReadableDatabase().rawQuery(quer, null);
        pol.moveToFirst();
        while (!pol.isAfterLast()) {
            results.add(pol.getString(0));
            pol.moveToNext();
        }
        pol.close();
        return results;
    }

    public int updateContact(String n, String s, String f, String c, byte[] p) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", n);
        values.put("shop", s);
        values.put("floor", f);
        values.put("cat", c);
        values.put("img", p);        // updating row
        return db.update("SAMPLE", values, "shop" + " = ?",
                new String[] {s});
    }
    public String getnamefromlist(long id) {
        String rowLat = "not found";
        SQLiteDatabase db = this.getReadableDatabase();
        //String latQuery = "SELECT " + KEY_LATITUDE + " FROM " + TABLE_COORDINATES + " WHERE " + KEY_ID + "=" + id;
        //Cursor cursor = db.rawQuery(latQuery,null);
        Cursor cursor = db.query("SAMPLE", new String[] { "name" },"id="+id, null, null, null,null);
        if (cursor.moveToFirst()){
            cursor.moveToPosition((int) id);
            rowLat = cursor.getString(cursor.getColumnIndex("name"));
        }
        cursor.close();
        db.close();

        // return coordinates
        return rowLat;
    }
    void delete (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("SAMPLE","_id = ?",
                new String[] {id});


    }
}