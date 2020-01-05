package com.example.suppafishing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.suppafishing.databinding.ActivityGamePlayBinding;

import java.util.Random;

public class GamePlay extends AppCompatActivity {
    ActivityGamePlayBinding gamePlayBinding;
    TextView marketInfo;
    Player player;
    Random rand = new Random();
    int guppyRand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);
        gamePlayBinding = DataBindingUtil.setContentView(this, R.layout.activity_game_play);
        player = (Player) getIntent().getSerializableExtra("data");
        gamePlayBinding.setPlayer(player);
        marketInfo = findViewById(R.id.market_info);
        marketInfo.setText(player.getMarket().toString());
    }

    public void randomButton(View view){
        guppyRand = rand.nextInt(50);
        player.setGuppy(guppyRand);
        player.setShrimp(guppyRand);
        player.setTrout(guppyRand);
        player.setLobster(guppyRand);
        player.setRod(1);
        player.setNet(0);
        player.setName("AYY LMAO");
        gamePlayBinding.invalidateAll();
    }
}
