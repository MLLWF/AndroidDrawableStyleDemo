package com.mllwf.viewanimation;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImageView alpha = (ImageView) findViewById(R.id.iv_alpha);
                AlphaAnimation alphaAnimation = (AlphaAnimation) AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_alpha);
                alpha.startAnimation(alphaAnimation);

                ImageView scale = (ImageView) findViewById(R.id.iv_scale);
                Animation scaleAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_scale);
                scale.startAnimation(scaleAnimation);

                ImageView translate = (ImageView) findViewById(R.id.iv_translate);
                TranslateAnimation translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_translate);
                translate.startAnimation(translateAnimation);

                ImageView rotate = (ImageView) findViewById(R.id.iv_rotate);
                RotateAnimation rotateAnimation = (RotateAnimation) AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_rotate);
                rotate.startAnimation(rotateAnimation);

                ImageView set = (ImageView) findViewById(R.id.iv_set);
                Animation setAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_set);
                set.startAnimation(setAnimation);
            }
        }, 1000);

    }
}
