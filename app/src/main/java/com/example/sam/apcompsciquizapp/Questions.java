package com.example.sam.apcompsciquizapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Sam on 11/17/2017.
 */

@Entity(tableName = "Questions")
public class Questions {
    @ColumnInfo(name = "Topic")
    private String topic;

    @ColumnInfo(name = "Questions")
    private String question;

    @PrimaryKey
    @ColumnInfo(name = "ID")
    private int id;

    @ColumnInfo(name = "Choice A")
    private String choiceA;

    @ColumnInfo(name = "Choice B")
    private String choiceB;

    @ColumnInfo(name = "Choice C")
    private String choiceC;

    @ColumnInfo(name = "Choice D")
    private String choiceD;

    @ColumnInfo(name = "Correct Answer")
    private String correctAnswer;

    public Questions(String topic, String question, int id, String choiceA, String choiceB, String choiceC, String choiceD, String correctAnswer) {
        this.topic = topic;
        this.question = question;
        this.id = id;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.correctAnswer = correctAnswer;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(String choiceA) {
        this.choiceA = choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public void setChoiceD(String choiceD) {
        this.choiceD = choiceD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
