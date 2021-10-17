package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void calculate(View v){

        //Declare a snackbar to display a empty field error
        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.background), "Please enter a value in all fields.", Snackbar.LENGTH_LONG);

        //Declare variables to link the front end objects with backend.
        EditText principle = findViewById(R.id.principleAmount);
        EditText interest = findViewById(R.id.Interest);
        EditText length = findViewById(R.id.mortgageLength);

        //Create string variables to return the user input for all text fields.
        String principleAmount=principle.getText().toString();
        String monthlyInterest=interest.getText().toString();
        String monthlyLength=length.getText().toString();

        //This code is used to navigate to the next activity and also pass the 3 variables.
        Intent i = new Intent(MainActivity.this, ResultScreen.class);
        i.putExtra("principle",principleAmount);
        i.putExtra("interest",monthlyInterest);
        i.putExtra("length",monthlyLength);

        //Check if the snackbar should be displayed
        if (TextUtils.isEmpty(principle.getText().toString()) || TextUtils.isEmpty(interest.getText().toString())|| TextUtils.isEmpty(length.getText().toString()))
            mySnackbar.show();
        else
            startActivity(i);
    }
}