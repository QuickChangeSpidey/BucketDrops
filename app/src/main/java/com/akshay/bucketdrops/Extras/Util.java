package com.akshay.bucketdrops.Extras;

import android.view.View;

import java.util.List;

/**
 * Created by akshay on 3/26/17.
 */

public class Util {
    public static void showViews(List<View> views) {
        for (View view : views) {
            view.setVisibility(View.VISIBLE);
        }
    }

    public static void hideViews(List<View> views) {
        for (View view : views) {
            view.setVisibility(View.GONE);
        }
    }
}

