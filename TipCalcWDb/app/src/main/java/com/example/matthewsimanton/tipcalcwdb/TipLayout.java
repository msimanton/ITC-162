package com.example.matthewsimanton.tipcalcwdb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TipLayout extends RelativeLayout implements View.OnClickListener {

    private TextView billDateTextView;
    private TextView billAmountTextView;
    private TextView tipPercentTextView;
    private Button deleteButton;

    private Context context;
    private TipDB db;
    private Tip tip;

    //constructor for tip layout class
    public TipLayout(Context context) {
        super(context);
    }

    public TipLayout(Context context, Tip tip) {
        super(context);

        //get db object
        db = new TipDB(context);

        //inflate the layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.listview_tip, this, true);

        //get widgets refs
        billDateTextView = (TextView) findViewById(R.id.billDateTextView);
        billAmountTextView = (TextView) findViewById(R.id.billAmountTextView);
        tipPercentTextView = (TextView) findViewById(R.id.tipPercentTextView);
        billDateTextView = (TextView) findViewById(R.id.billDateTextView);
        deleteButton = (Button) findViewById(R.id.deleteButton);

        deleteButton.setOnClickListener(this);

        //set task data on the widget
        setTip(tip);

    }

    public void setTip(Tip tip) {
        this.tip = tip;

        billDateTextView.setText(tip.getDateStringFormatted());
        billAmountTextView.setText(tip.getBillAmountFormatted());
        tipPercentTextView.setText(tip.getTipPercentFormatted());
    }

    @Override
    public void onClick(View v) {
        db.deleteTip(tip.getId());
        context.startActivity(new Intent(context, TipHistoryActivity.class));
    }

}