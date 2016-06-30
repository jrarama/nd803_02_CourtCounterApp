package com.jprarama.courtcounterapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        final CourtScoreFragment teamA = (CourtScoreFragment) fm.findFragmentById(R.id.fragmentTeamA);
        final CourtScoreFragment teamB = (CourtScoreFragment) fm.findFragmentById(R.id.fragmentTeamB);

        teamA.getTvTeamName().setText("Team A");
        teamB.getTvTeamName().setText("Team B");

        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamA.resetScore();
                teamB.resetScore();
            }
        });
    }

}
