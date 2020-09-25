package com.example.xwriter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Counter extends AppCompatActivity {

    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        et = findViewById(R.id.count);


    }

    public void print2(View view) {
        String inputHolder = getIntent().getStringExtra("INPUT");
        String holder = et.getText().toString();
        int i = Integer.parseInt(holder);
        Intent in = new Intent(Counter.this, printScreen.class);
        in.putExtra("COUNT",i);
        in.putExtra("INPUT",inputHolder);
        startActivity(in);
    }
}