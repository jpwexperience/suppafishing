package com.example.suppafishing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewGame extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName, editMoney, editDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        myDb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.name_input);
        editMoney = (EditText) findViewById(R.id.money_input);
        editDays = (EditText) findViewById(R.id.days_input);
    }

    public void addData(View view){
        boolean isInserted = myDb.insertData(editName.getText().toString(),
                Integer.parseInt(editMoney.getText().toString()),
                Integer.parseInt(editDays.getText().toString()));
        if(isInserted){
            Toast.makeText(NewGame.this, "Data Inserted", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(NewGame.this, "Data NOT Inserted", Toast.LENGTH_LONG).show();
        }
    }

}
