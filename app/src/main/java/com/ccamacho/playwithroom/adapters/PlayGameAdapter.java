package com.ccamacho.playwithroom.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ccamacho.playwithroom.R;
import com.ccamacho.playwithroom.model.PlayGame;

import java.util.List;

public class PlayGameAdapter extends RecyclerView.Adapter<PlayGameAdapter.PlayGameViewHolder> {

    List<PlayGame> playGameList;

    public PlayGameAdapter(List<PlayGame> playGameList) {
        this.playGameList = playGameList;
    }

    @NonNull
    @Override
    public PlayGameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.playgame_item, parent, false);
        return new PlayGameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayGameViewHolder holder, int position) {
        holder.bind(playGameList.get(position));
    }

    @Override
    public int getItemCount() {
        return playGameList.size();
    }

    static class PlayGameViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewDescription;
        TextView textViewId;
        TextView textViewPlayers;

        public PlayGameViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView_name);
            textViewDescription = itemView.findViewById(R.id.textView_description);
            textViewId = itemView.findViewById(R.id.textView_id);
            textViewPlayers = itemView.findViewById(R.id.textView_players);
        }

        void bind(PlayGame playGame) {
            textViewName.setText(playGame.getName());
            textViewDescription.setText(playGame.getDescription());
            textViewId.setText(String.valueOf(playGame.getId()));
            textViewPlayers.setText(String.valueOf(playGame.getPlayers()));
        }
    }
}
