package com.example.adriealle.kiosk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class eventlist extends AppCompatActivity {
ListView lister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventlist);
    lister=(ListView)findViewById(R.id.eventlister);


        eventdata d=new eventdata(this);
        SQLiteDatabase g=d.getReadableDatabase();

    Cursor c = g.query("EVENT", null, null, null, null, null, null);


    SimpleCursorAdapter p = new SimpleCursorAdapter(this,R.layout.eventorder,c,new String[] {"name","startdate","finishdate","starttime","finishtime"},new int [] {R.id.NAME,R.id.STARTD,R.id.FINISHD,R.id.STARTT,R.id.FININSHT},0);


                lister.setAdapter(p);
                lister.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
            final int ID=i+1;
            new AlertDialog.Builder(eventlist.this)
                    .setMessage("have you checked everything?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            Intent re = new Intent(eventlist.this,eventlist.class);

                            eventdata tb=new eventdata(eventlist.this);
                            tb.delete(""+ID);
                            startActivity(re);

                        }
                    })
                    .setNegativeButton("No", null)
                    .show();


        }
    });
}
        }

