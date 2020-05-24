package com.ccamacho.playwithroom.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ccamacho.playwithroom.model.PlayGame;

import java.util.List;

@Dao
public interface PlayGameDao {

    @Insert
    void insert(PlayGame playGame);

    @Query("SELECT * FROM play_game")
    List<PlayGame> getAll();

//    @Query("SELECT * FROM play_game WHERE id = :id")
//    PlayGame getById(int id);

//    @Update
//    void update(PlayGame playGame);

    @Delete
    void delete(PlayGame playGame);
}
