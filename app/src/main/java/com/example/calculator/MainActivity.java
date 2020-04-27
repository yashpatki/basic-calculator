package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button equal;
    private Button delete;
    private Button decimal;
    private Button clear;
    private TextView control;
    private TextView result;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char DEC = '.';
    private final char EQ = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;



    //TESTED ON PIXEL 3 API 28 & NEXUS 5 API 24

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //final Stack<String> stack = new Stack<>();
        setupViews();
        try {
            zero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control.setText(control.getText().toString() + "0");
                }
            });

            one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control.setText(control.getText().toString() + "1");
                }
            });

            two.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control.setText(control.getText().toString() + "2");
                }
            });

            three.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control.setText(control.getText().toString() + "3");
                }
            });

            four.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control.setText(control.getText().toString() + "4");
                }
            });


            five.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control.setText(control.getText().toString() + "5");
                }
            });

            six.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control.setText(control.getText().toString() + "6");
                }
            });

            seven.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control.setText(control.getText().toString() + "7");
                }
            });

            eight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control.setText(control.getText().toString() + "8");
                }
            });

            nine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control.setText(control.getText().toString() + "9");
                }
            });

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        compute();
//                        if (String.valueOf(val1) == null)
//                            throw new NumberFormatException();
                        ACTION = ADDITION;
                        result.setText(String.valueOf(val1) + "+");
                        control.setText(null);
                    } catch (NumberFormatException e) {
                        result.setText("Invalid Input add");
                    }
                }
            });

            sub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        compute();
//                        if (String.valueOf(val1) == null)
//                            throw new NumberFormatException();
                        ACTION = SUBTRACTION;
                        result.setText(String.valueOf(val1) + "-");
                        control.setText(null);
                    }
                    catch (NumberFormatException e){
                        result.setText("Invalid Input");
                    }
                }
            });

            mul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        compute();
                        if(String.valueOf(val1) == null)
                            throw new NumberFormatException();
                        ACTION = MULTIPLICATION;
                        result.setText(String.valueOf(val1) + "*");
                        control.setText(null);
                    }
                    catch (NumberFormatException e){
                        result.setText("Invalid Input");
                    }
                }
            });

            div.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        compute();
                        if(String.valueOf(val1) == null)
                            throw new NumberFormatException();
                        ACTION = DIVISION;
                        result.setText(String.valueOf(val1) + "/");
                        control.setText(null);
                    }
                    catch (NumberFormatException e){
                        result.setText("Invalid Input");
                    }
                }

            });

            decimal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        String str = control.getText().toString();
                        control.setText(str+'.');
                    }
                    catch (NumberFormatException e){
                        result.setText("Invalid Input");
                    }
                }
            });

            equal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        compute();
                        ACTION = EQ;
                        if(String.valueOf(val1) == null)
                            throw new NumberFormatException();
                        if(result.getText().toString().contains("/")){
                            if (val2 == 0)
                                throw new ArithmeticException();
                        }

                        result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                        control.setText(null);
                    }
                    catch (ArithmeticException ae){
                        result.setText(null);
                        result.setText("Cannot Divide by 0");
                    }
                    catch (NumberFormatException e){
                        result.setText("Invalid Input!");
                    }
                }
            });
        }
        catch (NumberFormatException e){
            control.setText("Invalid Input!");
        }


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.NaN;
                val2 = Double.NaN;
                control.setText(null);
                result.setText(null);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(control.getText().length()>0){
                    CharSequence name = control.getText().toString();
                    control.setText(name.subSequence(0,name.length() - 1));
                }
                else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    control.setText(null);
                    result.setText(null);
                }
            }
        });
    }

    private void setupViews(){
        zero = (Button)findViewById(R.id.Btn0);
        one = (Button)findViewById(R.id.Btn1);
        two = (Button)findViewById(R.id.Btn2);
        three = (Button)findViewById(R.id.Btn3);
        four = (Button)findViewById(R.id.Btn4);
        five = (Button)findViewById(R.id.Btn5);
        six = (Button)findViewById(R.id.Btn6);
        seven = (Button)findViewById(R.id.Btn7);
        eight = (Button)findViewById(R.id.Btn8);
        nine = (Button)findViewById(R.id.Btn9);
        add = (Button)findViewById(R.id.BtnAdd);
        sub = (Button)findViewById(R.id.BtnSub);
        mul = (Button)findViewById(R.id.BtnMul);
        div = (Button)findViewById(R.id.BtnDiv);
        decimal = (Button)findViewById(R.id.Btndecimal);
        equal = (Button)findViewById(R.id.BtnEquals);
        delete = (Button)findViewById(R.id.BtnDel);
        clear = (Button)findViewById(R.id.BtnClear);
        control = (TextView)findViewById(R.id.tvControl);
        result = (TextView)findViewById(R.id.tvResult);

    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(control.getText().toString());
        switch (ACTION) {
            case ADDITION:
                val1 = val1 + val2;
                break;
            case SUBTRACTION:
                val1 = val1 - val2;
                break;
            case MULTIPLICATION:
                val1 = val1 * val2;
                break;
            case DIVISION:
                //try {
//                    if(val2 == 0)
//                        throw new ArithmeticException();
                    val1 = val1 / val2;
                    break;
                //}
//                catch (ArithmeticException ae){
//                    result.setText("Cannot Divide By 0");
//                }
            case EQ:
                break;
            }
        }
        else{
            val1 = Double.parseDouble(control.getText().toString());
        }
    }




}


