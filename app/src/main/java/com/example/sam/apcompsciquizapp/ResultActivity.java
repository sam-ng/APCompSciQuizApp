package com.example.sam.apcompsciquizapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Sam on 11/19/2017.
 */

public class ResultActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");

        TextView scoreText = (TextView) findViewById(R.id.score);
        scoreText.setText(score);

        TextView result = (TextView) findViewById(R.id.result);
        if (score <= 3) {
            result.setText("Oops! Better Luck Next Time!");
        }
        else {
            result.setText("Congratulations!");
        }
    }
}
