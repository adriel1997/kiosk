package com.example.adriealle.kiosk;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by anant mehra on 24-06-2018.
 */

public class events_fragment extends android.support.v4.app.Fragment {

ListView lister;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)

    {

        View v=inflater.inflate(R.layout.activity_events_fragment,container,false);

        lister=(ListView)v.findViewById(R.id.listners);


        eventdata d=new eventdata(getActivity());
        SQLiteDatabase g=d.getReadableDatabase();

        Cursor c = g.query("EVENT", null, null, null, null, null, null);


        SimpleCursorAdapter p = new SimpleCursorAdapter(getActivity(),R.layout.eventorder,c,new String[] {"name","startdate","finishdate","starttime","finishtime"},new int [] {R.id.NAME,R.id.STARTD,R.id.FINISHD,R.id.STARTT,R.id.FININSHT},0);


        lister.setAdapter(p);

        return v;


    }
}
