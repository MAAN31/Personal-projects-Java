package com.example.mymortageappeecs1022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View v){

        EditText principleView = (EditText) findViewById(R.id.editPrinciple);
        String principle = principleView.getText().toString();
        EditText amortizationView = (EditText) findViewById(R.id.editAmortization);
        String amortization = amortizationView.getText().toString();
        EditText interestView = (EditText) findViewById(R.id.editInterest);
        String interest = interestView.getText().toString();

        MortgageModel myModel= new MortgageModel(principle,amortization,interest);
        TextView result=(TextView)findViewById(R.id.result);
        result.setText(myModel.computePayment());

    }


}
