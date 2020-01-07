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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void fishGuppy(View view){
        int randomNum = ThreadLocalRandom.current().nextInt(1, 30 + 1);
        player.setGuppy(player.getGuppy() + randomNum);
        updatePlayerInfo();
    }

    public void fishShrimp(View view){
        int randomNum = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        player.setShrimp(player.getShrimp() + randomNum);
        updatePlayerInfo();
    }

    public void fishTrout(View view){
        int randomNum = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        player.setTrout(player.getTrout() + randomNum);
        updatePlayerInfo();
    }

    public void fishLobster(View view){
        int randomNum = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        player.setLobster(player.getLobster() + randomNum);
        updatePlayerInfo();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, GameMenu.class);
        intent.putExtra("data", player);
        startActivity(intent);
    }
}
