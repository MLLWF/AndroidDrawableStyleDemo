package com.mllwf.propertyanimation;

import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by ML on 2017/4/23.
 */
public class ViewWrapperMarginTop {
    private View target;
    private int manWidth;

    public ViewWrapperMarginTop(View target, int manWidth) {
        this.target = target;
        this.manWidth = manWidth;
    }

    //TODO: get方法是用来配置初始值，set方法是用来设置动画过程的值

    public int getWidth() {
        return target.getLayoutParams().width;
    }

    public void setWidth(int widthValue) {
        target.getLayoutParams().width = manWidth * widthValue / 100;
        target.requestLayout();
    }

    public int getMarginTop() {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) target.getLayoutParams();
        return params.topMargin;
    }

    public void setMarginTop(int margin) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) target.getLayoutParams();
        params.setMargins(params.leftMargin, margin, params.rightMargin, params.bottomMargin);
        target.setLayoutParams(params);

    }
}
