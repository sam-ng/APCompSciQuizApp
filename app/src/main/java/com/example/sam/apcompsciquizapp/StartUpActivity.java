package com.example.sam.apcompsciquizapp;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fstyle.library.helper.AssetSQLiteOpenHelperFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StartUpActivity extends Activity {
    Database db;

    private Button data;
    private Button classObject;
    private Button conditional;
    private Button iteration;
    private Button string;

    private String topicChoice;
    private int questionNum;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        db = Room.databaseBuilder(getApplicationContext(), Database.class,"QuizApp2.db").openHelperFactory(new AssetSQLiteOpenHelperFactory()).allowMainThreadQueries().build();

        data = (Button) findViewById(R.id.data);
        classObject = (Button) findViewById(R.id.classObject);
        conditional = (Button) findViewById(R.id.conditional);
        iteration = (Button) findViewById(R.id.iteration);
        string = (Button) findViewById(R.id.string);

        questionNum = 0;
        random = new Random();

        addListenerOnButton();
    }

    public void addListenerOnButton() {
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.getQuizDao().deleteAllScores();
                topicChoice = "data";
                questionNum = random.nextInt(6);

                Intent intent = new Intent(StartUpActivity.this, MainActivity.class);
                intent.putExtra("topic", topicChoice);
                Bundle b = new Bundle();
                b.putInt("qNum", questionNum);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });
        classObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.getQuizDao().deleteAllScores();
                topicChoice = "classObject";
                questionNum = random.nextInt(6);

                Intent intent = new Intent(StartUpActivity.this, MainActivity.class);
                intent.putExtra("topic", topicChoice);
                Bundle b = new Bundle();
                b.putInt("qNum", questionNum);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });
        conditional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.getQuizDao().deleteAllScores();
                topicChoice = "conditional";
                questionNum = random.nextInt(6);

                Intent intent = new Intent(StartUpActivity.this, MainActivity.class);
                intent.putExtra("topic", topicChoice);
                Bundle b = new Bundle();
                b.putInt("qNum", questionNum);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });
        iteration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.getQuizDao().deleteAllScores();
                topicChoice = "iteration";
                questionNum = random.nextInt(6);

                Intent intent = new Intent(StartUpActivity.this, MainActivity.class);
                intent.putExtra("topic", topicChoice);
                Bundle b = new Bundle();
                b.putInt("qNum", questionNum);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });
        string.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.getQuizDao().deleteAllScores();
                topicChoice = "string";
                questionNum = random.nextInt(6);

                Intent intent = new Intent(StartUpActivity.this, MainActivity.class);
                intent.putExtra("topic", topicChoice);
                Bundle b = new Bundle();
                b.putInt("qNum", questionNum);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });
    }
}
