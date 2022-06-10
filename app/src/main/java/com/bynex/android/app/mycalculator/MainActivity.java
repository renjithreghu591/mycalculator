package com.bynex.android.app.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView display, displaySecond;
    Button one, two, three, four, five, six, seven, eight, nine, zero, dot, equals, multiplication, addition, substraction, divition, percentage, plusminus, delete, clear;

    String currentOperator;
    double prevDobNum, repeatValue;
    boolean calc = false;
    boolean operatorDisClear = false;
    MyLogCat myLogCat = new MyLogCat();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    public void zero (View view) {

        String dis = display.getText().toString();
        if (display.getText().toString().equals("0")) {
            display.setText(dis + ".");
        } else {
            display.setText(dis + "0");
        }
    }

    public void one(View view) {

        if (operatorDisClear) {
            display.setText("0");
            operatorDisClear = false;
        }

        String dis = display.getText().toString();
        if (dis.equals("0")) {
            display.setText("1");
        } else {
            display.setText(dis + "1");
        }
    }

    public void two(View view) {
        if (operatorDisClear) {
            display.setText("0");
            operatorDisClear = false;
        }

        String dis = display.getText().toString();
        if (dis.equals("0")) {
            display.setText("2");
        } else {
            display.setText(dis + "2");
        }
    }

    public void three(View view) {
        if (operatorDisClear) {
            display.setText("0");
            operatorDisClear = false;
        }

        String dis = display.getText().toString();
        if (dis.equals("0")) {
            display.setText("3");
        } else {
            display.setText(dis + "3");
        }
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
        String dis = display.getText().toString();
        if (dis.length() > 1) {
            display.setText(dis.substring(0, dis.length() - 1));
        } else {
            display.setText("0");
        }
    }

    public void clear(View view) {
        display.setText("0");
        displaySecond.setText("");
        prevDobNum = 0;
        repeatValue = 0;
        calc = false;
        operatorDisClear = false;
        currentOperator = null;
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

    }public void multiplication(View view) {

    }public void substraction(View view) {

    }

    public void addition(View view) {
        String dis = display.getText().toString();
        setDisplaySecond(dis, "+");
        repeatValue = 0;
        prevDobNum = Double.parseDouble(dis);
        currentOperator = "+";
        operatorDisClear = true;
        calc = true;

    }

    public void equals(View view) {
        if (calc) {
            String res;
            switch (currentOperator) {
                case "+":
                    if (repeatValue == 0) {
                        double currentDouNum = Double.parseDouble(display.getText().toString());
                        res = (prevDobNum + currentDouNum) + "";
                        if (res.contains(".")) {
                            if (res.substring(res.length() - 1, res.length()).equals("0")) {
                                display.setText(res.substring(0, res.length() - 2));
                            } else {
                                display.setText(res);
                            }
                            repeatValue = currentDouNum;
                            res = currentDouNum + "";
                            if (res.substring(res.length() - 1, res.length()).equals("0")) {
                                setDisplaySecond(res.substring(0, res.length() - 2), "=");
                            } else {
                                setDisplaySecond(res, "=");
                            }
                        }
                    } else {
                        double currentDouNum = Double.parseDouble(display.getText().toString());

                        // finding previous value from second display
                        String sDis = displaySecond.getText().toString();
                        for (int i = 0; i < sDis.length(); i++) {
                            if (sDis.substring(i, i + 1).equals(" ")) {
                                sDis = sDis.substring(i, sDis.length());
                                break;
                            }
                        }


                        res = (currentDouNum + repeatValue) + "";
                        if (res.contains(".")) {
                            if (res.substring(res.length() - 1, res.length()).equals("0")) {
                                display.setText(res.substring(0, res.length() - 2));
                                String sCurrentDouNum = currentDouNum + "";
                                if (sCurrentDouNum.contains(".")) {
                                    if (sCurrentDouNum.substring(sCurrentDouNum.length() - 1, sCurrentDouNum.length()).equals("0")) {
                                        displaySecond.setText(sCurrentDouNum.substring(0, sCurrentDouNum.length() - 2) + sDis);
                                    } else {
                                        displaySecond.setText(sCurrentDouNum + sDis);
                                    }
                                } else {
                                    displaySecond.setText(sCurrentDouNum + sDis);
                                }
                            } else {
                                display.setText(res);
                            }
                        }
                    }
                    operatorDisClear = true;
                    break;

                case "-":

                    break;

                case "÷":

                    break;

                case "×":

                    break;

                default:
                    myLogCat.print("default switch case");
                    break;
            }
        }
    }

    public void dot(View view) {
        String dis = display.getText().toString();
        if (dis.contains(".")) {
        } else {
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

    void setDisplaySecond (String value, String op) {
        String dis = displaySecond.getText().toString();
        if (dis.equals("")) {
            displaySecond.setText(value + " " + op);
        } else if (dis.substring(dis.length() - 1, dis.length()).equals("=")) {
            dis = dis.substring(0, dis.length() - 1);
            displaySecond.setText(dis + op);
        } else {
            displaySecond.setText(dis + " " + value + " " + op);
        }
    }
}