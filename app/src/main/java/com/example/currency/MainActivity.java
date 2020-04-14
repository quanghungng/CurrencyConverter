package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1;
    Spinner spinner2;

    TextView textView1;
    TextView textView2;

    Button num0 ;
    Button num1 ;
    Button num2 ;
    Button num3 ;
    Button num4 ;
    Button num5 ;
    Button num6 ;
    Button num7 ;
    Button num8 ;
    Button num9 ;
    Button AC;
    Button C;

    String type1;
    String type2;

    int state = 0;

    final float USD = 1;
    final float VND = (25000);
    final float YEN = 107.44f;
    final float WON = 1215.13f;
    final float RUP = 73.42f;

    float currency1 = 0;
    float currency2 = 0;
    float exchangeRate1;
    float exchangeRate2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.currency_spinner1, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.currency_spinner2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        num0 = findViewById(R.id.num0);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        num7 = findViewById(R.id.num7);
        num8 = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);
        AC = findViewById(R.id.AC);
        C = findViewById(R.id.c);

        textView1 = findViewById(R.id.currency1);
        textView2 = findViewById(R.id.currency2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                type1 = spinner1.getSelectedItem().toString();
                type2 = spinner2.getSelectedItem().toString();

                if(type1.equals("USD")) exchangeRate1 = USD;
                if(type1.equals("VND")) exchangeRate1 = VND;
                if(type1.equals("WON")) exchangeRate1 = WON;
                if(type1.equals("YEN")) exchangeRate1 = YEN;
                if(type1.equals("RUP")) exchangeRate1 = RUP;


                if(type2.equals("USD")) exchangeRate2 = USD;
                if(type2.equals("VND")) exchangeRate2 = VND;
                if(type2.equals("WON")) exchangeRate2 = WON;
                if(type2.equals("YEN")) exchangeRate2 = YEN;
                if(type2.equals("RUP")) exchangeRate2 = RUP;

                textView2.setText(String.valueOf(currency2));
                currency1 = (currency2/exchangeRate2)*exchangeRate1;
                textView1.setText(String.valueOf(currency1));



            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                type1 = spinner1.getSelectedItem().toString();
                type2 = spinner2.getSelectedItem().toString();

                if(type1.equals("USD")) exchangeRate1 = USD;
                if(type1.equals("VND")) exchangeRate1 = VND;
                if(type1.equals("WON")) exchangeRate1 = WON;
                if(type1.equals("YEN")) exchangeRate1 = YEN;
                if(type1.equals("RUP")) exchangeRate1 = RUP;


                if(type2.equals("USD")) exchangeRate2 = USD;
                if(type2.equals("VND")) exchangeRate2 = VND;
                if(type2.equals("WON")) exchangeRate2 = WON;
                if(type2.equals("YEN")) exchangeRate2 = YEN;
                if(type2.equals("RUP")) exchangeRate2 = RUP;

                textView1.setText(String.valueOf(currency1));
                currency2 = (currency1/exchangeRate1) *exchangeRate2;
                textView2.setText(String.valueOf(currency2));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state = 0;
                currency1 = 0;
                currency2 = 0;
                textView1.setText(String.valueOf(currency1));
                textView2.setText(String.valueOf(currency2));
            }
        });
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type1 = spinner1.getSelectedItem().toString();
                type2 = spinner2.getSelectedItem().toString();

                if(type1.equals("USD")) exchangeRate1 = USD;
                if(type1.equals("VND")) exchangeRate1 = VND;
                if(type1.equals("WON")) exchangeRate1 = WON;
                if(type1.equals("YEN")) exchangeRate1 = YEN;
                if(type1.equals("RUP")) exchangeRate1 = RUP;


                if(type2.equals("USD")) exchangeRate2 = USD;
                if(type2.equals("VND")) exchangeRate2 = VND;
                if(type2.equals("WON")) exchangeRate2 = WON;
                if(type2.equals("YEN")) exchangeRate2 = YEN;
                if(type2.equals("RUP")) exchangeRate2 = RUP;

                if(state == 1){
                    currency1 =(float) Math.floor(currency1/10);
                    textView1.setText(String.valueOf(currency1));
                    currency2 = (currency1/exchangeRate1) *exchangeRate2;
                    textView2.setText(String.valueOf(currency2));
                }
                if(state==2){
                    currency2 =(float) Math.floor(currency2/10);
                    textView2.setText(String.valueOf(currency2));
                    currency1 = (currency2/exchangeRate2)*exchangeRate1;
                    textView1.setText(String.valueOf(currency1));
                }
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currency1 = 0;
                currency2 = 0;
                textView1.setText(String.valueOf(currency1));
                textView2.setText(String.valueOf(currency2));
                state = 1;
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currency1 = 0;
                currency2 = 0;
                textView1.setText(String.valueOf(currency1));
                textView2.setText(String.valueOf(currency2));
                state = 2;
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type1 = spinner1.getSelectedItem().toString();
                type2 = spinner2.getSelectedItem().toString();

                if(type1.equals("USD")) exchangeRate1 = USD;
                if(type1.equals("VND")) exchangeRate1 = VND;
                if(type1.equals("WON")) exchangeRate1 = WON;
                if(type1.equals("YEN")) exchangeRate1 = YEN;
                if(type1.equals("RUP")) exchangeRate1 = RUP;


                if(type2.equals("USD")) exchangeRate2 = USD;
                if(type2.equals("VND")) exchangeRate2 = VND;
                if(type2.equals("WON")) exchangeRate2 = WON;
                if(type2.equals("YEN")) exchangeRate2 = YEN;
                if(type2.equals("RUP")) exchangeRate2 = RUP;
                if(state == 1){
                    currency1 *= 10;
                    currency1 += 1;
                    textView1.setText(String.valueOf(currency1));
                    currency2 = (currency1/exchangeRate1) *exchangeRate2;
                    textView2.setText(String.valueOf(currency2));
                }
                if(state == 2){
                    currency2 *= 10;
                    currency2 += 1;
                    textView2.setText(String.valueOf(currency2));
                    currency1 = (currency2/exchangeRate2)*exchangeRate1;
                    textView1.setText(String.valueOf(currency1));
                }
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type1 = spinner1.getSelectedItem().toString();
                type2 = spinner2.getSelectedItem().toString();

                if(type1.equals("USD")) exchangeRate1 = USD;
                if(type1.equals("VND")) exchangeRate1 = VND;
                if(type1.equals("WON")) exchangeRate1 = WON;
                if(type1.equals("YEN")) exchangeRate1 = YEN;
                if(type1.equals("RUP")) exchangeRate1 = RUP;


                if(type2.equals("USD")) exchangeRate2 = USD;
                if(type2.equals("VND")) exchangeRate2 = VND;
                if(type2.equals("WON")) exchangeRate2 = WON;
                if(type2.equals("YEN")) exchangeRate2 = YEN;
                if(type2.equals("RUP")) exchangeRate2 = RUP;
                if(state == 1){
                    currency1 *= 10;
                    currency1 += 2;
                    textView1.setText(String.valueOf(currency1));
                    currency2 = (currency1/exchangeRate1) *exchangeRate2;
                    textView2.setText(String.valueOf(currency2));
                }
                if(state == 2){
                    currency2 *= 10;
                    currency2 += 2;
                    textView2.setText(String.valueOf(currency2));
                    currency1 = (currency2/exchangeRate2)*exchangeRate1;
                    textView1.setText(String.valueOf(currency1));
                }
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type1 = spinner1.getSelectedItem().toString();
                type2 = spinner2.getSelectedItem().toString();

                if(type1.equals("USD")) exchangeRate1 = USD;
                if(type1.equals("VND")) exchangeRate1 = VND;
                if(type1.equals("WON")) exchangeRate1 = WON;
                if(type1.equals("YEN")) exchangeRate1 = YEN;
                if(type1.equals("RUP")) exchangeRate1 = RUP;


                if(type2.equals("USD")) exchangeRate2 = USD;
                if(type2.equals("VND")) exchangeRate2 = VND;
                if(type2.equals("WON")) exchangeRate2 = WON;
                if(type2.equals("YEN")) exchangeRate2 = YEN;
                if(type2.equals("RUP")) exchangeRate2 = RUP;
                if(state == 1){
                    currency1 *= 10;
                    currency1 += 3;
                    textView1.setText(String.valueOf(currency1));
                    currency2 = (currency1/exchangeRate1) *exchangeRate2;
                    textView2.setText(String.valueOf(currency2));
                }
                if(state == 2){
                    currency2 *= 10;
                    currency2 += 3;
                    textView2.setText(String.valueOf(currency2));
                    currency1 = (currency2/exchangeRate2)*exchangeRate1;
                    textView1.setText(String.valueOf(currency1));
                }
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type1 = spinner1.getSelectedItem().toString();
                type2 = spinner2.getSelectedItem().toString();

                if(type1.equals("USD")) exchangeRate1 = USD;
                if(type1.equals("VND")) exchangeRate1 = VND;
                if(type1.equals("WON")) exchangeRate1 = WON;
                if(type1.equals("YEN")) exchangeRate1 = YEN;
                if(type1.equals("RUP")) exchangeRate1 = RUP;


                if(type2.equals("USD")) exchangeRate2 = USD;
                if(type2.equals("VND")) exchangeRate2 = VND;
                if(type2.equals("WON")) exchangeRate2 = WON;
                if(type2.equals("YEN")) exchangeRate2 = YEN;
                if(type2.equals("RUP")) exchangeRate2 = RUP;
                if(state == 1){
                    currency1 *= 10;
                    currency1 += 4;
                    textView1.setText(String.valueOf(currency1));
                    currency2 = (currency1/exchangeRate1) *exchangeRate2;
                    textView2.setText(String.valueOf(currency2));
                }
                if(state == 2){
                    currency2 *= 10;
                    currency2 += 4;
                    textView2.setText(String.valueOf(currency2));
                    currency1 = (currency2/exchangeRate2)*exchangeRate1;
                    textView1.setText(String.valueOf(currency1));
                }
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type1 = spinner1.getSelectedItem().toString();
                type2 = spinner2.getSelectedItem().toString();

                if(type1.equals("USD")) exchangeRate1 = USD;
                if(type1.equals("VND")) exchangeRate1 = VND;
                if(type1.equals("WON")) exchangeRate1 = WON;
                if(type1.equals("YEN")) exchangeRate1 = YEN;
                if(type1.equals("RUP")) exchangeRate1 = RUP;


                if(type2.equals("USD")) exchangeRate2 = USD;
                if(type2.equals("VND")) exchangeRate2 = VND;
                if(type2.equals("WON")) exchangeRate2 = WON;
                if(type2.equals("YEN")) exchangeRate2 = YEN;
                if(type2.equals("RUP")) exchangeRate2 = RUP;
                if(state == 1){
                    currency1 *= 10;
                    currency1 += 5;
                    textView1.setText(String.valueOf(currency1));
                    currency2 = (currency1/exchangeRate1) *exchangeRate2;
                    textView2.setText(String.valueOf(currency2));
                }
                if(state == 2){
                    currency2 *= 10;
                    currency2 += 5;
                    textView2.setText(String.valueOf(currency2));
                    currency1 = (currency2/exchangeRate2)*exchangeRate1;
                    textView1.setText(String.valueOf(currency1));
                }
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type1 = spinner1.getSelectedItem().toString();
                type2 = spinner2.getSelectedItem().toString();

                if(type1.equals("USD")) exchangeRate1 = USD;
                if(type1.equals("VND")) exchangeRate1 = VND;
                if(type1.equals("WON")) exchangeRate1 = WON;
                if(type1.equals("YEN")) exchangeRate1 = YEN;
                if(type1.equals("RUP")) exchangeRate1 = RUP;


                if(type2.equals("USD")) exchangeRate2 = USD;
                if(type2.equals("VND")) exchangeRate2 = VND;
                if(type2.equals("WON")) exchangeRate2 = WON;
                if(type2.equals("YEN")) exchangeRate2 = YEN;
                if(type2.equals("RUP")) exchangeRate2 = RUP;
                if(state == 1){
                    currency1 *= 10;
                    currency1 += 6;
                    textView1.setText(String.valueOf(currency1));
                    currency2 = (currency1/exchangeRate1) *exchangeRate2;
                    textView2.setText(String.valueOf(currency2));
                }
                if(state == 2){
                    currency2 *= 10;
                    currency2 += 6;
                    textView2.setText(String.valueOf(currency2));
                    currency1 = (currency2/exchangeRate2)*exchangeRate1;
                    textView1.setText(String.valueOf(currency1));
                }
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type1 = spinner1.getSelectedItem().toString();
                type2 = spinner2.getSelectedItem().toString();

                if(type1.equals("USD")) exchangeRate1 = USD;
                if(type1.equals("VND")) exchangeRate1 = VND;
                if(type1.equals("WON")) exchangeRate1 = WON;
                if(type1.equals("YEN")) exchangeRate1 = YEN;
                if(type1.equals("RUP")) exchangeRate1 = RUP;


                if(type2.equals("USD")) exchangeRate2 = USD;
                if(type2.equals("VND")) exchangeRate2 = VND;
                if(type2.equals("WON")) exchangeRate2 = WON;
                if(type2.equals("YEN")) exchangeRate2 = YEN;
                if(type2.equals("RUP")) exchangeRate2 = RUP;
                if(state == 1){
                    currency1 *= 10;
                    currency1 += 7;
                    textView1.setText(String.valueOf(currency1));
                    currency2 = (currency1/exchangeRate1) *exchangeRate2;
                    textView2.setText(String.valueOf(currency2));
                }
                if(state == 2){
                    currency2 *= 10;
                    currency2 += 7;
                    textView2.setText(String.valueOf(currency2));
                    currency1 = (currency2/exchangeRate2)*exchangeRate1;
                    textView1.setText(String.valueOf(currency1));
                }
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type1 = spinner1.getSelectedItem().toString();
                type2 = spinner2.getSelectedItem().toString();

                if(type1.equals("USD")) exchangeRate1 = USD;
                if(type1.equals("VND")) exchangeRate1 = VND;
                if(type1.equals("WON")) exchangeRate1 = WON;
                if(type1.equals("YEN")) exchangeRate1 = YEN;
                if(type1.equals("RUP")) exchangeRate1 = RUP;


                if(type2.equals("USD")) exchangeRate2 = USD;
                if(type2.equals("VND")) exchangeRate2 = VND;
                if(type2.equals("WON")) exchangeRate2 = WON;
                if(type2.equals("YEN")) exchangeRate2 = YEN;
                if(type2.equals("RUP")) exchangeRate2 = RUP;
                if(state == 1){
                    currency1 *= 10;
                    currency1 += 8;
                    textView1.setText(String.valueOf(currency1));
                    currency2 = (currency1/exchangeRate1) *exchangeRate2;
                    textView2.setText(String.valueOf(currency2));
                }
                if(state == 2){
                    currency2 *= 10;
                    currency2 += 8;
                    textView2.setText(String.valueOf(currency2));
                    currency1 = (currency2/exchangeRate2)*exchangeRate1;
                    textView1.setText(String.valueOf(currency1));
                }
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type1 = spinner1.getSelectedItem().toString();
                type2 = spinner2.getSelectedItem().toString();

                if(type1.equals("USD")) exchangeRate1 = USD;
                if(type1.equals("VND")) exchangeRate1 = VND;
                if(type1.equals("WON")) exchangeRate1 = WON;
                if(type1.equals("YEN")) exchangeRate1 = YEN;
                if(type1.equals("RUP")) exchangeRate1 = RUP;


                if(type2.equals("USD")) exchangeRate2 = USD;
                if(type2.equals("VND")) exchangeRate2 = VND;
                if(type2.equals("WON")) exchangeRate2 = WON;
                if(type2.equals("YEN")) exchangeRate2 = YEN;
                if(type2.equals("RUP")) exchangeRate2 = RUP;
                if(state == 1){
                    currency1 *= 10;
                    currency1 += 9;
                    textView1.setText(String.valueOf(currency1));
                    currency2 = (currency1/exchangeRate1) *exchangeRate2;
                    textView2.setText(String.valueOf(currency2));
                }
                if(state == 2){
                    currency2 *= 10;
                    currency2 += 9;
                    textView2.setText(String.valueOf(currency2));
                    currency1 = (currency2/exchangeRate2)*exchangeRate1;
                    textView1.setText(String.valueOf(currency1));
                }
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type1 = spinner1.getSelectedItem().toString();
                type2 = spinner2.getSelectedItem().toString();

                if(type1.equals("USD")) exchangeRate1 = USD;
                if(type1.equals("VND")) exchangeRate1 = VND;
                if(type1.equals("WON")) exchangeRate1 = WON;
                if(type1.equals("YEN")) exchangeRate1 = YEN;
                if(type1.equals("RUP")) exchangeRate1 = RUP;


                if(type2.equals("USD")) exchangeRate2 = USD;
                if(type2.equals("VND")) exchangeRate2 = VND;
                if(type2.equals("WON")) exchangeRate2 = WON;
                if(type2.equals("YEN")) exchangeRate2 = YEN;
                if(type2.equals("RUP")) exchangeRate2 = RUP;
                if(state == 1){
                    currency1 *= 10;
                    currency1 += 0;
                    textView1.setText(String.valueOf(currency1));
                    currency2 = (currency1/exchangeRate1) *exchangeRate2;
                    textView2.setText(String.valueOf(currency2));
                }
                if(state == 2){
                    currency2 *= 10;
                    currency2 += 0;
                    textView2.setText(String.valueOf(currency2));
                    currency1 = (currency2/exchangeRate2)*exchangeRate1;
                    textView1.setText(String.valueOf(currency1));
                }
            }
        });
    }
}
