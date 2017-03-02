package com.example.mandles.decisionmaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;//allows handler to be used
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class DiceRoll extends AppCompatActivity
{

    ImageView dice_pic;//refs the images
    TextView roll_result;
    TextView ans_result;
    ImageButton dr_home;
    Random rng = new Random();//rng generator
    Handler handler; //message to roll dice
    Timer timer = new Timer();
    boolean rolling = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll);
        dice_pic = (ImageView) findViewById(R.id.dr_dice);
        ans_result = (TextView) findViewById(R.id.dr_result2);
        roll_result = (TextView) findViewById(R.id.dr_result1);
        handler = new Handler(callback);
        dr_home = (ImageButton) findViewById(R.id.dr_home);


        dr_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent activity_dice_roll = new Intent(DiceRoll.this, RPS.class);
                startActivity(activity_dice_roll);
            }
        });
    }

    public void HandleClick(View arg0)
    {
        if (!rolling)
        {
            rolling = true;
            //show rolling image
            dice_pic.setImageResource(R.drawable.dice3droll);
            //show the image
            timer.schedule(new Roll(), 400);
        }
    }

    class Roll extends TimerTask
    {
        public void run()
        {
            handler.sendEmptyMessage(0);
        }
    }

    Callback callback = new Callback() {
        public boolean handleMessage(Message msg) {
            //Get roll result
            //Remember nextInt returns 0 to 5 for argument of 6
            //hence + 1
            switch(rng.nextInt(6)+1) {
                case 1:
                    dice_pic.setImageResource(R.drawable.one);
                    roll_result.setText(new StringBuilder().append("You rolled: 1"));
                    ans_result.setText(new StringBuilder().append("Result: Yes!"));
                    break;
                case 2:
                    dice_pic.setImageResource(R.drawable.two);
                    roll_result.setText(new StringBuilder().append("You rolled: 2"));
                    ans_result.setText(new StringBuilder().append("Result: No!"));
                    break;
                case 3:
                    dice_pic.setImageResource(R.drawable.three);
                    roll_result.setText(new StringBuilder().append("You rolled: 3"));
                    ans_result.setText(new StringBuilder().append("Result: Yes!"));
                    break;
                case 4:
                    dice_pic.setImageResource(R.drawable.four);
                    roll_result.setText(new StringBuilder().append("You rolled: 4"));
                    ans_result.setText(new StringBuilder().append("Result: No!"));
                    break;
                case 5:
                    dice_pic.setImageResource(R.drawable.five);
                    roll_result.setText(new StringBuilder().append("You rolled: 5"));
                    ans_result.setText(new StringBuilder().append("Result: Yes!"));
                    break;
                case 6:
                    dice_pic.setImageResource(R.drawable.six);
                    roll_result.setText(new StringBuilder().append("You rolled: 6"));
                    ans_result.setText(new StringBuilder().append("Result: No!"));
                    break;
                default:
            }
            rolling=false;	//user can press again
            return true;
        }
    };

    //Clean up
    @Override
    protected void onPause() {
        super.onPause();
    }
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}