package com.example.adriealle.kiosk;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by anant mehra on 01-07-2018.
 */

public class pop extends Activity {
String ID;
Cursor c;
ImageView IMGPOP;
Button gotomap;


TextView NAMEPOP,SHOPPOP,FLOORPOP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop);

        DisplayMetrics displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width=displayMetrics.widthPixels;
        int height=displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.6));

        NAMEPOP=findViewById(R.id.NAPOP);
        SHOPPOP=findViewById(R.id.SHPOP);;
        FLOORPOP=findViewById(R.id.FLPOP);
        IMGPOP=findViewById(R.id.IMPOP);
        gotomap=findViewById(R.id.gotomap);

        ID = getIntent().getExtras().getString("id");


        Toast.makeText(this, ""+ID, Toast.LENGTH_SHORT).show();

        testdata d=new testdata(this);
        SQLiteDatabase g=d.getReadableDatabase();
        if(g!=null) {

                c = g.query("SAMPLE",null,"_id=?",new String[]{ID}, null, null, null);
            if (c != null) {
                c.moveToFirst();
                byte[] imagesbytes= c.getBlob(c.getColumnIndex("img"));
                IMGPOP.setImageBitmap(BitmapFactory.decodeByteArray(imagesbytes, 0, imagesbytes.length));
                NAMEPOP.setText("NAME :"+c.getString(c.getColumnIndex("name")));
                SHOPPOP.setText("Shop no. :"+c.getString(c.getColumnIndex("shop")));
                FLOORPOP.setText("Floor no. :"+c.getString(c.getColumnIndex("floor")));

            }
        }
    }
}
