package com.example.rgarg.asymptotes16;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by RGARG on 1/28/2016.
 */
public class home_Fragment extends Fragment {
    @Nullable
    View rootView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.home_layout,container,false);
        return rootView;
    }
}
