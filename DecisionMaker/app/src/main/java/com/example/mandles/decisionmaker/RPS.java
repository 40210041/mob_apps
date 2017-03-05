package com.example.mandles.decisionmaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class RPS extends AppCompatActivity implements OnClickListener {

    //set options
    public enum Option
    {
        Rock, Paper, Scissors
    }

    //set results
    public enum Result
    {
        win, loss, draw
    }

    //create vars to be used all over
    private Option uselect;
    private Option cpu_select;
    private Result result;
    ImageButton rps_home;
    ImageButton rps_rock;
    ImageButton rps_paper;
    ImageButton rps_scissors;
    ImageView rps_user;
    ImageView rps_cpu;
    TextView rps_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);

        //set the vars
        rps_rock = (ImageButton) findViewById(R.id.rps_rock);
        rps_paper = (ImageButton) findViewById(R.id.rps_paper);
        rps_scissors = (ImageButton) findViewById(R.id.rps_scissors);

        //set click event for buttons
        rps_rock.setOnClickListener(this);
        rps_paper.setOnClickListener(this);
        rps_scissors.setOnClickListener(this);

        //create var for rps_home
        rps_home = (ImageButton) findViewById(R.id.rps_home);

        //set the click function to go to the m.menu
        rps_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View rps_v) {
                //from rps, bring user back to m.menu
                Intent activity_rps = new Intent(RPS.this, MainMenu.class);
                startActivity(activity_rps);
            }
        });
    }

    // set the onclicklistener
    @Override
    public void onClick(View v)
    {
        //set the users image to what they pick
        rps_user = (ImageView) findViewById(R.id.rps_user);

        switch (v.getId())
        {
            //if the user chooses rock
            case R.id.rps_rock:
                uselect = Option.Rock;
                rps_user.setImageResource(R.drawable.rock);
                break;

            //if the user chooses paper
            case R.id.rps_paper:
                uselect = Option.Paper;
                rps_user.setImageResource(R.drawable.paper);
                break;

            //if the user chooses scissors
            case R.id.rps_scissors:
                uselect = Option.Scissors;
                rps_user.setImageResource(R.drawable.scissors);
                break;
        }
            //ref play()
            play();
            //ref showResults()
            showResults();
     }


    //set the rng
    private void play()
    {
        //set rng, 1/3 chance of either rock, paper, or scissors
        int random = ((int)(Math.random()*10)) %3;
        //set the cpus image to what the rng decides
        rps_cpu = (ImageView) findViewById(R.id.rps_cpu);

        // set the rng
        switch (random)
        {
            //if the rng chooses rock
            case 0:
                cpu_select = Option.Rock;
                rps_cpu.setImageResource(R.drawable.rock);
                break;

            //if the rng chooses paper
            case 1:
                cpu_select = Option.Paper;
                rps_cpu.setImageResource(R.drawable.paper);
                break;

            //if the rng chooses scissors
            case 2:
                cpu_select = Option.Scissors;
                rps_cpu.setImageResource(R.drawable.scissors);
                break;
        }

        //set the message
        //if the result is a draw
        if(cpu_select == uselect)
        {
            result = result.draw;
        }
        //if the user loses
        else if (cpu_select == Option.Rock && uselect == Option.Scissors)
        {
            result = result.loss;
        }
        else if (cpu_select == Option.Paper && uselect == Option.Rock)
        {
            result = result.loss;
        }
        else if (cpu_select == Option.Scissors && uselect == Option.Paper)
        {
            result = result.loss;
        }
        //if the user wins
        else
        {
            result = result.win;
        }
    }

    //show the result message
    private void showResults()
    {
        rps_result = (TextView) findViewById(R.id.rps_result);

        //show the message in accordance to the result
        //if the user loses
        if (result == result.loss)
        {
            rps_result.setText(new StringBuilder().append("You lose!"));
        }
        //if the user wins
        else if (result == result.win)
        {
            rps_result.setText(new StringBuilder().append("You win!"));
        }
        //if the result is a draw
        else if (result == result.draw)
        {
            rps_result.setText(new StringBuilder().append("It's a draw!"));
        }
    }
}