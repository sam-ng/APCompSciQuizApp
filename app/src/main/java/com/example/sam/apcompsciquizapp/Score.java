package com.example.sam.apcompsciquizapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Sam on 11/18/2017.
 */

@Entity(tableName = "Score")
public class Score {
    @ColumnInfo(name = "Correct")
    private int correct;

    @ColumnInfo(name = "Incorrect")
    private int incorrect;

    @PrimaryKey
    @ColumnInfo(name = "Question ID")
    private int id;

    @ColumnInfo(name = "User Choice")
    private String userChoice;

    public Score(int correct, int incorrect, int id, String userChoice) {
        this.correct = correct;
        this.incorrect = incorrect;
        this.id = id;
        this.userChoice = userChoice;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }

    public int getId() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(String userChoice) {
        this.userChoice = userChoice;
    }
}
