package com.example.knp.first;

import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    String mCoords;
    TextView tvCs;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rrr=0;
        float x = event.getX();
        float y = event.getY();
        int oldD;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                /*
                float mx1 = event.getX(0);
                float my1 = event.getY(0);
                float mx2 = event.getX(1);
                float my2 = event.getY(1);

                int diam = (int) Math.sqrt((mx1-mx2)*(mx1-mx2)+(my1-my2)*(my1-my2));
                rrr = diam-iv.getLayoutParams().height;
                */
            case MotionEvent.ACTION_MOVE:
                mCoords = "Coords: x = " + x + ", y = " + y;

                iv.setRotationX(x);
                iv.setRotationY(y);

                //iv.setRotation(x);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:

                break;
        }
        if(event.getPointerCount()>1){
            float mx1 = event.getX(0);
            float my1 = event.getY(0);
            float mx2 = event.getX(1);
            float my2 = event.getY(1);

            int diam = (int) Math.sqrt((mx1-mx2)*(mx1-mx2)+(my1-my2)*(my1-my2));

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(diam-rrr,diam-rrr);
            lp.addRule(RelativeLayout.CENTER_VERTICAL);
            lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
            iv.setLayoutParams(lp);
        }
        tvCs.setText(mCoords);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView)findViewById(R.id.imageView);
        tvCs = (TextView)findViewById(R.id.tvCs);
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

        getSupportActionBar().hide();
    }
}
