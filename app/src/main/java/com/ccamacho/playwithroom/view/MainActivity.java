package com.ccamacho.playwithroom.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.ccamacho.playwithroom.adapters.PlayGameAdapter;
import com.ccamacho.playwithroom.database.PlayGameOperations;
import com.ccamacho.playwithroom.databinding.ActivityMainBinding;
import com.ccamacho.playwithroom.model.PlayGame;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<PlayGame> playGameList;
    PlayGameAdapter adapter;
    PlayGameOperations operations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        playGameList = new ArrayList<>();
        operations = new PlayGameOperations(this);

        adapter = new PlayGameAdapter(playGameList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);

        binding.buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayGame playGame = new PlayGame("Pega-pega", 3, "Brincar de pega pega");
                operations.insertPlayGame(playGame);
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
                    operations.deletePlayGame(playGameList.get(playGameList.size() - 1));
                    updateList();
                }
            }
        });

        updateList();
    }

    private void updateList() {
        playGameList.clear();
        playGameList.addAll(operations.getAllGames());
        binding.recyclerView.scrollToPosition(adapter.getItemCount() - 1);
        adapter.notifyDataSetChanged();
    }
}
