package com.example.xwriter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Counter extends AppCompatActivity {

    EditText et;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        et = findViewById(R.id.count);
        rb = findViewById(R.id.incremental);
    }

    public void print2(View view) {
        String inputHolder = getIntent().getStringExtra("INPUT");
        String holder = et.getText().toString();

        if (et.getText().toString().equals("")){
            Toast nullInputToast = Toast.makeText(getApplicationContext(), "Input a Number first", Toast.LENGTH_SHORT);
            nullInputToast.show();
        }
        else{
            int checkNumber = Integer.parseInt(holder);
            if (checkNumber > 200000){
                Toast nullInputToast = Toast.makeText(getApplicationContext(), "Can not take more than 200000 input", Toast.LENGTH_SHORT);
                nullInputToast.show();
            }
            else{
                int i = Integer.parseInt(holder);
                Intent in = new Intent(Counter.this, printScreen.class);
                in.putExtra("COUNT",i);
                in.putExtra("INPUT",inputHolder);
                startActivity(in);
            }
        }

    }

    public void advanceView(View view){
        if (rb.getVisibility() == View.VISIBLE){
            rb.setVisibility(View.INVISIBLE);
        }
        else{
            rb.setVisibility(View.VISIBLE);
        }
    }
}