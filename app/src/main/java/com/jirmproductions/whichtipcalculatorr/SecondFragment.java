package com.jirmproductions.whichtipcalculatorr;

/**
 * Created by Josh on 12/10/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class SecondFragment extends Fragment {


    public SecondFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        ((GridView) rootView.findViewById(R.id.gridView1)).setAdapter(new ArrayAdapter(getActivity(),
                R.layout.my_text_view, new String[]
                {       "Food Server\t\t", "         15-25%",
                        "Bartender\t\t\t", "         15-20%",
                        "Cleaning Service\t", "         15-20%",
                        "Hairstylist\t\t", "         20%",
                        "Valet\t\t\t\t", "         $5.00",
                        "Room Service\t\t", "         15-20%",
                        "Taxi Driver\t\t", "         15%"}));
        return rootView;
    }

}
