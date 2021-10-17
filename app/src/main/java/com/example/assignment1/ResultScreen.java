package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ResultScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        TextView textView = (TextView) findViewById(R.id.totalPayment);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            Double principle = Double.parseDouble(extras.getString("principle"));
            Double interest = Double.parseDouble(extras.getString("interest"));
            Double Length = Double.parseDouble(extras.getString("length"));

            interest/=100;
            interest/=12;

            Double amount = (principle*interest*Math.pow(1+interest,Length))/(Math.pow(1+interest,Length)-1);

            textView.setText("$"+String.format("%.2f",amount));
        }
    }

    public void goBack(View v){
        Intent i = new Intent(ResultScreen.this, MainActivity.class);
        startActivity(i);
    }
}