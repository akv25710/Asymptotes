package com.example.rgarg.asymptotes16;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by RGARG on 1/28/2016.
 */
public class events_Fragment extends Fragment {
    @Nullable
    View rootView;
    ImageButton FAB;
    String[] mTitle;
    String[] mDescriptions;
    String[] mDate;
    String[] mVenue;
    String[] mTime;
    ListView list;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.events_layout, container, false);
        Resources res=getResources();
        mTitle= res.getStringArray(R.array.titles);
        mDescriptions= res.getStringArray(R.array.descriptions);
        mDate= res.getStringArray(R.array.date);
        mVenue= res.getStringArray(R.array.venue);
        mTime = res.getStringArray(R.array.time);

        list= (ListView) rootView.findViewById(R.id.events_list);

        MyAdapter adapter=new MyAdapter(rootView.getContext(),mTitle,mDescriptions,mDate,mVenue,mTime);
        list.setAdapter(adapter);


        FAB = (ImageButton) rootView.findViewById(R.id.registration_logo);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new register_Fragment();
                // consider using Java coding conventions (upper first char class names!!!)
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.container, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();
            }
        });


        return rootView;
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String[] titleArray;
        String[] descriptionArray;
        String[] dateArray;
        String[] venueArray;
        String[] timeArray;

        public MyAdapter(Context c, String[]titles,String[]descriptions,String[]date,String[]venue,String[] time) {
            super(c, R.layout.event_row,R.id.title_text,titles);
            this.context = c;
            this.titleArray=titles;
            this.descriptionArray=descriptions;
            this.dateArray=date;
            this.venueArray=venue;
            this.timeArray=time;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.event_row,parent,false);

            TextView myTitle= (TextView) row.findViewById(R.id.title_text);
            TextView myDescription= (TextView) row.findViewById(R.id.description_text);
            TextView myDate= (TextView) row.findViewById(R.id.date_text);
            TextView myVenue= (TextView) row.findViewById(R.id.venue_text);
            TextView myTime = (TextView) row.findViewById(R.id.time_text);

            myTitle.setText(titleArray[position]);
            myDescription.setText(descriptionArray[position]);
            myDate.setText(dateArray[position]);
            myVenue.setText(venueArray[position]);
            myTime.setText(timeArray[position]);

            return row;
        }
    }
}
