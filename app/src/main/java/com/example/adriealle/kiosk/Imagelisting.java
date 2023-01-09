package com.example.adriealle.kiosk;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Imagelisting extends AppCompatActivity {
    String CAT;
    ListView v;
    Cursor c;
    testdata d;
    SQLiteDatabase g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagelisting);

        try {
            CAT = getIntent().getExtras().getString("cat");
        }
        catch (Exception e){

            CAT=null;
        }

        v = (ListView)findViewById(R.id.thee);
        d=new testdata(this);
        g=d.getReadableDatabase();
        if (CAT!=null)
        {
            c = g.query("SAMPLE",null,"cat=?",new String[]{CAT}, null, null, null);
        }

        else{
            c = g.query("SAMPLE", null, null, null, null, null, null);
        }

        SimpleCursorAdapter p = new SimpleCursorAdapter(this,R.layout.testorder,c,new String[] {"name","img"},new int [] {R.id.name,R.id.img},0);
        p.setViewBinder(new ListViewBinder());
        v.setAdapter(p);
        v.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                long ID=l;
                String s = v.getItemAtPosition(i).toString();

                String name; //= adapterView.getItemAtPosition(i).toString();

                //Toast.makeText(Imagelisting.this,"s "+s+"  name "+name , Toast.LENGTH_SHORT).show();
                Intent re = new Intent(Imagelisting.this,pop.class);
                re.putExtra("id",""+ID);
                //name=d.getnamefromlist(l);
                //Toast.makeText(Imagelisting.this,""+ l, Toast.LENGTH_SHORT).show();
                startActivity(re);
            }
        });
    }
}
