package com.example.matthewsimanton.invoicetotalapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends Activity implements EditText.OnEditorActionListener {

    //declare instance variables for widgets
    private EditText inputEditText;
    private TextView percentTextView;
    private TextView discountTextView;
    private TextView totalTextView;

    private String subtotalString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references to the widgets from the R class
        inputEditText = (EditText) findViewById(R.id.inputEditText);
        percentTextView = (TextView) findViewById(R.id.percentTextView);
        discountTextView = (TextView) findViewById(R.id.discountTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);


        inputEditText.setOnEditorActionListener(this);
    }


    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        //add calculate and display
        calcAndDisplay();
        return false;
    }

    private void calcAndDisplay() {

        //get subtotal
        subtotalString = inputEditText.getText().toString();
        float subtotal;
        if(subtotalString.equals("")){
            subtotal = 0;
        } else {
            subtotal = Float.parseFloat(subtotalString);
        }

        //get discount percent
        float discountPercent = 0;
        if(subtotal >= 200){
            discountPercent = .2f;
        } else if (subtotal >= 100){
            discountPercent = .1f;
        } else {
            discountPercent = 0;
        }

        //calculate the discount
        float discountAmount = subtotal * discountPercent;
        float total = subtotal - discountAmount;

        //display data on layout
        NumberFormat percent = NumberFormat.getPercentInstance();
        percentTextView.setText(percent.format(discountPercent));

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        discountTextView.setText(currency.format(discountAmount));
        totalTextView.setText(currency.format(total));

    }

}
