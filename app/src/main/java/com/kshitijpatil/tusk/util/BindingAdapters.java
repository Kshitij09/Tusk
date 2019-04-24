package com.kshitijpatil.tusk.util;

import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.databinding.BindingAdapter;

public class BindingAdapters {

    @BindingAdapter("android:src")
    public static void setImageDrawable(ImageView view, @DrawableRes int resId) {
        view.setImageDrawable(view.getContext().getDrawable(resId));
    }
}


