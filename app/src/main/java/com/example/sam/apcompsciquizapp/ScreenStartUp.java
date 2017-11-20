package com.example.sam.apcompsciquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class ScreenStartUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.StartUpScreen);

        Button data = (Button) findViewById(R.id.data);
        Button classObject = (Button) findViewById(R.id.classObject);
        Button conditional = (Button) findViewById(R.id.conditional);
        Button iteration = (Button) findViewById(R.id.iteration);
        Button string = (Button) findViewById(R.id.string);

        Intent intent = new Intent(ScreenStartUp.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
