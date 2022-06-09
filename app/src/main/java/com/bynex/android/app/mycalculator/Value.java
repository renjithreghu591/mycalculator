package com.bynex.android.app.mycalculator;

public class Value {
    private int intNum;
    private double dobNum;
    private final boolean isInt;

    Value(int intNum) {
        this.intNum = intNum;
        isInt = true;
    }

    Value(double dobNum) {
        this.dobNum = dobNum;
        isInt = false;
    }

    public void getValue() {

    }
}
