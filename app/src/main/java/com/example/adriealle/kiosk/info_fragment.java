package com.example.adriealle.kiosk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Adriealle on 21-07-2018.
 */

public class info_fragment extends android.support.v4.app.Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)

    {

        View v = inflater.inflate(R.layout.activity_info_fragment, container, false);

        return v;

    }
}