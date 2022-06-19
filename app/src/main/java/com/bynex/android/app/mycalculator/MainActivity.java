package com.bynex.android.app.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView display, displaySecond;
    Button zero, one, two, three, four, five, six,seven, eight, nine,
            dot, equals, multiplication, addition, substraction, divition, percentage, plusminus, delete, clear;
    Display dis;

    boolean calc = false, isRepeateValue = false;
    double prevValue = 0.0, repeatValue = 0.0;
    String currentOperator = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        dis = new Display(display, displaySecond, getApplicationContext());
    }

    public void zero (View view) {
        dis.setDisplay(Display.MAIN_DISPLAY, "0");
    }

    public void one(View view) {
        //String currentDisplay = getMainDisplay();

        if (getMainDisplay().length() < 15) {
            dis.setDisplay(Display.MAIN_DISPLAY, "1");
        } else {
            dis.setDisplay(Display.TOAST, "Can't enter more than 15 digits");
        }
    }

    public void two(View view) {
        //String currentDisplay = getMainDisplay();

        if (getMainDisplay().length() < 15) {
            dis.setDisplay(Display.MAIN_DISPLAY, "2");
        } else {
            dis.setDisplay(Display.TOAST, "Can't enter more than 15 digits");
        }
    }

    public void three(View view) {
    }

    public void four(View view) {
    }

    public void five(View view) {
    }

    public void six(View view) {
    }

    public void seven(View view) {
    }

    public void eight(View view) {
    }

    public void nine(View view) {
    }

    public void delete(View view) {
        dis.setDisplay(Display.MAIN_DISPLAY, Display.DEL);
    }

    public void clear(View view) {
        dis.isDisClear = false;
        prevValue = 0;
        calc = false;
        currentOperator = null;
        dis.setDisplay(Display.MAIN_DISPLAY, null);
    }

    public void percentage(View view) {

    }

    public void plusminus(View view) {
        String dis = display.getText().toString();

        if (dis.contains("-")) {
            if (dis.equals("-")) {
                display.setText("0");
            } else {
                display.setText(dis.substring(1, dis.length()));
            }
        } else {
            if (dis.equals("0")) {
                display.setText("-");
            } else {
                display.setText("-" + dis);
            }
        }
    }

    public void divition(View view) {

    }

    public void multiplication(View view) {

    }

    public void substraction(View view) {

    }

    public void addition(View view) {
        calc = true;
        prevValue = Double.parseDouble(getMainDisplay());
        dis.setDisplay(Display.SECOND_DISPLAY, "+");
        currentOperator = "+";
        dis.isDisClear = true;
    }

    public void equals(View view) {
        switch (currentOperator) {
            case "+":
                add();
                break;

            case "-":
                break;

            case "÷":
                break;

            case "×":
                break;
        }
    }

    public void dot(View view) {

        if (getMainDisplay().contains(".") && !dis.isDisClear) {
            return;
        }

        if (getMainDisplay().length() < 15) {
            dis.setDisplay(Display.MAIN_DISPLAY, ".");
        } else {
            dis.setDisplay(Display.TOAST, "Can't enter more than 15 digits");
        }
    }

    public void initialize() {
        display = findViewById(R.id.dis);
        displaySecond = findViewById(R.id.dis_second);
        one = findViewById(R.id.btn_one);
        two = findViewById(R.id.btn_two);
        three = findViewById(R.id.btn_three);
        four = findViewById(R.id.btn_four);
        five = findViewById(R.id.btn_five);
        six = findViewById(R.id.btn_six);
        seven = findViewById(R.id.btn_seven);
        eight = findViewById(R.id.btn_eight);
        nine = findViewById(R.id.btn_nine);
        zero = findViewById(R.id.btn_zero);
        clear = findViewById(R.id.btn_clear);
        percentage = findViewById(R.id.btn_percentage);
        plusminus = findViewById(R.id.btn_plusminus);
        divition = findViewById(R.id.btn_division);
        multiplication = findViewById(R.id.btn_multiplication);
        substraction = findViewById(R.id.btn_substraction);
        addition = findViewById(R.id.btn_addition);
        equals = findViewById(R.id.btn_equals);
        dot = findViewById(R.id.btn_dot);
        delete = findViewById(R.id.btn_delete);
    }

    private String getMainDisplay() {
        return display.getText().toString();
    }

    private void add() {
        double currentValue = Double.parseDouble(getMainDisplay());
        String res = (prevValue + currentValue) + "";
        dis.setDisplay(Display.LOG_CAT, prevValue + " " + currentValue);
        dis.isDisClear = true;

        if (res.substring(res.length() - 1, res.length()).equals("0")) {
            res = res.substring(0, res.length() - 2);
        }

        dis.setDisplay(Display.MAIN_DISPLAY, (res));
    }
}