package com.example.suppafishing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {
    TextView info;
    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        player = getIntent().getExtras().getParcelable("data");
        info = findViewById(R.id.player_info);
    }
}
