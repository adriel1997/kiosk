package com.example.adriealle.kiosk;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    String ID,FIND;
    TextView NAME;
    TextView SHOP;
    TextView FLOOR;
    Button dele;
    TextView CAT;
    ImageView poto;
    Cursor c;
    testdata d;
    String name;
    freeshops f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        NAME = (TextView) findViewById(R.id.NA);
        SHOP = (TextView) findViewById(R.id.SH);
        FLOOR = (TextView) findViewById(R.id.CA);
        CAT = (TextView) findViewById(R.id.FL);
 dele=findViewById(R.id.but);
        poto = (ImageView) findViewById(R.id.IM);
       d =new testdata(this);


       f=new freeshops(this);


    FIND = getIntent().getExtras().getString("find");
//}
    //catch (Exception e)
    //{
        ID = getIntent().getExtras().getString("id");
    //}

        Toast.makeText(this, ""+ID, Toast.LENGTH_SHORT).show();


        SQLiteDatabase g=d.getReadableDatabase();
        if(g!=null) {
            if(FIND!=null){
                c = g.query("SAMPLE",null,"name=?",new String[]{FIND}, null, null, null);
            }

            else {
                c = g.query("SAMPLE",null,"_id=?",new String[]{ID}, null, null, null);}
            if (c != null) {
                c.moveToFirst();
                byte[] imagesbytes= c.getBlob(c.getColumnIndex("img"));
            poto.setImageBitmap(BitmapFactory.decodeByteArray(imagesbytes, 0, imagesbytes.length));
                NAME.setText("NAME :"+c.getString(c.getColumnIndex("name")));
                name=c.getString(c.getColumnIndex("name"));
                SHOP.setText("Shop no. :"+c.getString(c.getColumnIndex("shop")));
                FLOOR.setText("Floor no. :"+c.getString(c.getColumnIndex("floor")));
                CAT.setText("Category :"+c.getString(c.getColumnIndex("cat")));
            }
        }


        dele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d.delete(ID);
                f.addfreeshop(name);
            }
        });
    }
}
