package com.example.suppafishing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.suppafishing.databinding.ActivityMarketplaceBinding;

public class Marketplace extends AppCompatActivity {
    ActivityMarketplaceBinding activityMarketplaceBinding;
    Player player;
    Button guppyInc, guppyDec, shrimpInc, shrimpDec, troutInc, troutDec, lobsterInc, lobsterDec;
    TextView guppySell, shrimpSell, troutSell, lobsterSell,
            guppyStock, shrimpStock, troutStock, lobsterStock, moneyStatus;
    int guppy, shrimp, trout, lobster, guppyTemp, shrimpTemp, troutTemp, lobsterTemp, money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);
        activityMarketplaceBinding = DataBindingUtil.setContentView(this, R.layout.activity_marketplace);
        player = getIntent().getExtras().getParcelable("data");
        activityMarketplaceBinding.setPlayer(player);

        guppy = guppyTemp = player.getGuppy();
        shrimp = shrimpTemp = player.getShrimp();
        trout = troutTemp = player.getTrout();
        lobster = lobsterTemp= player.getLobster();
        money = player.getMoney();

        guppyStock = findViewById(R.id.guppy_stock);
        guppyStock.setText("Guppies: " + guppyTemp);
        guppySell = findViewById(R.id.guppy_sell);
        guppyInc = findViewById(R.id.guppy_inc);
        guppyDec = findViewById(R.id.guppy_dec);

        shrimpStock = findViewById(R.id.shrimp_stock);
        shrimpStock.setText("Shrimp: " + shrimpTemp);
        shrimpSell = findViewById(R.id.shrimp_sell);
        shrimpInc = findViewById(R.id.shrimp_inc);
        shrimpDec = findViewById(R.id.shrimp_dec);

        troutStock = findViewById(R.id.trout_stock);
        troutStock.setText("Trout: " + troutTemp);
        troutSell = findViewById(R.id.trout_sell);
        troutInc = findViewById(R.id.trout_inc);
        troutDec = findViewById(R.id.trout_dec);

        lobsterStock = findViewById(R.id.lobster_stock);
        lobsterStock.setText("Lobster: " + lobsterTemp);
        lobsterSell = findViewById(R.id.lobster_sell);
        lobsterInc = findViewById(R.id.lobster_inc);
        lobsterDec = findViewById(R.id.lobster_dec);

        moneyStatus = findViewById(R.id.money_status);
        moneyStatus.setText("Money: $" + money);
    }

    public void incGuppy(View view){
        int sellCount = Integer.parseInt(guppySell.getText().toString()) + 1;
        if(sellCount <= guppy){
            guppyTemp--;
            guppyStock.setText("Guppies: " + guppyTemp);
            guppySell.setText(String.valueOf(sellCount));
        }
    }

    public void decGuppy(View view){
        int sellCount = Integer.parseInt(guppySell.getText().toString()) - 1;
        if(sellCount >= 0){
            guppyTemp++;
            guppyStock.setText("Guppies: " + guppyTemp);
            guppySell.setText(String.valueOf(sellCount));
        }
    }

    public void incShrimp(View view){
        int sellCount = Integer.parseInt(shrimpSell.getText().toString()) + 1;
        if(sellCount <= shrimp){
            shrimpTemp--;
            shrimpStock.setText("Shrimp: " + shrimpTemp);
            shrimpSell.setText(String.valueOf(sellCount));
        }
    }

    public void decShrimp(View view){
        int sellCount = Integer.parseInt(shrimpSell.getText().toString()) - 1;
        if(sellCount >= 0){
            shrimpTemp++;
            shrimpStock.setText("Shrimp: " + shrimpTemp);
            shrimpSell.setText(String.valueOf(sellCount));
        }
    }

    public void incTrout(View view){
        int sellCount = Integer.parseInt(troutSell.getText().toString()) + 1;
        if(sellCount <= trout){
            troutTemp--;
            troutStock.setText("Trout: " + troutTemp);
            troutSell.setText(String.valueOf(sellCount));
        }
    }

    public void decTrout(View view){
        int sellCount = Integer.parseInt(troutSell.getText().toString()) - 1;
        if(sellCount >= 0){
            troutTemp++;
            troutStock.setText("Trout: " + troutTemp);
            troutSell.setText(String.valueOf(sellCount));
        }
    }

    public void incLobster(View view){
        int sellCount = Integer.parseInt(lobsterSell.getText().toString()) + 1;
        if(sellCount <= lobster){
            lobsterTemp--;
            lobsterStock.setText("Lobster: " + lobsterTemp);
            lobsterSell.setText(String.valueOf(sellCount));
        }
    }

    public void decLobster(View view){
        int sellCount = Integer.parseInt(lobsterSell.getText().toString()) - 1;
        if(sellCount >= 0){
            lobsterTemp++;
            lobsterStock.setText("Lobster: " + lobsterTemp);
            lobsterSell.setText(String.valueOf(sellCount));
        }
    }

    public void sellFish(int guppyCount, int shrimpCount, int troutCount, int lobsterCount){
        int guppyProfit = guppyCount * player.getMarket().getGuppy();
        int shrimpProfit = shrimpCount * player.getMarket().getShrimp();
        int troutProfit = troutCount * player.getMarket().getTrout();
        int lobsterProfit = lobsterCount * player.getMarket().getLobster();
        int totalProfit = guppyProfit + shrimpProfit + troutProfit + lobsterProfit;
        guppy = guppyTemp = guppy - guppyCount;
        shrimp = shrimpTemp = shrimp - shrimpCount;
        trout = troutTemp = trout - troutCount;
        lobster = lobsterTemp = lobster - lobsterCount;
        player.setGuppy(guppy);
        player.setShrimp(shrimp);
        player.setTrout(trout);
        player.setLobster(lobster);
        player.setMoney(money + totalProfit);
        money = player.getMoney();
        moneyStatus.setText("Money: $" + money);
        guppySell.setText("0");
        shrimpSell.setText("0");
        troutSell.setText("0");
        lobsterSell.setText("0");
    }

    public void mainSell(View view){
        int guppyCount = Integer.parseInt(guppySell.getText().toString());
        int shrimpCount = Integer.parseInt(shrimpSell.getText().toString());
        int troutCount = Integer.parseInt(troutSell.getText().toString());
        int lobsterCount = Integer.parseInt(lobsterSell.getText().toString());
        sellFish(guppyCount, shrimpCount, troutCount, lobsterCount);
    }

    public void sellAll(View view){
        sellFish(guppy, shrimp, trout, lobster);
        guppyStock.setText("Guppies: 0");
        shrimpStock.setText("Shrimp: 0");
        troutStock.setText("Trout: 0");
        lobsterStock.setText("Lobster: 0");
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, GameMenu.class);
        intent.putExtra("data", player);
        startActivity(intent);
    }
}
