package com.example.nemes.transitionimagessamescreenexample.util;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.nemes.transitionimagessamescreenexample.R;

/**
 * Created by nemes on 04/06/2018.
 */

public class MyAnimationUtils
{
    public static void translateShow(View view, Context context)
    {
        Animation animationTranslate = AnimationUtils.loadAnimation(context, R.anim.anim_translate_in);
        view.setAnimation(animationTranslate);
        view.setVisibility(View.VISIBLE);
        animationTranslate.start();
    }

    public static void translateHide(View view, Context context, int duration)
    {
        Animation animationTranslate = AnimationUtils.loadAnimation(context, R.anim.anim_translate_out);
        view.setAnimation(animationTranslate);
        view.setVisibility(View.INVISIBLE);
        animationTranslate.setDuration(duration);
        animationTranslate.start();
    }
}
