package com.mllwf.propertyanimation;

import android.view.View;

/**
 * Created by ML on 2017/4/23.
 */

public class ViewWrapperAlpha {

    private View target;

    public ViewWrapperAlpha(View target) {
        this.target = target;
    }

    public float getAlpha(){
        return target.getAlpha();
    }

    public void serAlpha(float alpha) {
        target.setAlpha(alpha);
    }
}
