package com.example.matthewsimanton.abvcalculator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
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

    //define shared Pref
    private SharedPreferences savedValues;





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


        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);



    }

    public void displaySettings(View view) {
        //start settings activity
        startActivity(new Intent(this,SettingsActivity.class));
        //Intent intent = new Intent(this,SettingsActivity.class);
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
        //calcAndDisplay();

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        calcAndDisplay();
    }

    //calculation for ABV
    public void calcAndDisplay () {
        float calcABV = (float) ((sbOG - sbFG) * 131.25);

        textViewABV.setText(Float.toString(calcABV));
    }

    //displays options menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return true;
    }

    //handle the menu events
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                startActivity(new Intent(this, AboutActivity.class));
                return true;

            case R.id.help:
                startActivity(new Intent(this, HelpActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }




    @Override
    public void onPause() {
        SharedPreferences.Editor editor = savedValues.edit();
        editor.putFloat("sbOG", sbOG);
        editor.putFloat("sbFG", sbFG);
        editor.commit();

        super.onPause();
    }

    @Override
    public void onResume() {
        sbOG = savedValues.getFloat("sbOG", sbOG);
        sbFG = savedValues.getFloat("sbFG", sbFG);

        super.onResume();
    }
}
