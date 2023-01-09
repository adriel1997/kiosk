package com.example.adriealle.kiosk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anant mehra on 24-06-2018.
 */

public class original_fragment extends android.support.v4.app.Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)

    {

        View v=inflater.inflate(R.layout.original_fragment,container,false);


        return v;


    }
}
