package com.example.xwriter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

        ClipboardManager clipboardManager;
        clipboardManager= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData;
    }

    public void copy(View view) {
        ClipboardManager manager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("text", result.getText());
        manager.setPrimaryClip(clipData);


        Toast textCopied = Toast.makeText(getApplicationContext(), "Copied to clipboard", Toast.LENGTH_LONG);
        textCopied.show();
    }

    public void share(View view){
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = result.getText().toString();
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}