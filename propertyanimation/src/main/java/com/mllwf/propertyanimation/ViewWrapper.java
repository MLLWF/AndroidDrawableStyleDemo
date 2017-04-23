package com.mllwf.propertyanimation;

import android.view.View;

/**
 * Created by ML on 2017/4/23.
 */
public class ViewWrapper {
    private View target;
    private int manWidth;

    public ViewWrapper(View target, int manWidth) {
        this.target = target;
        this.manWidth = manWidth;
    }

    public int getWidth() {
        return target.getLayoutParams().width;
    }

    public void setWidth(int widthValue) {
        target.getLayoutParams().width = manWidth * widthValue / 100;
        target.requestLayout();
    }
}
