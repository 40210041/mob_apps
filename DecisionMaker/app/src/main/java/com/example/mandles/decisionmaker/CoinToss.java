package com.example.mandles.decisionmaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class CoinToss extends AppCompatActivity {

    //create vars to be used all over
    public static final Random RANDOM = new Random();
    ImageView ct_coin;
    Button ct_toss;
    ImageButton ct_home;
    TextView ct_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_toss);

        //set the vars
        ct_coin = (ImageView) findViewById(R.id.ct_coin);
        ct_toss = (Button) findViewById(R.id.ct_toss);
        ct_result = (TextView) findViewById(R.id.ct_result);
        ct_home = (ImageButton) findViewById(R.id.ct_home);

        //set the click function to flip the coin
        ct_toss.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //ref flipCoin()
                flipCoin();
            }
        });

        //set the click function to go to the m.menu
        ct_home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View ct_v)
            {
                Intent activity_coin_toss = new Intent(CoinToss.this, MainMenu.class);
                startActivity(activity_coin_toss);
            }
        });

    }

    private void flipCoin()
    {
        //fadeout animation
        Animation fadeOut = new AlphaAnimation(1,0);
        fadeOut.setInterpolator((new AccelerateInterpolator()));

        //fadeout speed
        fadeOut.setDuration(1000);
        fadeOut.setFillAfter(true);
        fadeOut.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                //set ratio of heads to tails to 50:50
                ct_coin.setImageResource(RANDOM.nextFloat() > 0.5f ? R.drawable.ct_tails : R.drawable.ct_heads);

                //fadein animation
                Animation fadeIn = new AlphaAnimation(0,1);
                fadeIn.setInterpolator(new DecelerateInterpolator());

                //fadein speed
                fadeIn.setDuration(500);
                fadeIn.setFillAfter(true);

                ct_coin.startAnimation(fadeIn);
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        ct_coin.startAnimation(fadeOut);
    }
}
