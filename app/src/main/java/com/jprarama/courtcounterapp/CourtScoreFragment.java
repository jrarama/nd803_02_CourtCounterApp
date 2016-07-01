package com.jprarama.courtcounterapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by joshua on 1/7/16.
 */
public class CourtScoreFragment extends Fragment {

    private TextView tvTeamName;
    private TextView tvScore;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.court_score_item, container, false);
        tvTeamName = (TextView) rootView.findViewById(R.id.teamName);
        tvScore = (TextView) rootView.findViewById(R.id.score);

        Button btn1Point = (Button) rootView.findViewById(R.id.btn1point);
        Button btn2Points = (Button) rootView.findViewById(R.id.btn2points);
        Button btn3Points = (Button) rootView.findViewById(R.id.btn3points);

        btn1Point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increaseScore(1);
            }
        });

        btn2Points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increaseScore(2);
            }
        });

        btn3Points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increaseScore(3);
            }
        });

        return rootView;
    }

    private void increaseScore(int points) {
        int score = Integer.parseInt(tvScore.getText().toString().trim()) + points;
        String newScore = String.format("%02d", score);
        tvScore.setText(newScore);
    }

    public TextView getTvTeamName() {
        return tvTeamName;
    }

    public void resetScore() {
        tvScore.setText(getString(R.string.score));
    }
}
