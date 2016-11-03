package com.example.rgarg.asymptotes16;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

/**
 * Created by RGARG on 2/3/2016.
 */
public class splash_Screen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        int secondsDelayed = 5;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(splash_Screen.this, MainActivity.class));
                finish();
            }
        }, secondsDelayed * 1000);
    }
}
