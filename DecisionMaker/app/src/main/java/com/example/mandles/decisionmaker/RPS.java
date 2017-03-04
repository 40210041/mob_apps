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
        rps_user = (ImageView) findViewById(R.id.rps_user);
        boolean play = true;

        switch (v.getId())
        {
            case R.id.rps_rock:
                uselect = Option.Rock;
                rps_user.setImageResource(R.drawable.rock);
                break;

            case R.id.rps_paper:
                uselect = Option.Paper;
                rps_user.setImageResource(R.drawable.paper);
                break;

            case R.id.rps_scissors:
                uselect = Option.Scissors;
                rps_user.setImageResource(R.drawable.scissors);
                break;
        }

        if (play) {
            play();
            showResults();
        }
     }


    //set the rng
    private void play()
    {
        int random = ((int)(Math.random()*10)) %3;
        cpu_select = null;
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
        //if the user looses
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

    // Chunk to show the result message
    private void showResults()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(RPS.this);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                //do nothing
            }
        });
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

/*
/*

    Used apieceofmycode.blogspt.co.uk as a guide
    changed a lot of things and has no images
    doesnt have half the things he does



package com.example.mandles.rpstut;

// Import the libraries required
        import android.graphics.Path;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.app.Activity;
        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.ImageView;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public enum Option
    {
        ROCK, PAPER, SCISSORS
    }

    public enum Result
    {
        WIN, LOSS, DRAW
    }

    private Option userSelect;
    private Result gameResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_Rock = (Button) findViewById(R.id.btn_Rock);
        Button btn_Paper = (Button) findViewById(R.id.btn_Paper);
        Button btn_Scissors = (Button) findViewById(R.id.btn_Scissors);

        // set click listening event for buttons
        btn_Rock.setOnClickListener(this);
        btn_Paper.setOnClickListener(this);
        btn_Scissors.setOnClickListener(this);

    // set the onclicklistener
    @Override
    public void onClick(View v) {
        TextView txtv = (TextView) findViewById(R.id.txt_uchoice);
        boolean play = true;

        switch (v.getId())
        {
            case R.id.btn_Rock:
                userSelect = Option.ROCK;
                txtv.setText("Rock");
                break;

            case R.id.btn_Paper:
                userSelect = Option.PAPER;
                txtv.setText("Paper");
                break;

            case R.id.btn_Scissors:
                userSelect = Option.SCISSORS;
                txtv.setText("Scissors");
                break;
        }

        if (play) {
            play();
            showResults();
        }
    }
    // chunk to determine the rng
    private void play()
    {
        int random = ((int)(Math.random()*10)) %3;
        Option androidSelect = null;
        TextView txt_and = (TextView) findViewById(R.id.txt_rngchoice);

        // set the rng
        switch (random)
        {
            case 0:
                androidSelect = Option.ROCK;
                txt_and.setText("Rock");
                break;

            case 1:
                androidSelect = Option.PAPER;
                txt_and.setText("Paper");
                break;

            case 2:
                androidSelect = Option.SCISSORS;
                txt_and.setText("Scissors");
                break;
        }

        if(androidSelect == userSelect)
        {
            gameResult = gameResult.DRAW;
        }
        else if (androidSelect == Option.ROCK && userSelect == Option.SCISSORS)
        {
            gameResult = gameResult.LOSS;
        }
        else if (androidSelect == Option.PAPER && userSelect == Option.ROCK)
        {
            gameResult = gameResult.LOSS;
        }
        else if (androidSelect == Option.SCISSORS && userSelect == Option.PAPER)
        {
            gameResult = gameResult.LOSS;
        }
        else
        {
            gameResult = gameResult.WIN;
        }
    }



    // Chunk to show the result message
    private void showResults()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                //do nothing
            }
        });

        //set the message to accomodate the result
        if (gameResult == gameResult.LOSS)
        {
            builder.setMessage("You Lose!");
        }
        else if (gameResult == gameResult.WIN)
        {
            builder.setMessage("You win!");
        }
        else if (gameResult == gameResult.DRAW)
        {
            builder.setMessage("Its a draw!");
        }

        AlertDialog alert = builder.create();
        alert.show();
    }


}


 */