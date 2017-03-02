package com.example.mandles.decisionmaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    Button btn_rps;
    Button btn_coin_toss;
    Button btn_dice_roll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btn_rps = (Button) findViewById(R.id.btn_rps);
        btn_coin_toss = (Button) findViewById(R.id.btn_coin_toss);
        btn_dice_roll = (Button) findViewById(R.id.btn_dice_roll);

        btn_rps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent activity_main_menu = new Intent(MainMenu.this, RPS.class);
                startActivity(activity_main_menu);
            }
        });

        btn_coin_toss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent activity_main_menu = new Intent(MainMenu.this, CoinToss.class);
                startActivity(activity_main_menu);
            }
        });

        btn_dice_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent activity_main_menu = new Intent(MainMenu.this, DiceRoll.class);
                startActivity(activity_main_menu);
            }
        });
    }
}
