package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    String expression = new String();
    long ans = 0;
    TextView expView;
    TextView ansView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expView = (TextView) findViewById(R.id.expressionView);
        ansView = (TextView) findViewById(R.id.answerView);
        setOnclickButton();
    }

    public void addToString(char c) {
        if(expression.equals("")){
            expView.setTextAppearance(this, R.style.current_style);
            ansView.setTextAppearance(this, R.style.blur_style);
        }
        expression += c;
        expView.setText(expression);
        stringToAnswer();

    }
    public void addOperatorToString(char c) {
        if(expression.equals("")){
            expression +=Long.toString(ans);
            expView.setTextAppearance(this, R.style.current_style);
            ansView.setTextAppearance(this, R.style.blur_style);
        }
        if("+-×÷".indexOf(expression.charAt(expression.length() - 1)) == -1){
            expression += c;
            expView.setText(expression);
            stringToAnswer();
        }

    }

    public void stringToAnswer() {


        Vector<String> operator = new Vector<String>();
        Collections.addAll(operator, expression.split("[0-9]+"));
        Vector<String> operands = new Vector<String>();
        Collections.addAll(operands, expression.split("[×÷+-]"));
        if(operator.size()!= 0 ) operator.remove(0);
        if(operands.size() == operator.size()) operator.remove(operator.size()-1);

        try {
            try {
                for (int i = 0; i < operator.size(); i++) {
                    if (operator.get(i).equals("×")) {
                        long tmp = Long.parseLong(operands.get(i)) * Long.parseLong(operands.get(i + 1));
                        operands.remove(i + 1);
                        operator.remove(i);
                        operands.set(i, Long.toString(tmp));
                        i--;
                        continue;
                    }
                    if (operator.get(i).equals("÷")) {
                        long tmp = Long.parseLong(operands.get(i)) / Long.parseLong(operands.get(i + 1));
                        operands.remove(i + 1);
                        operator.remove(i);
                        operands.set(i, Long.toString(tmp));
                        i--;
                    }
                }


                long tmp = Long.parseLong(operands.get(0));
                for (int i = 0; i < operator.size(); i++) {

                    if (operator.get(i).equals("+")) {
                        tmp += Long.parseLong(operands.get(i + 1));
                    }
                    if (operator.get(i).equals("-")) {
                        tmp -= Long.parseLong(operands.get(i + 1));
                    }
                }
                ans = tmp;
                ansView.setText("=" + Long.toString(tmp));

            } catch (ArithmeticException e) {
                ansView.setText("Divided by zero operation cannot possible");
            }
        }catch (NumberFormatException e){
            ansView.setText("Long limit exceeded");
        }

    }
    public void changeCurrentToAns(){
        ansView.setTextAppearance(this, R.style.current_style);
        expView.setTextAppearance(this, R.style.blur_style);
    }

    public void setOnclickButton() {
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button button0 = (Button) findViewById(R.id.button0);
        Button buttonAC = (Button) findViewById(R.id.buttonAC);
        ImageButton buttonAdd = (ImageButton) findViewById(R.id.buttonAdd);
        ImageButton buttonSub = (ImageButton) findViewById(R.id.buttonSub);
        ImageButton buttonMul = (ImageButton) findViewById(R.id.buttonMul);
        ImageButton buttonDiv = (ImageButton) findViewById(R.id.buttonDiv);
        ImageButton buttonBack = (ImageButton) findViewById(R.id.buttonBack);
        ImageButton buttonCal = (ImageButton) findViewById(R.id.buttonCal);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToString('1');

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToString('1');

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToString('2');

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToString('3');

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToString('4');

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToString('5');

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToString('6');

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToString('7');

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToString('8');

            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToString('9');

            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToString('0');

            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOperatorToString('+');

            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOperatorToString('-');

            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOperatorToString('×');

            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOperatorToString('÷');

            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!expression.equals("")){
                    expression = expression.substring(0,expression.length()-1);
                    expView.setText(expression);
                    stringToAnswer();
                }

            }
        });

        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = "";
                expView.setText("");
                ansView.setText("0");
                ans = 0;
                changeCurrentToAns();
            }
        });
        buttonCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression = "";
                changeCurrentToAns();
            }
        });
    }

}