package com.example.suppafishing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //DatabaseHandling myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //myDb = new DatabaseHandling(this);
    }

    public void newGame(View view){
        Intent intent = new Intent(this, NewGame.class);
        startActivity(intent);
    }
}
