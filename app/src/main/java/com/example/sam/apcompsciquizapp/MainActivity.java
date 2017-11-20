package com.example.sam.apcompsciquizapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import com.fstyle.library.helper.AssetSQLiteOpenHelperFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Questions> questionList;
    Database db;

    private Button data;
    private Button classObject;
    private Button conditional;
    private Button iteration;
    private Button string;
    private TextView topic;

    private Questions currentQuestion;
    private TextView question;
    private int questionNum;
    private Random random;
    List<Integer> finished;

    private RadioButton choiceA;
    private RadioButton choiceB;
    private RadioButton choiceC;
    private RadioButton choiceD;
    private Button next;

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                Database.class,
                "QuizApp.db"
                )
                .openHelperFactory(new AssetSQLiteOpenHelperFactory())
                .allowMainThreadQueries()
                .build();

        data = (Button) findViewById(R.id.data);
        classObject = (Button) findViewById(R.id.classObject);
        conditional = (Button) findViewById(R.id.conditional);
        iteration = (Button) findViewById(R.id.iteration);
        string = (Button) findViewById(R.id.string);
        topic = (TextView) findViewById(R.id.topic);

        question = (TextView) findViewById(R.id.question);
        random = new Random();

        choiceA = (RadioButton) findViewById(R.id.choiceA);
        choiceB = (RadioButton) findViewById(R.id.choiceB);
        choiceC = (RadioButton) findViewById(R.id.choiceC);
        choiceD = (RadioButton) findViewById(R.id.choiceD);
        next = (Button) findViewById(R.id.next);

        score = 0;
        questionNum = 0;

        addListenerOnButton();
    }

    public void addListenerOnButton() {
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.getQuizDao().deleteAllScores();
                finished = new ArrayList<Integer>();
                questionList = db.getQuizDao().findQuestionsByID(100, 105);
                questionNum = random.nextInt(6);
                finished.add(questionNum);
                currentQuestion = questionList.get(questionNum);
                topic.setText(currentQuestion.getTopic());
                question.setText(currentQuestion.getQuestion());
                choiceA.setText(currentQuestion.getChoiceA());
                choiceB.setText(currentQuestion.getChoiceB());
                choiceC.setText(currentQuestion.getChoiceC());
                choiceD.setText(currentQuestion.getChoiceD());
            }
        });
        classObject.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                db.getQuizDao().deleteAllScores();
                finished = new ArrayList<Integer>();
                questionList = db.getQuizDao().findQuestionsByID(200, 205);
                questionNum = random.nextInt(6);
                finished.add(questionNum);
                currentQuestion = questionList.get(questionNum);
                topic.setText(currentQuestion.getTopic());
                question.setText(currentQuestion.getQuestion());
                choiceA.setText(currentQuestion.getChoiceA());
                choiceB.setText(currentQuestion.getChoiceB());
                choiceC.setText(currentQuestion.getChoiceC());
                choiceD.setText(currentQuestion.getChoiceD());
            }
        });
        conditional.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                db.getQuizDao().deleteAllScores();
                finished = new ArrayList<Integer>();
                questionList = db.getQuizDao().findQuestionsByID(300, 305);
                questionNum = random.nextInt(6);
                finished.add(questionNum);
                currentQuestion = questionList.get(questionNum);
                topic.setText(currentQuestion.getTopic());
                question.setText(currentQuestion.getQuestion());
                choiceA.setText(currentQuestion.getChoiceA());
                choiceB.setText(currentQuestion.getChoiceB());
                choiceC.setText(currentQuestion.getChoiceC());
                choiceD.setText(currentQuestion.getChoiceD());
            }
        });
        iteration.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                db.getQuizDao().deleteAllScores();
                finished = new ArrayList<Integer>();
                questionList = db.getQuizDao().findQuestionsByID(400, 405);
                questionNum = random.nextInt(6);
                finished.add(questionNum);
                currentQuestion = questionList.get(questionNum);
                topic.setText(currentQuestion.getTopic());
                question.setText(currentQuestion.getQuestion());
                choiceA.setText(currentQuestion.getChoiceA());
                choiceB.setText(currentQuestion.getChoiceB());
                choiceC.setText(currentQuestion.getChoiceC());
                choiceD.setText(currentQuestion.getChoiceD());
            }
        });
        string.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                db.getQuizDao().deleteAllScores();
                finished = new ArrayList<Integer>();
                questionList = db.getQuizDao().findQuestionsByID(500, 505);
                questionNum = random.nextInt(6);
                finished.add(questionNum);
                currentQuestion = questionList.get(questionNum);
                topic.setText(currentQuestion.getTopic());
                question.setText(currentQuestion.getQuestion());
                choiceA.setText(currentQuestion.getChoiceA());
                choiceB.setText(currentQuestion.getChoiceB());
                choiceC.setText(currentQuestion.getChoiceC());
                choiceD.setText(currentQuestion.getChoiceD());
            }
        });
        next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup);
                RadioButton answer = (RadioButton) findViewById(group.getCheckedRadioButtonId());
                if (currentQuestion.getCorrectAnswer().equals(answer.getText())) {
                    score++;
                    Score scoreObj = new Score(1, 0, currentQuestion.getId(), answer.getText().toString());
                    db.getQuizDao().insertScore(scoreObj);
                }
                Score scoreObj = new Score(0, 1, currentQuestion.getId(), answer.getText().toString());
                if (finished.size() < 6) {
                    questionNum = random.nextInt(6);
                    while (finished.contains(new Integer(questionNum))) {
                        questionNum = random.nextInt(6);
                    }
                    finished.add(questionNum);
                    currentQuestion = questionList.get(questionNum);
                    topic.setText(currentQuestion.getTopic());
                    question.setText(currentQuestion.getQuestion());
                    choiceA.setText(currentQuestion.getChoiceA());
                    choiceB.setText(currentQuestion.getChoiceB());
                    choiceC.setText(currentQuestion.getChoiceC());
                    choiceD.setText(currentQuestion.getChoiceD());
                }
                else {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
