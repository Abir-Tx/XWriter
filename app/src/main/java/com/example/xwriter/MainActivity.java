/* A java Source code & Android App project by Mushfiqur Rahman Abir.
All Rights Reserved By Mushfiqur Rahman Abir
This is my first hello world android app built by myself
 */

package com.example.xwriter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        Intent intent = new Intent(MainActivity.this, Counter.class);
        if (input.getText().toString().equals("")){
            Toast nullInputToast = Toast.makeText(getApplicationContext(), "Input a text first", Toast.LENGTH_SHORT);
            nullInputToast.show();
        }
        else {
            intent.putExtra("INPUT", holder);
            startActivity(intent);
        }
    }
}