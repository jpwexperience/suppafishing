package com.example.suppafishing;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.concurrent.ThreadLocalRandom;

public class Fishing extends AppCompatActivity {
    Player player;
    TextView generalInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishing);
        player = getIntent().getExtras().getParcelable("data");
        generalInfo = findViewById(R.id.general_info);
        updatePlayerInfo();
    }

    public void updatePlayerInfo(){
        generalInfo.setText(player.toString() + "\n" + player.getMarket().toString());}

    public void updateMarketTime(int time){
        int timeRemaining = player.getMarket().getTime();
        if(timeRemaining - time > 0){
            player.getMarket().setTime(timeRemaining - time);
        }
        else{
                player.setDays(player.getDays() - 1);
                player.getMarket().setTime(24);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void fishGuppy(View view){
        int randomFish = ThreadLocalRandom.current().nextInt(1, 30 + 1);
        int time = 1;
        player.setGuppy(player.getGuppy() + randomFish);
        updateMarketTime(time);
        updatePlayerInfo();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void fishShrimp(View view){
        int randomFish = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        int time = 2;
        player.setShrimp(player.getShrimp() + randomFish);
        updateMarketTime(time);
        updatePlayerInfo();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void fishTrout(View view){
        int randomFish = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        int time = 5;
        player.setTrout(player.getTrout() + randomFish);
        updateMarketTime(time);
        updatePlayerInfo();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void fishLobster(View view){
        int randomFish = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        int time = 10;
        player.setLobster(player.getLobster() + randomFish);
        updateMarketTime(time);
        updatePlayerInfo();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, GameMenu.class);
        intent.putExtra("data", player);
        startActivity(intent);
    }
}
