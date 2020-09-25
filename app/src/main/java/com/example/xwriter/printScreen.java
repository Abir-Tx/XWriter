package com.example.xwriter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class printScreen extends AppCompatActivity {
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_screen);
        String holder = getIntent().getStringExtra("INPUT");
        int counter =  getIntent().getIntExtra("COUNT",1);
        result = findViewById(R.id.result);
        for (int i = 0; i < counter; i++) {
            result.append(holder+"\n");
        }
    }
}