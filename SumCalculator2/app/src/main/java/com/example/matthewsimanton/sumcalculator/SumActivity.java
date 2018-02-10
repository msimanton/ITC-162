package com.example.matthewsimanton.sumcalculator;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class SumActivity extends Activity {


    //create instance variables
    private TextView textView;

    //define the shared pref object
    private SharedPreferences savedValues;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);

        //get a reference to the text view
        textView = (TextView) findViewById(R.id.textView);

        //get values from other activity
        Bundle bundle = getIntent().getExtras();
        int num1 = bundle.getInt("num1");
        int num2 = bundle.getInt("num2");


        //add sums
        int sum = num1 + num2;


        //output the sum
        textView.setText(Integer.toString(sum));


        //get SharedPreferences object
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }


}
