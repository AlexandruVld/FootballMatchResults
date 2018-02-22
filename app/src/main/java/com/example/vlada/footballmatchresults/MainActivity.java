package com.example.vlada.footballmatchresults;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Saves the scores of both teams in case of changing activity
    static final String STATE_GOALS_A = "goalsTeamA";
    static final String STATE_GOALS_B = "goalsTeamB";
    static final String STATE_FOULS_A = "foulsTeamA";
    static final String STATE_FOULS_B = "foulsTeamB";
    static final String STATE_CORNERS_A = "cornersTeamA";
    static final String STATE_CORNERS_B = "cornersTeamB";
    //Keeps the goals, fouls and corners for Team A*/
    int goalsTeamA = 0;
    int foulsTeamA = 0;
    int cornersTeamA = 0;
    //Keeps the goals, fouls and corners for Team B*/
    int goalsTeamB = 0;
    int foulsTeamB = 0;
    int cornersTeamB = 0;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(STATE_GOALS_A, goalsTeamA);
        savedInstanceState.putInt(STATE_GOALS_B, goalsTeamB);
        savedInstanceState.putInt(STATE_FOULS_A, foulsTeamA);
        savedInstanceState.putInt(STATE_FOULS_B, foulsTeamB);
        savedInstanceState.putInt(STATE_CORNERS_A, cornersTeamA);
        savedInstanceState.putInt(STATE_CORNERS_B, cornersTeamB);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore state members from saved instance
        goalsTeamA = savedInstanceState.getInt(STATE_GOALS_A);
        goalsTeamB = savedInstanceState.getInt(STATE_GOALS_B);
        foulsTeamA = savedInstanceState.getInt(STATE_FOULS_A);
        foulsTeamB = savedInstanceState.getInt(STATE_FOULS_B);
        cornersTeamA = savedInstanceState.getInt(STATE_CORNERS_A);
        cornersTeamB = savedInstanceState.getInt(STATE_CORNERS_B);
        displayGoalsForTeamA(goalsTeamA);
        displayGoalsForTeamB(goalsTeamB);
        displayFoulsForTeamA(foulsTeamA);
        displayFoulsForTeamB(foulsTeamB);
        displayCornersForTeamA(cornersTeamA);
        displayCornersForTeamB(cornersTeamB);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This method is called when the Goal button for Team A is clicked.
    public void addOneGoalTeamA(View V) {
        goalsTeamA = goalsTeamA + 1;
        displayGoalsForTeamA(goalsTeamA);
    }


    //This method is called when the Fouls button for Team A is clicked.
    public void addOneFoulTeamA(View V) {
        foulsTeamA = foulsTeamA + 1;
        displayFoulsForTeamA(foulsTeamA);
    }

    //This method is called when the Corners button for Team A is clicked.
    public void addOneCornerTeamA(View V) {
        cornersTeamA = cornersTeamA + 1;
        displayCornersForTeamA(cornersTeamA);
    }

    //This method is called when the Goals button for Team B is clicked.
    public void addOneGoalTeamB(View V) {
        goalsTeamB = goalsTeamB + 1;
        displayGoalsForTeamB(goalsTeamB);
    }

    //This method is called when the Fouls button for Team B is clicked.
    public void addOneFoulTeamB(View V) {
        foulsTeamB = foulsTeamB + 1;
        displayFoulsForTeamB(foulsTeamB) ;
    }

    //This method is called when the Corners button for Team B is clicked.
    public void addOneCornerTeamB(View V) {
        cornersTeamB = cornersTeamB + 1;
        displayCornersForTeamB(cornersTeamB);
    }

    //Displays the goals for Team A.
    public void displayGoalsForTeamA(int goalsTeamA) {
        TextView goalsView = findViewById(R.id.team_a_goals);
        goalsView.setText(String.valueOf(goalsTeamA));
    }

    //Displays the fouls for Team A.
    public void displayFoulsForTeamA(int foulsTeamA) {
        TextView foulsView = findViewById(R.id.team_a_fouls);
        foulsView.setText(String.valueOf(foulsTeamA));
    }

    //Displays the corners for Team A.
    public void displayCornersForTeamA(int cornersTeamA) {
        TextView cornersView = findViewById(R.id.team_a_corners);
        cornersView.setText(String.valueOf(cornersTeamA));
    }

    //Displays the goals for Team B.
    public void displayGoalsForTeamB(int goalsTeamB) {
        TextView goalsView = findViewById(R.id.team_b_goals);
        goalsView.setText(String.valueOf(goalsTeamB));
    }

    //Displays the fouls for Team B.
    public void displayFoulsForTeamB(int foulsTeamB) {
        TextView foulsView = findViewById(R.id.team_b_fouls);
        foulsView.setText(String.valueOf(foulsTeamB));
    }

    //Displays the corners for Team B.
    public void displayCornersForTeamB(int cornersTeamB) {
        TextView cornersView = findViewById(R.id.team_b_corners);
        cornersView.setText(String.valueOf(cornersTeamB));
    }

    //Displays the result for both teams.
    public void showResults (View v){
        TextView resultA = findViewById(R.id.resultTeamA);
        TextView resultB = findViewById(R.id.resultTeamB);
        if (goalsTeamA > goalsTeamB){
            resultA.setText(R.string.win);
            resultB.setText(R.string.lose);
        } else {
            resultA.setText(R.string.lose);
            resultB.setText(R.string.win);
        }
        if ((goalsTeamA != 0) && (goalsTeamA == goalsTeamB)){
            resultA.setText(R.string.draw);
            resultB.setText(R.string.draw);
        }

    }

    //Resets both team A and B score and results to zero and display reset score.
    public void resetScore(View view) {
        TextView resultA = findViewById(R.id.resultTeamA);
        TextView resultB = findViewById(R.id.resultTeamB);
        resultA.setText(null);
        resultB.setText(null);
        goalsTeamA = 0;
        foulsTeamA = 0;
        cornersTeamA = 0;
        goalsTeamB = 0;
        foulsTeamB = 0;
        cornersTeamB = 0;
        displayGoalsForTeamA(goalsTeamA);
        displayFoulsForTeamA(foulsTeamA);
        displayCornersForTeamA(cornersTeamA);
        displayGoalsForTeamB(goalsTeamB);
        displayFoulsForTeamB(foulsTeamB);
        displayCornersForTeamB(cornersTeamB);
    }
}
