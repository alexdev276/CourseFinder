package com.example.coursefinder;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button gen;
    String nameTable = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton radioPython = findViewById(R.id.pythonBtn);
        radioPython.setOnClickListener(radioButtonClickListener);

        RadioButton dataBtn = findViewById(R.id.dataBtn);
        dataBtn.setOnClickListener(radioButtonClickListener);

        RadioButton javaScriptBtn = findViewById(R.id.jsBtn);
        javaScriptBtn.setOnClickListener(radioButtonClickListener);


        gen = (Button) findViewById(R.id.gen);
        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Objects.equals(nameTable, "")) {
                    Intent i = new Intent(MainActivity.this, ExtentedActivity.class);
                    i.putExtra("bdName", nameTable);
                    startActivity(i);
                }
            }
        });

    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton) v;
            if (rb.getId() == R.id.pythonBtn){
                nameTable = "Python";
            } else if (rb.getId() == R.id.dataBtn) {
                nameTable = "DataScientist";
            } else if (rb.getId() == R.id.jsBtn){
                nameTable = "JavaScript";
            }
        }
    };

}
