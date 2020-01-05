package com.example.suppafishing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //DatabaseHandler myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //myDb = new DatabaseHandler(this);
    }

    public void newGame(View view){
        Intent intent = new Intent(this, NewGame.class);
        startActivity(intent);
    }

    public void resumeGame(View view){
        Intent intent = new Intent(this, ResumeGame.class);
        startActivity(intent);
    }
}
