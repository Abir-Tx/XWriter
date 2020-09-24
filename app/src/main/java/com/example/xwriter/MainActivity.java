package com.example.xwriter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText input;
    Button print;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        print = findViewById(R.id.submit);

    }

    public void print(View view) {
        String holder;

        holder = input.getText().toString();

        Intent intent = new Intent(MainActivity.this, printScreen.class);
        intent.putExtra("INPUT",holder);
        startActivity(intent);
    }
}