package com.example.sam.apcompsciquizapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Sam on 11/17/2017.
 */

@Dao
public interface QuizDao {
    @Insert
    void insertQuestion(Questions question);

    @Insert
    void insertScore(Score score);

    @Delete
    int deleteAllQuestions(Questions[] questions);

    @Delete
    int deleteAllScores(Score[] scores);

    @Update
    int updateQuestion(Questions question);

    @Update
    int updateScore(Score score);

    @Query("SELECT * FROM questions " + "WHERE id BETWEEN :id1 AND :id2")
    List<Questions> findQuestionsByID(int id1, int id2);

    @Query("SELECT * FROM score")
    List<Score> scores();
}
