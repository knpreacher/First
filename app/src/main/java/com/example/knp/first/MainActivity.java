package com.example.knp.first;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView)findViewById(R.id.imageView);

        Button bleft = (Button)findViewById(R.id.bleft);
        Button bright = (Button)findViewById(R.id.bright);

        bleft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                while (event.getAction()==MotionEvent.ACTION_DOWN){
                    iv.setRotation(iv.getRotation()-1);
                    return false;
                }
                /*
                if(event.getAction()==MotionEvent.ACTION_BUTTON_PRESS){
                    iv.setRotation(iv.getRotation()-1);
                }
                */
                return false;
            }
        });
        bright.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    iv.setRotation(iv.getRotation()+1);
                }
                return false;
            }
        });

        ActionBar ab = getSupportActionBar();
        ab.hide();
    }
}
