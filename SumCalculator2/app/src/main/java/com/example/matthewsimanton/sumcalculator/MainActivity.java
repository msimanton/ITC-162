package com.example.matthewsimanton.sumcalculator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends Activity {

    //define variables for the widgets
    private EditText editTextNum1;
    private EditText editTextNum2;
    private Button button;

    //define the shared pref object
    private SharedPreferences savedValues;

    //define variables to be saved
    private int num1 = 0;
    private int num2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references to the widgets
        editTextNum1 = (EditText) findViewById(R.id.editTextNum1);
        editTextNum2 = (EditText) findViewById(R.id.editTextNum2);
        button = (Button) findViewById(R.id.button);



        //get SharedPreferences object
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    // Add sendMessage() method to link to second activity
    public void sendMessage(View view) {

        //Intent to invoke the second activity from the first activity
        Intent intent = new Intent(MainActivity.this, SumActivity.class);

        //get values for two numbers
        num1 = Integer.parseInt(editTextNum1.getText().toString());
        num2 = Integer.parseInt(editTextNum2.getText().toString());


        intent.putExtra("num1", num1);
        intent.putExtra("num2", num2);
        startActivity(intent);
    }


    @Override
    public void onPause() {
        //save instance variables when paused
        SharedPreferences.Editor editor = savedValues.edit();
        editor.putInt("num1", num1);
        editor.putInt("num2", num2);
        editor.commit();

        super.onPause();
    }

    @Override
    public void onResume() {
        //get instance variables
        num1 = savedValues.getInt("num1", 0);
        num2 = savedValues.getInt("num2", 0);


        super.onResume();
    }

}

