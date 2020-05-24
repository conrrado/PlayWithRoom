package com.ccamacho.playwithroom.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "play_game")
public class PlayGame {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String name;

    @ColumnInfo(name = "number_of_players")
    private int players;

    private String description;

    public PlayGame(String name, Integer players, String description) {
        this.name = name;
        this.players = players;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlayers() {
        return players;
    }

    public void setPlayers(Integer players) {
        this.players = players;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
