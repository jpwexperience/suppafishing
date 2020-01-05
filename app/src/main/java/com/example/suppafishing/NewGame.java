package com.example.suppafishing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewGame extends AppCompatActivity {
    DatabaseHandler myDb;
    EditText editName, editMoney, editDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        myDb = new DatabaseHandler(this);

        editName = (EditText) findViewById(R.id.name_input);
        editMoney = (EditText) findViewById(R.id.money_input);
        editDays = (EditText) findViewById(R.id.days_input);
    }

    public void startGame(View view){
        String name = editName.getText().toString();
        int money = Integer.parseInt(editMoney.getText().toString());
        int days = Integer.parseInt(editDays.getText().toString());
        int guppy = 0;
        int shrimp = 0;
        int trout = 0;
        int lobster = 0;
        int net = 1;
        int rod = 0;
        int box = 0;
        long insertId = myDb.insertData(name, money, days, guppy, shrimp, trout, lobster, net, rod, box, new Market());
        if(insertId != -1){
            Toast.makeText(NewGame.this, "Data Inserted", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(NewGame.this, "Data NOT Inserted", Toast.LENGTH_LONG).show();
        }
        Player newPlayer = new Player((int) insertId, name, money, days, guppy, shrimp, trout, lobster, net, rod, box, new Market());
        Intent intent = new Intent(this, GameMenu.class);
        intent.putExtra("data", newPlayer);
        startActivity(intent);
    }

    public void viewAll(View view){
        Cursor result = myDb.getAllData();
        if(result.getCount() == 0){
            showMessage("HOWDY", "NO DATA");
        }
        StringBuffer buffer = new StringBuffer();
        while(result.moveToNext()){
            buffer.append("Id: " + result.getString(0) + "\n");
            buffer.append("Name: " + result.getString(1) + "\n");
            buffer.append("Money: " + result.getString(2) + "\n");
            buffer.append("Days: " + result.getString(3) + "\n\n");
        }
        showMessage("HOWDY", buffer.toString());
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
