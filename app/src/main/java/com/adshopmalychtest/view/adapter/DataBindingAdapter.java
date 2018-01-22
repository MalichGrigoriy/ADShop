package com.adshopmalychtest.view.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.databinding.BindingAdapter;
import android.os.Build;
import android.view.View;

import com.adshopmalychtest.util.Log;

public class DataBindingAdapter {

    private static int animatedVisibilityFlag = -7;

    @BindingAdapter("myVisibility")
    public static void myVisibility(View view, int shouldShow) {
        view.setVisibility(shouldShow);
    }

    @BindingAdapter("animatedVisibilityAlpha")
    public static void setVisibilityAlpha(final View view,
                                          final int visibility) {

        Integer endAnimVisibility =
                (Integer) view.getTag(animatedVisibilityFlag);
        int oldVisibility = endAnimVisibility == null
                ? view.getVisibility()
                : endAnimVisibility;

        if (oldVisibility == visibility) {
            return;
        }

        boolean isVisibile = oldVisibility == View.VISIBLE;
        boolean willBeVisible = visibility == View.VISIBLE;

        view.setVisibility(View.VISIBLE);
        float startAlpha = isVisibile ? 1f : 0f;
        if (endAnimVisibility != null) {
            startAlpha = view.getAlpha();
        }
        float endAlpha = willBeVisible ? 1f : 0f;

        // create an animator
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view,
                View.ALPHA, startAlpha, endAlpha);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            alpha.setAutoCancel(true);
        }

        alpha.addListener(new AnimatorListenerAdapter() {
            private boolean isCanceled;

            @Override
            public void onAnimationStart(Animator anim) {
                view.setTag(animatedVisibilityFlag, visibility);
            }

            @Override
            public void onAnimationCancel(Animator anim) {
                isCanceled = true;
            }

            @Override
            public void onAnimationEnd(Animator anim) {
                view.setTag(animatedVisibilityFlag, null);
                if (!isCanceled) {
                    view.setAlpha(1f);
                    view.setVisibility(visibility);
                }
            }
        });
        alpha.setDuration(250);
        alpha.start();
        Log.d("start animation");
    }

    @BindingAdapter({"animateRotation", "startRotatePosition", "endRotatePosition"})
    public static void setVisibilityAlpha(final View view, final boolean state, final float startPosition, final float endPosition) {

//        Integer endAnimVisibility =
//                (Integer) view.getTag(animatedVisibilityFlag);
//        int oldVisibility = endAnimVisibility == null
//                ? view.getVisibility()
//                : endAnimVisibility;

        if (state && view.getRotation() == endPosition || !state && view.getRotation() == startPosition) {
            return;
        }
//
//        boolean isVisibile = oldVisibility == View.VISIBLE;
//        boolean willBeVisible = visibility == View.VISIBLE;
//
//        view.setVisibility(View.VISIBLE);
//        float startAlpha = isVisibile ? 1f : 0f;
//        if (endAnimVisibility != null) {
//            startAlpha = view.getAlpha();
//        }
//        float endAlpha = willBeVisible ? 1f : 0f;

        // create an animator
        ObjectAnimator rotation;
        if (state)
            rotation = ObjectAnimator.ofFloat(view,
                    View.ROTATION, view.getRotation(), endPosition);
        else
            rotation = ObjectAnimator.ofFloat(view,
                    View.ROTATION, view.getRotation(), startPosition);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            rotation.setAutoCancel(true);
        }

        rotation.addListener(new AnimatorListenerAdapter() {
            private boolean isCanceled;

            @Override
            public void onAnimationStart(Animator anim) {
//                view.setTag(animatedVisibilityFlag, visibility);
            }

            @Override
            public void onAnimationCancel(Animator anim) {
                isCanceled = true;
            }

            @Override
            public void onAnimationEnd(Animator anim) {
                view.setTag(animatedVisibilityFlag, null);
                if (!isCanceled) {
                    if (state)
                        view.setRotation(endPosition);
                    else
                        view.setRotation(startPosition);
                }
            }
        });
        rotation.setDuration(250);
        rotation.start();
        Log.d("start animation");
    }
}
