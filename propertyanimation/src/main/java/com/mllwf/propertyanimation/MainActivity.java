package com.mllwf.propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
// TODO: 2017/4/23  ObjectAnimator和ValueAnimator的区别
//ObjectAnimator提供了属性的设置，但相应的需要有该属性的setter和getter方法。而ValueAnimator则只是定义了值的变化，并不指定目标属性，所以也不需要提供setter和getter方法，
//但只能在AnimatorUpdateListener监听器里手动更新属性。不过，也因为没有指定属性，所以其实更具灵活性了，你可以在监听器里根据值的变化做任何事情，比如更新多个属性，比如在缩放宽度的同时做垂直移动。
//
//为了对View更方便的设置属性动画，Android系统也提供了View的一些属性和相应的setter和getter方法：
//
//        alpha：透明度，默认为1，表示不透明，0表示完全透明
//        pivotX 和 pivotY：旋转的轴点和缩放的基准点，默认是View的中心点
//        scaleX 和 scaleY：基于pivotX和pivotY的缩放，1表示无缩放，小于1表示收缩，大于1则放大
//        rotation、rotationX 和 rotationY：基于轴点(pivotX和pivotY)的旋转，rotation为平面的旋转，rotationX和rotationY为立体的旋转
//        translationX 和 translationY：View的屏幕位置坐标变化量，以layout容器的左上角为坐标原点
//        x 和 y：View在父容器内的最终位置，是左上角坐标和偏移量（translationX，translationY）的和

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onScaleWidth(final View view) {
        final int maxWidth = getWindowManager().getDefaultDisplay().getWidth(); //获得屏幕的宽度
        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.valueanimator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 当前动画值，即为当前宽度比例值
                int currentValue = (int) animation.getAnimatedValue();
                System.out.println("currentValue:" + currentValue);//
                int correctWidth = maxWidth * currentValue / 100;
                System.out.println("correctWidth:" + correctWidth);//
                //TODO: 注意：这里需要的是int整形的数据类型，所以如果先算百分比，当动画之小于100时，就会自动转化成0导致动画出现问题
                int errorWidth = maxWidth * (currentValue / 100);
                System.out.println("errorWidth:" + errorWidth);//
                view.getLayoutParams().width = maxWidth * currentValue / 100;
                view.requestLayout();
            }
        });
        valueAnimator.start();
    }

    public void onObjectAnimatorWidth(View view) {
        int maxWidth = getWindowManager().getDefaultDisplay().getWidth();
        // 将目标view进行包装
        ViewWrapper wrapper = new ViewWrapper(view, maxWidth);

        ObjectAnimator objectanimator = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.objectanimator);
        // 设置动画的目标对象为包装后的view
        objectanimator.setTarget(wrapper);

        objectanimator.start();
    }

    public void onAnimatorSetWidthMarginTop(View view) {
        int maxWidth = getWindowManager().getDefaultDisplay().getWidth();

        ViewWrapperMarginTop margin = new ViewWrapperMarginTop(view, maxWidth);

        Animator set = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.animatorset_width_and_margintop);

        set.setTarget(margin);

        set.start();
    }

    public void onAnimatorFadeIn(View view) {

        ViewWrapperAlpha alpha = new ViewWrapperAlpha(view);

        ObjectAnimator alphaAnimartor = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.objectanimartor_alpha);

        alphaAnimartor.setTarget(alpha);

        alphaAnimartor.start();
    }
}
