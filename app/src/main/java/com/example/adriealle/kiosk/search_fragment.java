package com.example.adriealle.kiosk;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by anant mehra on 24-06-2018.
 */

public class search_fragment extends android.support.v4.app.Fragment {

AutoCompleteTextView autoCompleteTextView;
    Button search;
    testdata d;
    Cursor c;
    ListView result;
    String Text;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)

    {

        View v=inflater.inflate(R.layout.search_fragment,container,false);
        autoCompleteTextView=(AutoCompleteTextView)v.findViewById(R.id.searchauto) ;
        search=(Button) v.findViewById(R.id.searchbutton) ;

        result=(ListView) v.findViewById(R.id.searchresult) ;
       d =new testdata(getActivity());

        ArrayList<String> gee= d.getprobnames();
        ArrayAdapter<String> geee=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,gee);
        autoCompleteTextView.setAdapter(geee);
        autoCompleteTextView.setThreshold(1);

search.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       Text= autoCompleteTextView.getText().toString();

        SQLiteDatabase g=d.getReadableDatabase();
        if(g!=null) {
            if(Text!=null){
                c = g.query("SAMPLE",null,"name=?",new String[]{Text}, null, null, null);}

            if (c != null) {
                SimpleCursorAdapter p = new SimpleCursorAdapter(getActivity(),R.layout.fulltable,c,new String[] {"name","shop","floor","cat"},new int [] {R.id.NA,R.id.SH,R.id.FL,R.id.CA},0);
                p.setViewBinder(new ListViewBinder());
                result.setAdapter(p);

            }
        }
    }



});



                result.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int ID=i+1;
                String s = result.getItemAtPosition(i).toString();

                String name = adapterView.getItemAtPosition(i).toString();

                Toast.makeText(getActivity(),"s "+s+"  name "+name , Toast.LENGTH_SHORT).show();

             //   Intent re = new Intent(Imagelisting.this,Main2Activity.class);
               // re.putExtra("id",""+ID);

                Toast.makeText(getActivity(),""+ i, Toast.LENGTH_SHORT).show();
                //startActivity(re);
            }
        });

        return v;


    }
}
