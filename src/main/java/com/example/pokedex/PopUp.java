package com.example.pokedex;

import android.content.res.Configuration;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public class PopUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        getWindow().setBackgroundDrawableResource(R.drawable.pop_up_background);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            getWindow().setLayout((int) (width * .6), (int) (height * .4));
        else
            getWindow().setLayout((int) (width * .4), (int) (height * .5));


    }

    @Override
    protected void onStop() {
        super.onStop();
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    MainActivity.dim.setVisibility(View.INVISIBLE);
                }
            }, 100);
        }else{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    MainActivity.dim.setVisibility(View.INVISIBLE);
                }
            }, 50);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.dim.setVisibility(View.VISIBLE);
            }
        }, 25);
    }
}
