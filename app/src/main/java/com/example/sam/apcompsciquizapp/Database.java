package com.example.sam.apcompsciquizapp;

import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Sam on 11/17/2017.
 */
@android.arch.persistence.room.Database(entities = {Questions.class, Score.class}, version = 1)
abstract class Database extends RoomDatabase {
    public abstract QuizDao getQuizDao();
}