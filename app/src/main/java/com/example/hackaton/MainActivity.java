package com.example.hackaton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
            switch (rb.getId()) {
                case R.id.pythonBtn:
                    nameTable = "Python";
                    break;
                case R.id.dataBtn:
                    nameTable = "DataScientist";
                    break;
                case R.id.jsBtn:
                    nameTable = "JavaScript";
                    break;
                default:
                    break;
            }
        }
    };

}
