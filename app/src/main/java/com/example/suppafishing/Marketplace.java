package com.example.suppafishing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Marketplace extends AppCompatActivity {
    Player player;
    Button incButton, decButton;
    TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);
        incButton = findViewById(R.id.increment_button);
        decButton = findViewById(R.id.decrement_button);
        count = findViewById(R.id.count);
        player = (Player) getIntent().getSerializableExtra("data");
    }

    public void incrementButton(View view){
        int currentVal = Integer.parseInt(count.getText().toString());
        currentVal++;
        count.setText(String.valueOf(currentVal));
    }

    public void decrementButton(View view){
        int currentVal = Integer.parseInt(count.getText().toString());
        currentVal--;
        count.setText(String.valueOf(currentVal));
    }
}
