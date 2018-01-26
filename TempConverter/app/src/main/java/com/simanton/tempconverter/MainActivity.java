package com.simanton.tempconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends Activity implements EditText.OnEditorActionListener {

    //implement variables
    private EditText fEntryEditText;
    private TextView celsiusTextView;

    private String fahrenheitEntry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references to the widgets for R class
        fEntryEditText = (EditText) findViewById(R.id.fEntryEditText);
        celsiusTextView = (TextView) findViewById(R.id.celsiusTextView);

        fEntryEditText.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        calcAndDisplay();
        return false;
    }

    private void calcAndDisplay() {

        //get fahrenheit entry
        fahrenheitEntry = fEntryEditText.getText().toString();
        float conversion;
        if (fahrenheitEntry.equals("")) {
            conversion = 0;
        } else {
            conversion = Float.parseFloat(fahrenheitEntry);
        }


        //convert to celsius
        float temp = (conversion - 32) * 5/9;

        //display
        NumberFormat celsius = NumberFormat.getNumberInstance();
        celsiusTextView.setText(celsius.format(temp));
    }
}
