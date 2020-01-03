package com.example.suppafishing;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "players.db";
    public static final String TABLE_NAME = "player_table";
    public static final String COL_1 = "id";
    public static final String COL_2 = "name";
    public static final String COL_3 = "money";
    public static final String COL_4 = "days";
    public static final String COL_5 = "guppies";
    public static final String COL_6 = "shrimp";
    public static final String COL_7 = "trout";
    public static final String COL_8 = "lobster";
    public static final String COL_9 = "net";
    public static final String COL_10 = "rod";
    public static final String COL_11 = "box";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String newTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_2 + " TEXT, " +
                COL_3 + " INTEGER, " +
                COL_4 + " INTEGER, " +
                COL_5 + " INTEGER DEFAULT 0, " +
                COL_6 + " INTEGER DEFAULT 0, " +
                COL_7 + " INTEGER DEFAULT 0, " +
                COL_8 + " INTEGER DEFAULT 0, " +
                COL_9 + " INTEGER DEFAULT 1, " +
                COL_10 + " INTEGER DEFAULT 0, " +
                COL_11 + " INTEGER DEFAULT 0" +
                ") ";
        db.execSQL(newTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public boolean insertData(String name, int money, int days){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, money);
        contentValues.put(COL_4, days);
        long insertResult = db.insert(TABLE_NAME, null, contentValues);
        return insertResult != -1;
    }
}
