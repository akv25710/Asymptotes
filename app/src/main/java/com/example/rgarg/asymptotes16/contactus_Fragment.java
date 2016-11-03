package com.example.rgarg.asymptotes16;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.FragmentManager;
import android.app.FragmentManager.OnBackStackChangedListener;
import android.view.KeyEvent;
import android.util.Log;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by RGARG on 1/28/2016.
 */
public class contactus_Fragment extends Fragment {
    @Nullable
    View rootView;
    EditText name;
    EditText comment;
    Button compose_button;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.contactus_layout,container,false);
        name = (EditText) rootView.findViewById(R.id.name_text);
        comment = (EditText) rootView.findViewById(R.id.comment_text);
        compose_button = (Button)rootView.findViewById(R.id.compose_button);

        compose_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String to = "macs2k15@gmail.com";
                String subject = "Feedback from - " + name.getText().toString();
                String message = comment.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
                //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                        alertDialog.setTitle(" THANK YOU! ");
                        alertDialog.setMessage(" Thank you for your contribution. ");
                        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Fragment newFragment = new home_Fragment();
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
                        alertDialog.setIcon(R.drawable.ic_check_circle_white_24dp);
                        alertDialog.show();
                    }
                }, 8000);


            }
        });


        return rootView;
    }
}
