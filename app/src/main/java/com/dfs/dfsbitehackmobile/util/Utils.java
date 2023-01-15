package com.dfs.dfsbitehackmobile.util;

import android.util.TypedValue;

import androidx.appcompat.app.AppCompatActivity;

public class Utils {
    public static int convertDpToPx(int dp, AppCompatActivity activity) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                activity.getResources().getDisplayMetrics()
        );
    }
}
