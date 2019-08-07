package com.example.reclyclerview_challenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Person> personList;
    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;

    private ArrayList<Person> generateList(){
        personList = new ArrayList<>();
        for (int i = 0; i<60;i++){
            Person person = new Person(i + " Kiran","Nepali",28,17150);
            personList.add(person);
        }
        return personList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateList();
        recyclerView = findViewById(R.id.listInRecyclerView);
        personAdapter = new PersonAdapter(personList, new PersonAdapter.OnClickedListener() {
            @Override
            public void onClickedPerson(Person person) {
//                Toast.makeText(MainActivity.this,"firstname"+person.getFirstname(),Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("hello",person);
            startActivity(intent);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(personAdapter);
    }
}
