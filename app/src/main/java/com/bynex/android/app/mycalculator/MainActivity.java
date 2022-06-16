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
    Button one, two, three, four, five, six,seven, eight, nine, zero, dot, equals, multiplication, addition, substraction, divition, percentage, plusminus, delete, clear;
    Display dis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        dis = new Display(display, displaySecond, getApplicationContext());
    }

    public void zero (View view) {
    }

    public void one(View view) {
        dis.setDisplay(Display.MAIN_DISPLAY, "1");
    }

    public void two(View view) {
    }

    public void three(View view) {

    }

    public void four(View view) {
        String dis = display.getText().toString();
        if (dis.equals("0")) {
            display.setText("4");
        } else {
            display.setText(dis + "4");
        }
    }

    public void five(View view) {
        String dis = display.getText().toString();
        if (dis.equals("0")) {
            display.setText("5");
        } else {
            display.setText(dis + "5");
        }
    }

    public void six(View view) {
        String dis = display.getText().toString();
        if (dis.equals("0")) {
            display.setText("6");
        } else {
            display.setText(dis + "6");
        }
    }

    public void seven(View view) {
        String dis = display.getText().toString();
        if (dis.equals("0")) {
            display.setText("7");
        } else {
            display.setText(dis + "7");
        }
    }

    public void eight(View view) {
        String dis = display.getText().toString();
        if (dis.equals("0")) {
            display.setText("8");
        } else {
            display.setText(dis + "8");
        }
    }

    public void nine(View view) {
        String dis = display.getText().toString();
        if (dis.equals("0")) {
            display.setText("9");
        } else {
            display.setText(dis + "9");
        }
    }

    public void delete(View view) {

    }

    public void clear(View view) {
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


    }

    public void equals(View view) {

    }

    public void dot(View view) {
        String dis = display.getText().toString();
        if (!dis.contains(".")) {
            display.setText(dis + ".");
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
}