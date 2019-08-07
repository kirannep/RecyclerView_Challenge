package com.example.reclyclerview_challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView first_name;
    private TextView last_name;
    private TextView age;
    private TextView salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        first_name = findViewById(R.id.tv_firstname);
        last_name = findViewById(R.id.tv_lastname);
        age = findViewById(R.id.tv_age);
        salary = findViewById(R.id.tv_salary);

        Person person = getIntent().getParcelableExtra("hello");
        first_name.setText(person.getFirstname());
        last_name.setText(person.getLastname());
        age.setText(""+person.getAge());
        salary.setText(""+person.getSalary());
    }
}
