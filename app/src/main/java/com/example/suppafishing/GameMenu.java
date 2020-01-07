package com.example.suppafishing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.suppafishing.databinding.ActivityGamePlayBinding;

import java.util.Random;

public class GameMenu extends AppCompatActivity {
    DatabaseHandler myDb;
    ActivityGamePlayBinding gamePlayBinding;
    Player player;
    Random rand = new Random();
    int guppyRand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);
        myDb = new DatabaseHandler(this);
        gamePlayBinding = DataBindingUtil.setContentView(this, R.layout.activity_game_play);
        player = getIntent().getExtras().getParcelable("data");
        gamePlayBinding.setPlayer(player);
    }

    public void enterMarketplace(View view){
        Intent intent = new Intent(this, Marketplace.class);
        intent.putExtra("data", player);
        startActivity(intent);
    }

    public void randomButton(View view){
        guppyRand = rand.nextInt(50);
        player.setGuppy(guppyRand);
        player.setShrimp(guppyRand);
        player.setTrout(guppyRand);
        player.setLobster(guppyRand);
        player.setRod(1);
        player.setBox(1);
        gamePlayBinding.invalidateAll();
    }

    public void enterFishing(View view){
        Intent intent = new Intent(this, Fishing.class);
        intent.putExtra("data", player);
        startActivity(intent);
    }

    public void savePlayer(View view){
        myDb.updatePlayer(player, player.getMarket());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
