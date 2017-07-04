package com.example.codetride.basketballapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Global declarations
    private int home;
    private int away;
    private TextView lblHscore, lblAscore;
    private Button btnHome, btnAway, btnResult, btnLive;
    double counter = 0;  //used for assigning Math.random
    boolean buttonResult = true; /*boolean to check if it's true that
                                  *if a button is clicked*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Casting all the views
        lblAscore= (TextView) findViewById(R.id.lblAway);
        lblHscore= (TextView) findViewById(R.id.lblHome);
        btnAway= (Button) findViewById(R.id.btnAway);
        btnHome= (Button) findViewById(R.id.btnHome);
        btnResult = (Button) findViewById(R.id.btnResults);
        btnLive = (Button) findViewById(R.id.btnLive);

        // This is what will happen if the user click the Home button.
        btnHome.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //Incrementing by 1 if Home button is clicked once
               home=home+1;
               home(home);      //the function is found in line 103
           }
       });

        // This is what will happen if the user click the Away button.
        btnAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Incrementing by 1 if Away button is clicked once
                away=away+1;
                away(away);     //the function is found in line 97
            }
        });

        // This is what will happen if the user click the Result button.
        btnResult.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                *if button is clicked show results by Toasting it and reset the score
                * so that a user start afresh*/
                if(buttonResult){
                    /*Store the results in this variable called 'name'
                    * both functions are found in line 116 and 135 respectively*/
                    String name = "Results: Sundowns FC " + Home(home) +" - "+ Away(away) + " Manchester United";
                    //and display the variable using Toast.makeText
                    Toast.makeText(MainActivity.this,name,Toast.LENGTH_SHORT).show();
                    //reset the scoreline to zero everytime the button is clicked.
                    home = 0;
                    away = 0;
                    //and store zero in this two functions
                    home(home);     //the function is found in line 103
                    away(away);     //the function is found in line 97

                }
            }
        });

        // This is what will happen if the user click the Live button.
        btnLive.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if button is clicked then Toast it
                if(buttonResult) {
                    //fetch the string value of the Global variable called home
                    lblHscore.setText(String.valueOf(home));
                    //fetch the string value of the Global variable called away
                    lblAscore.setText(String.valueOf(away));
                    //Store the results in this variable called 'name'
                    String name = "Live Score: Sundowns FC " + home(home) + " - " + away(away) + " Manchester United";
                    //and display the variable using Toast.makeText
                    Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();

                }
            }
        });
                                    //the end of onCreate body
    }

    /*function for setting text for away
    * the function is deployed in line 51 and 72
    * */
    public int away(int away){
        lblAscore.setText(String.valueOf(away));
        return away;
    }

    /*function for setting text for home
    * the function is deployed in line 41 and 71
    * */
    public int home(int home){
        lblHscore.setText(String.valueOf(home));
        return home;
    }

    /*function for selecting a random for Home score
     * the function is deployed in line 64
     * */
    public int Home(int home){
        //initiating a random number
        counter = Math.random();
        /*Multiplying it by maximum number which is 5 in this case
        * in other words the maximum score can not exceed 5 goals per team.*/
        counter *= 5;
        //increment the counter(score)
        counter++;
        //Casting counter(double) into  away(integer) to prevent decimal points.
        home = (int) counter;
        //storing the new variable(home) into TextView called HomeScore.
        lblHscore.setText(String.valueOf(home));
        //return answer
        return home;
    }

    /*function for selecting a random for Away score
     * the function is deployed in line 64
     * */
    public int Away(int away){
        //initiating a random number
        counter = Math.random();
        /*Multiplying it by maximum number which is 5 in this case
        * in other words the maximum score can not exceed 5 goals per team.*/
        counter *= 5;
        //increment the counter(score)
        counter++;
        //Casting counter(double) into  away(integer) to prevent decimal points.
        away = (int) counter;
        //storing the new variable(home) into TextView called AwayScore.
        lblAscore.setText(String.valueOf(away));
        //return answer
        return away;
    }
                                       //the end of MainActivity body
}
