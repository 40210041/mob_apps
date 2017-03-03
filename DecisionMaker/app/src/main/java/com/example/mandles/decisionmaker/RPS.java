package com.example.mandles.decisionmaker;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class RPS extends AppCompatActivity {

    ImageButton rps_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);

        //create var for rps_home
        rps_home = (ImageButton) findViewById(R.id.rps_home);

        //set the click function
        rps_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //from rps, bring user back to m.menu
                Intent activity_rps = new Intent(RPS.this, MainMenu.class);
                startActivity(activity_rps);
            }
        });

        //do home butoon thrn commit = "did home buttons"
    }
}
