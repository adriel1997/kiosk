package com.example.adriealle.kiosk;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class fragment1 extends android.support.v4.app.Fragment {
    Cursor c;
    String data;

    public fragment1() {
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)

    {

        View v=inflater.inflate(R.layout.fragment1,container,false);
        final ListView text = (ListView) v.findViewById(R.id.result);//Find textview Id

        //Get Argument that passed from activity in "data" key value
        data = getArguments().getString("data");

        testdata d =new testdata(getActivity());
        SQLiteDatabase g=d.getReadableDatabase();
        if(g!=null) {
            if(data!=null){
                c = g.query("SAMPLE",null,"cat=?",new String[]{data}, null, null, null);}

            if (c != null) {
                SimpleCursorAdapter p = new SimpleCursorAdapter(getActivity(),R.layout.fulltable,c,new String[] {"name","shop","floor","cat"},new int [] {R.id.NA,R.id.SH,R.id.FL,R.id.CA},0);
                //   p.setViewBinder(new ListViewBinder());
                text.setAdapter(p);

            }
        }
        text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                long ID=l;
                Intent re = new Intent(getActivity(),Main2Activity.class);
                re.putExtra("id",""+ID);
                startActivity(re);
            }
        });


        return v;


    }

}