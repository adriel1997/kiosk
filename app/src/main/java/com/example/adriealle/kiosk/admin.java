package com.example.adriealle.kiosk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import android.view.Window;

public class admin extends AppCompatActivity{
    String s;
    Button find,Cat,dummy,events,del;
    AutoCompleteTextView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_admin);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);



        find = (Button) findViewById(R.id.button3);
        Button sign = (Button) findViewById(R.id.button2);
         Cat = (Button) findViewById(R.id.button4);
        del = (Button) findViewById(R.id.button6);
        dummy = (Button) findViewById(R.id.dummy);
        events = (Button) findViewById(R.id.events);
        Button master=(Button)findViewById(R.id.button);
        v=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView) ;

        testdata d=new testdata(this);

        ArrayList<String> gee= d.getprobnames();
        ArrayAdapter<String> geee=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,gee);
        v.setAdapter(geee);
        v.setThreshold(1);
/*
        SQLiteDatabase g=d.getReadableDatabase();
        Cursor c = g.query("REG",null,null,null, null, null, null);
        SimpleCursorAdapter p = new SimpleCursorAdapter(this,R.layout.order,c,new String[] {"name"},new int [] {R.id.a},0);

*/


        master.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent q = new Intent(admin.this, Imagelisting.class);
                    startActivity(q);

            }
        });


find.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent re = new Intent(admin.this,Main2Activity.class);
        re.putExtra("find",v.getText().toString());
        startActivity(re);

    }
});

Cat.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent re = new Intent(admin.this,Imagelisting.class);
        re.putExtra("cat","food");
        startActivity(re);

    }
});
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(admin.this, testing.class);
                startActivity(j);

            }
        });

        dummy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dummydata();
                Toast.makeText(admin.this, "Dummy data created", Toast.LENGTH_SHORT).show();
            }
        });

    events.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i=new Intent(admin.this,addevent.class);
            startActivity(i);        }
    });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(admin.this,eventlist.class);
                startActivity(i);        }
        });

    }
    public void dummydata(){

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.aplay);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);

        byte[] imagesd=stream.toByteArray();
        testdata tb =new testdata(this);
        tb.addContact("kfc","1","0","food",imagesd);
        tb.addContact("ccd","2","0","drinks",imagesd);
        tb.addContact("berco's","3","0","restraunt",imagesd);
        tb.addContact("icici","4","0","atm",imagesd);
        tb.addContact("apollo","5","0","medical",imagesd);
        tb.addContact("toys","6","0","kids",imagesd);
        tb.addContact("mochi","7","0","cobbler",imagesd);
        tb.addContact("drycleaner","8","0","laundry",imagesd);
        tb.addContact("dfs","9","0","courier",imagesd);
        tb.addContact("infomation desk","10","0","info",imagesd);
        tb.addContact("playpen","11","0","kidsplay",imagesd);
        tb.addContact("mrf","12","0","automobile",imagesd);
        tb.addContact("bodyshop","13","0","beauty",imagesd);
        tb.addContact("crossword","14","0","books",imagesd);
        tb.addContact("eworld","15","0","electronic",imagesd);
        tb.addContact("pvr","16","0","entertainment",imagesd);
        tb.addContact("titan","17","0","eyewear",imagesd);
        tb.addContact("bata","18","0","footwear",imagesd);
        tb.addContact("health","19","0","pharmacy",imagesd);
        tb.addContact("valet","20","0","valet",imagesd);
        tb.addContact("home center","21","0","home furnishing",imagesd);
        tb.addContact("spar","22","0","hypermarket",imagesd);
        tb.addContact("gitanjali","23","0","jewellery",imagesd);
        tb.addContact("american tourister","24","0","luggage",imagesd);

        freeshops free =new freeshops(this);

        free.addshops("kfc","1","0");
        free.addshops("kfc","1","0");
        free.addshops("free","2","0");
        free.addshops("free","3","0");
        free.addshops("free","4","0");
        free.addshops("free","6","0");
        free.addshops("free","7","0");
        free.addshops("free","8","0");
        free.addshops("free","9","0");


    }

}