package com.ccamacho.playwithroom.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.ccamacho.playwithroom.model.PlayGame;

import java.util.List;

@Dao
public interface PlayGameDao {

    @Insert
    void insert(PlayGame playGame);

    @Query("SELECT * FROM play_game")
    List<PlayGame> getAll();

    @Delete
    void delete(PlayGame playGame);
}
