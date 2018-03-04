package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int pointsForTeamA;
    int pointsForTeamB;
    int setsForTeamA;
    int setsForTeamB;
    int pointsForWin = 25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        pointsForTeamA = pointsForTeamA + 1;
        displayForTeamA(pointsForTeamA);
        if (pointsForTeamA >= pointsForWin && (pointsForTeamA - pointsForTeamB) >= 2) {
            setsForTeamA = setsForTeamA + 1;
            displaySetsForTeamA(setsForTeamA);
            pointsReset();
        }
    }
    
    /**
     * Increase the score for Team B by 1 points.
     */
    public void addOneForTeamB(View v) {
        pointsForTeamB = pointsForTeamB + 1;
        displayForTeamB(pointsForTeamB);
        if (pointsForTeamB >= pointsForWin && (pointsForTeamB-pointsForTeamA) >= 2) {
            setsForTeamB = setsForTeamB +1;
            displaySetsForTeamB(setsForTeamB);
            pointsReset();
        }
    }

    /**
     * Reset the score for both teams back to 0.
     */
    public void pointsReset () {
        pointsForTeamA = 0;
        displayForTeamA(pointsForTeamA);
        pointsForTeamB = 0;
        displayForTeamB(pointsForTeamB);
    }

    /**
     * Reset sets for Team A and Team B.
     */

    public void setsReset () {
        setsForTeamA = 0;
        displaySetsForTeamA(setsForTeamA);
        setsForTeamB = 0;
        displaySetsForTeamB(setsForTeamB);
    }

    /**
     * Reset points and sets for Team A and Team B.
     */
    public void reset (View v) {
        pointsReset();
        setsReset();

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays sets for Team A.
     */
    public void displaySetsForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.sets_a_team);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays sets for Team B.
     */
    public void displaySetsForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.sets_b_team);
        scoreView.setText(String.valueOf(score));
    }
}