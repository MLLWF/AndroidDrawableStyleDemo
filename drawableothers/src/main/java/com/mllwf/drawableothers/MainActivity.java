package com.mllwf.drawableothers;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.iv);
        imageView.getDrawable().setLevel(5000);

        ImageView i = (ImageView) findViewById(R.id.iv_scale);
        i.getDrawable().setLevel(1000);

        ImageView levelList10 = (ImageView) findViewById(R.id.iv_levellist_10);
        levelList10.getDrawable().setLevel(0);
        ImageView levelList50 = (ImageView) findViewById(R.id.iv_levellist_50);
        levelList50.getDrawable().setLevel(50);
        ImageView levelList80 = (ImageView) findViewById(R.id.iv_levellist_80);
        levelList80.getDrawable().setLevel(80);
        ImageView levelList100 = (ImageView) findViewById(R.id.iv_levellist_100);
        levelList100.getDrawable().setLevel(100);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImageView transition = (ImageView) findViewById(R.id.iv_transition);
                ((TransitionDrawable) transition.getDrawable()).startTransition(500);

            }
        }, 3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImageView transition = (ImageView) findViewById(R.id.iv_transition);
                ((TransitionDrawable) transition.getDrawable()).reverseTransition(500);
                //                ((TransitionDrawable) transition.getDrawable()).resetTransition();
            }
        }, 6000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImageView rotate = (ImageView) findViewById(R.id.iv_rotate);
                rotate.getDrawable().setLevel(10000);
            }
        }, 3000);

        ImageView animationList = (ImageView) findViewById(R.id.iv_animation_list);
        ((AnimationDrawable) animationList.getDrawable()).start();
    }
}
