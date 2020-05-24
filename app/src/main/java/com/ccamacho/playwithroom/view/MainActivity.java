package com.ccamacho.playwithroom.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.ccamacho.playwithroom.R;
import com.ccamacho.playwithroom.adapters.PlayGameAdapter;
import com.ccamacho.playwithroom.database.DatabaseConnection;
import com.ccamacho.playwithroom.databinding.ActivityMainBinding;
import com.ccamacho.playwithroom.model.PlayGame;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<PlayGame> playGameList;
    DatabaseConnection connection;
    PlayGameAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        playGameList = new ArrayList<>();
        connection = DatabaseConnection.getInstance(this);

        adapter = new PlayGameAdapter(playGameList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);

        binding.buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayGame playGame = new PlayGame("Pega-pega", 3, "Brincar de pega pega");
                connection.playGameDao().insert(playGame);
                updateList();
            }
        });

        binding.buttonGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateList();
            }
        });

        binding.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!playGameList.isEmpty()) {
                    connection.playGameDao().delete(playGameList.get(playGameList.size() - 1));
                    updateList();
                }
            }
        });
    }

    private void updateList() {
        playGameList.clear();
        playGameList.addAll(connection.playGameDao().getAll());
        binding.recyclerView.scrollToPosition(adapter.getItemCount() - 1);
        adapter.notifyDataSetChanged();
    }
}
