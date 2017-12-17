package com.example.engineering.multiscreen_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     int quationNumber=1;//quation number tracker initialised


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /*
    calls the apropriate function that handle different quetions to be displayed
    it then updates the quation number by increasing it by one for feature calls
     */
    public void nextQuestion(View view)
    {
        if (quationNumber==1){
            question1();
            quationNumber=1;

    }
        else if (quationNumber==2){
            question2();
            quationNumber=2;

        }
        else if (quationNumber==3){
            question3();
            quationNumber=3;
        }
        else {
            CharSequence text="Sorry you cant move to the next question before providing the correct" +
                    "answer";
            Toast.makeText(this,text,Toast.LENGTH_LONG).show();
        }

    }
    /*
    handles the back button
    check the current question number then displaying the right question
    it first substract one from the current question
     */
    public void backQuestion(View view)
    {
        if (quationNumber==1){
            question3();//displaying the last question
            quationNumber=3;

        }
        else if (quationNumber==2){
            question1();
            quationNumber=1;

        }
        else if (quationNumber==3){
            question2();
            quationNumber=2;
        }
        /* this was to display a toast message when we reach the end of the questions but have
        decided to have an infinit loop of the questions
        else {
            CharSequence text="This is the end of the questions";
            Toast.makeText(this,text,Toast.LENGTH_LONG).show();
        }*/

    }

    /*
    handle submit quation button
    checks the question number, then checks for the right answer
     */
    public void submitQuation(View view){
        EditText answer= findViewById(R.id.answer);
        String text=answer.getText().toString();
        if (quationNumber==1){
            if (text.equalsIgnoreCase("c")){
                display("congratulation",R.id.answeDisplay);
                quationNumber=2;

                }
                else {
                display("please try again",R.id.answeDisplay);
                quationNumber=30;
            }
            }
            else if (quationNumber==2){
            if (text.equalsIgnoreCase("a")){
                display("congratulation",R.id.answeDisplay);
                quationNumber=3;
            }
            else {
                display("please try again",R.id.answeDisplay);
                quationNumber=30;
            }
        }
        else if (quationNumber==3){
            if (text.equalsIgnoreCase("d")){
                display("congratulation",R.id.answeDisplay);
                quationNumber=1;
            }
            else {
                display("please try again",R.id.answeDisplay);
                quationNumber=30;
            }

        }
        EditText default_textView=findViewById(R.id.answer);
        default_textView.setHint("Please enter your answer here");

        }




    public void question1(){//the answe is rotation of earth(c)
        display("Q1. Foucault experiment is proof of which one of the following?",R.id.quation_text);
        display("A.) Revolution of Earth",R.id.choiseA);
        display("b.) Rotation of Moon",R.id.choiseB);
        display("c.) Rotation of Earth",R.id.choiseC);
        display("d.) Revolution of Moon",R.id.choiseD);

    }

    /*
    *function to handle quation two and its answers
    * */
    public void question2(){// answer is A
        display("Q2. Lack of atmosphere around the Moon is due to:",R.id.quation_text);
        display("a.) low escape velocity of air molecule and low gravitational attractio",R.id.choiseA);
        display("b.) high escape velocity of air molecule and low gravitational attraction",R.id.choiseB);
        display("c.) low gravitational attraction only",R.id.choiseC);
        display("d.) high escape velocity of air molecule",R.id.choiseD);

    }
    /*
    function to display the question 3 and its answers

     */
    public void question3(){// answer is D
        display("Q3. NASA’s deep impact Space Mission was employed to take detailed pictures of which comet nucleus?"
                ,R.id.quation_text);
        display("a.) Halley’s comet",R.id.choiseA);
        display("b.) Hale-Bopp",R.id.choiseB);
        display("c.) Hyakutake",R.id.choiseC);
        display("d.) Temple 1",R.id.choiseD);

    }

    /*
    *function for displaying text on the quastion text
    * takes in the message and displays the quation
     */
    public void display(String message, int ID){
        TextView textQuestion=findViewById(ID);
        textQuestion.setText(message);

    }


}
