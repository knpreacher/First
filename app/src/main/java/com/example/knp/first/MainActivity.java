package com.example.knp.first;

import android.os.Handler;
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

            Handler handler;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        if(handler!=null) return true;
                        handler = new Handler();
                        handler.post(action);
                        break;
                    case MotionEvent.ACTION_UP:
                        if(handler==null)return true;
                        handler.removeCallbacks(action);
                        handler = null;
                        break;
                }
                return false;
            }

            Runnable action = new Runnable() {
                @Override
                public void run() {
                    iv.setRotation(iv.getRotation()-4);
                    handler.postDelayed(this,20);
                }
            };
        });
        bright.setOnTouchListener(new View.OnTouchListener() {
            Handler handler;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        if(handler!=null) return true;
                        handler = new Handler();
                        handler.post(action);
                        break;
                    case MotionEvent.ACTION_UP:
                        if(handler==null)return true;
                        handler.removeCallbacks(action);
                        handler = null;
                        break;
                }
                return false;
            }
            Runnable action = new Runnable() {
                @Override
                public void run() {
                    iv.setRotation(iv.getRotation()+4);
                    handler.postDelayed(this,20);
                }
            };
        });

        ActionBar ab = getSupportActionBar();
        ab.hide();
    }
}
