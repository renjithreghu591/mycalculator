package com.bynex.android.app.mycalculator;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Display {
    private TextView mainDisplay, secondDisplay;
    private Context context;
    private Toast toast;
    public static final int LOG_CAT = 0, MAIN_DISPLAY = 1, SECOND_DISPLAY = 2, TOAST = 3;
    public static final String DEL = "DEL";
    public boolean isDisClear = false, isSecDisClear = false;

    public Display (TextView mainDisplay, TextView secondDisplay, Context context) {
        this.mainDisplay = mainDisplay;
        this.secondDisplay = secondDisplay;
        this.context = context;
    }

    public void setDisplay (int dis, String value) {
        switch (dis) {
            // log cat
            case 0:
                Log.i("mylogcat", value);
                break;

            // main display
            case 1:
                setMainDisplay(value);
                break;

            // second display
            case 2:
                setSecondDisplay(value);
                break;

            // toast
            case 3:
                try {
                    toast.getView().isShown();
                    toast.setText(value);
                } catch (Exception e) {
                    toast = Toast.makeText(context, value, Toast.LENGTH_SHORT);
                }
                toast.show();
                break;
        }
    }

    private void setMainDisplay (String input) {
        String currentDisplayValue = mainDisplay.getText().toString();

        if (!isDisClear) {
            if (input == null) {
                mainDisplay.setText("0");
                return;
            }

            if (input.equals(DEL)) {
                if (currentDisplayValue.length() > 1) {
                    mainDisplay.setText(currentDisplayValue.substring(0, currentDisplayValue.length() - 1));
                } else if (!currentDisplayValue.equals("0")) {
                    mainDisplay.setText("0");
                }
                return;
            }

            if (currentDisplayValue.equals("0")) {
                if (input.equals("0")) {
                    return;
                }

                currentDisplayValue = "";
            }

            mainDisplay.setText(currentDisplayValue + input);
        } else {
            if (input.equals(".")) {
                mainDisplay.setText("0.");
            } else {
                mainDisplay.setText(input);
            }
            isDisClear = false;
        }

    }

    private void setSecondDisplay(String opr) {
        if (!isSecDisClear) {
            String value = mainDisplay.getText().toString();

            if (value.substring(value.length() - 1, value.length()).equals("0")) {
                value = value.substring(0, value.length() - 2);
            } else if (value.substring(value.length() - 1, value.length()).equals(".")) {
                value = value.substring(0, value.length() - 1);
            }

            switch (opr) {
                case "+":
                    secondDisplay.setText(value + " " + opr);
                    break;
            }
        }

    }
}
