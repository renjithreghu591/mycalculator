package com.bynex.android.app.mycalculator;

import android.util.Log;

public class MyLogCat {
    void print(String str) {
        Log.i("hello", str);
    }

    void print(double d) {
        Log.i("hello", d + "");
    }

    void print(int i) {
        Log.i("hello", i + "");
    }

    void print(char c) {
        Log.i("hello", c + "");
    }
}
