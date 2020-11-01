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
    RadioButton rb, rb2;
    boolean isIncremental = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        et = findViewById(R.id.count);
        rb = findViewById(R.id.incremental);
        rb2 = findViewById(R.id.nothing);
    }

    public void print2(View view) {
        String inputHolder = getIntent().getStringExtra("INPUT");
        String holder = et.getText().toString();

        if (et.getText().toString().equals("")) {
            Toast nullInputToast = Toast.makeText(getApplicationContext(), "Input a Number first", Toast.LENGTH_SHORT);
            nullInputToast.show();
        } else {
            int checkNumber = Integer.parseInt(holder);
            if (checkNumber > 200000) {
                Toast nullInputToast = Toast.makeText(getApplicationContext(), "Can not take more than 200000 input", Toast.LENGTH_SHORT);
                nullInputToast.show();
            } else {
                if (isIncremental) {
                    int i = Integer.parseInt(holder);
                    Intent in = new Intent(Counter.this, printScreen.class);
                    in.putExtra("COUNT", i);
                    in.putExtra("INPUT", inputHolder);
                    in.putExtra("isIncremental", isIncremental);
                    startActivity(in);
                } else {
                    int i = Integer.parseInt(holder);
                    Intent in = new Intent(Counter.this, printScreen.class);
                    in.putExtra("COUNT", i);
                    in.putExtra("INPUT", inputHolder);
                    startActivity(in);
                }

            }
        }

    }

    public void advanceView(View view) {
        if (rb.getVisibility() == View.VISIBLE) {
            rb.setVisibility(View.INVISIBLE);
            rb2.setVisibility(View.INVISIBLE);
        } else {
            rb.setVisibility(View.VISIBLE);
            rb2.setVisibility(View.VISIBLE);
        }
    }

    public void incremental(View view) {
        if (rb.isChecked()) {
            isIncremental = true;
        } else if (!rb.isChecked()) {
            isIncremental = false;
        } else if (rb2.isChecked()) {
            isIncremental = false;
        } else if (!rb2.isChecked()) {
            isIncremental = false;
        } else {
            isIncremental = false;
            System.out.println("Boolean isIncremental is not working. Error ! Going with false value"); //Error message for developers
        }
    }
}