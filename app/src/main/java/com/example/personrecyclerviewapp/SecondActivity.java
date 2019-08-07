package com.example.personrecyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        PersonData personData = intent.getParcelableExtra(MainActivity.INTENT_MESSAGE);

        TextView tvFname = findViewById(R.id.tv_firstname);
        TextView tvLname = findViewById(R.id.tv_lastname);
        TextView tvAge = findViewById(R.id.tv_age);
        TextView tvSalary = findViewById(R.id.tv_salary);

        tvFname.setText(personData.getFirstName());
        tvLname.setText(personData.getLastName());
        tvAge.setText(String.valueOf(personData.getAge()));
        tvSalary.setText(String.valueOf(personData.getSalary()));
    }
}
