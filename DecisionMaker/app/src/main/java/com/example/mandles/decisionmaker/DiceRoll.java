package com.example.mandles.decisionmaker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler; //allows handler to be used
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class DiceRoll extends AppCompatActivity
{

    // create vars to be used all over
    boolean rolling = false;
    ImageButton dr_home;
    ImageView dice_pic;
    Random rng = new Random();
    //message to roll dice
    Handler handler;
    TextView roll_result;
    TextView ans_result;
    Timer timer = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll);

        //set the vars
        dice_pic = (ImageView) findViewById(R.id.dr_dice);
        ans_result = (TextView) findViewById(R.id.dr_result2);
        roll_result = (TextView) findViewById(R.id.dr_result1);
        handler = new Handler(callback);

        //create var for dr_home
        dr_home = (ImageButton) findViewById(R.id.dr_home);

        //set the click function to go to the m.menu
        dr_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View dr_v)
            {
                //from dice roll, bring user back to m.menu
                Intent activity_dice_roll = new Intent(DiceRoll.this, MainMenu.class);
                startActivity(activity_dice_roll);
            }
        });
    }

    public void HandleClick(View arg0)
    {
        //if the dice is not rolling
        if (!rolling)
        {
            //set it to true
            rolling = true;

            //show "rolling" image
            dice_pic.setImageResource(R.drawable.dice3droll);

            //set a delay to show the image
            timer.schedule(new Roll(), 250);
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
            //get roll result
            //nextInt is inclusive so returns 0 to 5 for argument of 6 (hence + 1)
            switch(rng.nextInt(6)+1) {
                //if user rolls a 1
                case 1:
                    dice_pic.setImageResource(R.drawable.one);
                    roll_result.setText(new StringBuilder().append("You rolled: 1"));
                    ans_result.setText(new StringBuilder().append("Result: Yes!"));
                    break;

                //if user rolls a 2
                case 2:
                    dice_pic.setImageResource(R.drawable.two);
                    roll_result.setText(new StringBuilder().append("You rolled: 2"));
                    ans_result.setText(new StringBuilder().append("Result: No!"));
                    break;

                //if user rolls a 3
                case 3:
                    dice_pic.setImageResource(R.drawable.three);
                    roll_result.setText(new StringBuilder().append("You rolled: 3"));
                    ans_result.setText(new StringBuilder().append("Result: Yes!"));
                    break;

                //if the user rolls a 4
                case 4:
                    dice_pic.setImageResource(R.drawable.four);
                    roll_result.setText(new StringBuilder().append("You rolled: 4"));
                    ans_result.setText(new StringBuilder().append("Result: No!"));
                    break;

                //if the user rolls 5
                case 5:
                    dice_pic.setImageResource(R.drawable.five);
                    roll_result.setText(new StringBuilder().append("You rolled: 5"));
                    ans_result.setText(new StringBuilder().append("Result: Yes!"));
                    break;

                //if the user rolls a 6
                case 6:
                    dice_pic.setImageResource(R.drawable.six);
                    roll_result.setText(new StringBuilder().append("You rolled: 6"));
                    ans_result.setText(new StringBuilder().append("Result: No!"));
                    break;
                default:
            }
            //user can roll again
            rolling=false;
            return true;
        }
    };
}