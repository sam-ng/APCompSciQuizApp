package com.example.sam.apcompsciquizapp;

import android.app.Activity;
import android.media.MediaPlayer;
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
        scoreText.setText("Score: " + score);

        TextView result = (TextView) findViewById(R.id.result);

        MediaPlayer mp1 = MediaPlayer.create(ResultActivity.this, R.raw.marioallitemsobtained);
        MediaPlayer mp2 = MediaPlayer.create(ResultActivity.this, R.raw.mariolifelost);
        if (score <= 3) {
            result.setText("Oops! Better Luck Next Time!");
            mp2.start();
        }
        else {
            result.setText("Congratulations!");
            mp1.start();
        }
    }
}
