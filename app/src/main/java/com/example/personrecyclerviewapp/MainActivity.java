package com.example.personrecyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<PersonData> personDataList;
    private RecyclerView recyclerView;
    private PersonDataAdapter personAdapter;
    public static final String INTENT_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createPersonData();

        recyclerView = findViewById(R.id.recyclerview_list);

        personAdapter = new PersonDataAdapter(personDataList, new PersonDataAdapter.OnPersonClickedListener() {
            @Override
            public void onItemClicked(PersonData person) {
          //    Toast.makeText(MainActivity.this, "Person name " + person.getFirstName(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra(INTENT_MESSAGE, person);
                startActivity(intent);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(personAdapter);

    }


    private ArrayList<PersonData> createPersonData(){

        personDataList = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            PersonData person = new PersonData("firstname" + i, "lastname" + i, i, i);
            personDataList.add(person);
        }

        return personDataList;
    }
}
