package com.example.matthewsimanton.abvcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener {


    //declare variables
    private SeekBar seekBarOG;
    private SeekBar seekBarFG;
    private TextView textViewABV;
    private  TextView textViewOG;
    private TextView textViewFG;

    float sbOG = 0;
    float sbFG = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references
        seekBarOG = (SeekBar) findViewById(R.id.seekBarOG);
        seekBarFG = (SeekBar) findViewById(R.id.seekBarFG);
        textViewABV = (TextView) findViewById(R.id.textViewABV);
        textViewOG = (TextView) findViewById(R.id.textViewOG);
        textViewFG = (TextView) findViewById(R.id.textViewFG);


        //set listener
        seekBarOG.setOnSeekBarChangeListener(this);
        seekBarFG.setOnSeekBarChangeListener(this);



    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int scale, boolean b) {

        //to use the two different seekbars
        switch (seekBar.getId()){

            case R.id.seekBarOG:
                textViewOG.setText("Original Gravity: " + ((1.075 - 1.030)*((scale+1)-1)/(10-1) + 1.030));
                sbOG = (float) ((1.075 - 1.030)*((scale+1)-1)/(10-1) + 1.030);
                break;

            case R.id.seekBarFG:
                textViewFG.setText("Final Gravity: " + ((1.024 - .998)*((scale+1)-1)/(14-1) + .998));
                sbFG = (float) ((1.024 - .998)*((scale+1)-1)/(15-1) + .998);
                break;
        }


        //perform the calculation when the seekbar value is changed
        calcAndDisplay();

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    //calculation for ABV
    public void calcAndDisplay () {
        float calcABV = (float) ((sbOG - sbFG) * 131.25);

        textViewABV.setText(Float.toString(calcABV));
    }
}
