package com.example.suppafishing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "players.db";
    public static final String TABLE_NAME = "player_table";
    public static final String COL_1 = "id";
    public static final String COL_2 = "name";
    public static final String COL_3 = "money";
    public static final String COL_4 = "days";
    public static final String COL_5 = "guppy";
    public static final String COL_6 = "shrimp";
    public static final String COL_7 = "trout";
    public static final String COL_8 = "lobster";
    public static final String COL_9 = "net";
    public static final String COL_10 = "rod";
    public static final String COL_11 = "box";
    public static final String COL_12 = "guppy_price";
    public static final String COL_13 = "shrimp_price";
    public static final String COL_14 = "trout_price";
    public static final String COL_15 = "lobster_price";
    public static final String COL_16 = "net_price";
    public static final String COL_17 = "rod_price";
    public static final String COL_18 = "box_price";
    public static final String COL_19 = "day_remaining";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String newTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_2 + " TEXT, " +
                COL_3 + " INTEGER, " +
                COL_4 + " INTEGER, " +
                COL_5 + " INTEGER, " +
                COL_6 + " INTEGER, " +
                COL_7 + " INTEGER, " +
                COL_8 + " INTEGER, " +
                COL_9 + " INTEGER, " +
                COL_10 + " INTEGER, " +
                COL_11 + " INTEGER, " +
                COL_12 + " INTEGER, " +
                COL_13 + " INTEGER, " +
                COL_14 + " INTEGER, " +
                COL_15 + " INTEGER, " +
                COL_16 + " INTEGER, " +
                COL_17 + " INTEGER, " +
                COL_18 + " INTEGER, " +
                COL_19 + " INTEGER " +
                ") ";
        db.execSQL(newTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public long insertData(String name, int money, int days, int guppy, int shrimp, int trout,
                           int lobster, int net, int rod, int box, Market market){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, money);
        contentValues.put(COL_4, days);
        contentValues.put(COL_5, guppy);
        contentValues.put(COL_6, shrimp);
        contentValues.put(COL_7, trout);
        contentValues.put(COL_8, lobster);
        contentValues.put(COL_9, net);
        contentValues.put(COL_10, rod);
        contentValues.put(COL_11, box);
        contentValues.put(COL_12, market.getGuppy());
        contentValues.put(COL_13, market.getShrimp());
        contentValues.put(COL_14, market.getTrout());
        contentValues.put(COL_15, market.getLobster());
        contentValues.put(COL_16, market.getNet());
        contentValues.put(COL_17, market.getRod());
        contentValues.put(COL_18, market.getBox());
        contentValues.put(COL_19, market.getTime());
        long insertResult = db.insert(TABLE_NAME, null, contentValues);
        return insertResult;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String dataQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor result = db.rawQuery(dataQuery, null);
        return result;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }
}
