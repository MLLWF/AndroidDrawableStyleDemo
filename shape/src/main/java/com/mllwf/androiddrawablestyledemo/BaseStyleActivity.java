package com.mllwf.androiddrawablestyledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseStyleActivity extends AppCompatActivity {

    private boolean showRectangle = true;
    private boolean showOval = false;
    private boolean showLine = false;
    private boolean showRing = false;
    private boolean[] styles = new boolean[]{showRectangle, showOval, showLine, showRing};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(3);
        if (styles[0]) {
            setContentView(R.layout.activity_rectangle_view);
        } else if (styles[1]) {
            setContentView(R.layout.activity_oval_view);
        } else if (styles[2]) {
            setContentView(R.layout.activity_line_view);
        } else if (styles[3]) {
            setContentView(R.layout.activity_ring_view);
        }
    }

    private void initData(int showIndex) {
        for (int i = 0; i < styles.length; i++) {
            styles[i] = false;
            if (showIndex == i) {
                styles[showIndex] = true;
                break;
            }
        }
    }
}
