package com.example.suppafishing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ResumeGame extends AppCompatActivity {
    DatabaseHandler myDb;
    LinearLayout resumeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_game);
        resumeLayout = findViewById(R.id.games);
        myDb = new DatabaseHandler(this);
        showGames();
    }

    public LinearLayout createGameRow(String content, String id){
        final LinearLayout gameRow = new LinearLayout(this);
        gameRow.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        gameRow.setOrientation(LinearLayout.HORIZONTAL);

        TextView tempText = new TextView(this);
        tempText.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        tempText.setText(content);
        Integer.parseInt(id);

        final Button playButton = new Button(this);
        playButton.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        playButton.setText("Play");
        playButton.setId(Integer.parseInt(id));
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame(playButton.getId());
            }
        });

        final Button deleteButton = new Button(this);
        deleteButton.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        deleteButton.setText("Delete");
        deleteButton.setId(Integer.parseInt(id));
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteGame(deleteButton.getId());
                ((ViewManager) gameRow.getParent()).removeView(gameRow);
            }
        });

        gameRow.addView(tempText);
        gameRow.addView(playButton);
        gameRow.addView(deleteButton);
        return gameRow;
    }

    public void showGames(){
        Cursor data = myDb.getAllData();
        while(data.moveToNext()){
            String rowId = data.getString(0);
            String gameTxt = data.getString(1) +
                    " | Money: $" + data.getString(2) +
                    " | Days Left: " + data.getString(3);
            LinearLayout gameInfoRow = createGameRow(gameTxt, rowId);
            resumeLayout.addView(gameInfoRow);
        }
    }

    public void deleteGame(int id){
        int status = myDb.deleteRow(String.valueOf(id));
        if(status != 0){
            Toast.makeText(ResumeGame.this, "Game Deleted", Toast.LENGTH_LONG).show();
        }
    }

    public void startGame(int id){
        Cursor data = myDb.getRow(String.valueOf(id));
        Market resumeMarket;
        Player resumePlayer;
        data.moveToNext();
        int player_id = Integer.parseInt(data.getString(0));
        String name = data.getString(1);
        int money = Integer.parseInt(data.getString(2));
        int days = Integer.parseInt(data.getString(3));
        int guppy = Integer.parseInt(data.getString(4));
        int shrimp = Integer.parseInt(data.getString(5));
        int trout = Integer.parseInt(data.getString(6));
        int lobster = Integer.parseInt(data.getString(7));
        int net = Integer.parseInt(data.getString(8));
        int rod = Integer.parseInt(data.getString(9));
        int box = Integer.parseInt(data.getString(10));
        int guppy_price = Integer.parseInt(data.getString(11));
        int shrimp_price = Integer.parseInt(data.getString(12));
        int trout_price = Integer.parseInt(data.getString(13));
        int lobster_price = Integer.parseInt(data.getString(14));
        int net_price = Integer.parseInt(data.getString(15));
        int rod_price = Integer.parseInt(data.getString(16));
        int box_price = Integer.parseInt(data.getString(17));
        int day_remaining = Integer.parseInt(data.getString(18));
        resumeMarket = new Market(net_price, rod_price, box_price, guppy_price, shrimp_price,
                trout_price, lobster_price, day_remaining);
        resumePlayer = new Player(player_id, name, money, days, guppy,
                shrimp, trout, lobster, net, rod, box, resumeMarket);
        Intent intent = new Intent(ResumeGame.this, GameMenu.class);
        intent.putExtra("data", resumePlayer);
        startActivity(intent);
    }
}
