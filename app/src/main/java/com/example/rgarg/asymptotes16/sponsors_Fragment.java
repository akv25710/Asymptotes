package com.example.rgarg.asymptotes16;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by RGARG on 1/28/2016.
 */
public class sponsors_Fragment extends Fragment {
    @Nullable
    View rootView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.sponsors_layout,container,false);

//        ///// for back key /////////////////////////////
//        getActivity().getActionBar().hide();
//        rootView.setFocusableInTouchMode(true);
//        rootView.requestFocus();
//        rootView.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                Log.i(getTag(), "keyCode: " + keyCode);
//                if (keyCode == KeyEvent.KEYCODE_BACK) {
//                    getActivity().getActionBar().show();
//                    Log.i(getTag(), "onKey Back listener is working!!!");
//                    getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//                    // String cameback="CameBack";
//                    Intent i = new Intent(getActivity(), home_Fragment.class);
//                    // i.putExtra("Comingback", cameback);
//                    startActivity(i);
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        });
//        ///// for back key /////////////////////////////

        return rootView;
    }
}
