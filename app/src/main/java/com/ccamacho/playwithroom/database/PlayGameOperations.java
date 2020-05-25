package com.ccamacho.playwithroom.database;

import android.content.Context;
import android.os.AsyncTask;

import com.ccamacho.playwithroom.model.PlayGame;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PlayGameOperations {

    private DatabaseConnection connection;

    public PlayGameOperations(Context context) {
        connection = DatabaseConnection.getInstance(context);
    }

    public void insertPlayGame(PlayGame game) {
        new InsertGameTask(connection).execute(game);
    }

    public List<PlayGame> getAllGames() {
        List<PlayGame> playGameList = new ArrayList<>();

        try {
            playGameList = new GetAllGamesTask(connection).execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return playGameList;
    }

    public void deletePlayGame(PlayGame playGame) {
        new DeleteGameTask(connection).execute(playGame);
    }

    private static class InsertGameTask extends AsyncTask<PlayGame, Void, Void> {

        private DatabaseConnection connection;

        InsertGameTask(DatabaseConnection connection) {
            this.connection = connection;
        }

        @Override
        protected Void doInBackground(PlayGame... playGames) {
            connection.playGameDao().insert(playGames[0]);
            return null;
        }
    }

    private static class GetAllGamesTask extends AsyncTask<Void, Void, List<PlayGame>> {

        private DatabaseConnection connection;

        GetAllGamesTask(DatabaseConnection connection) {
            this.connection = connection;
        }

        @Override
        protected List<PlayGame> doInBackground(Void... voids) {
            return connection.playGameDao().getAll();
        }
    }

    private static class DeleteGameTask extends AsyncTask<PlayGame, Void, Void> {

        private DatabaseConnection connection;

        DeleteGameTask(DatabaseConnection connection) {
            this.connection = connection;
        }

        @Override
        protected Void doInBackground(PlayGame... playGames) {
            connection.playGameDao().delete(playGames[0]);
            return null;
        }
    }

}
