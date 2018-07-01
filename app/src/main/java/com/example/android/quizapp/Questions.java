

package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Questions extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);
        //Hides the keyboard when the app starts
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //Disables the answer button when the app starts
        Button answerButton = findViewById(R.id.answerButton);
        answerButton.setEnabled(false);
    }

    /**
     * This method is called when the submit button is clicked
     * calculates and displays the score enables and disables buttons
     */

    public void submitButton(View view) {
        //question1
        RadioButton choseTrueRadioButton = findViewById(R.id.q1t);
        boolean choseTrue = choseTrueRadioButton.isChecked();
        //question2
        RadioButton choseNoahRadioButton = findViewById(R.id.q2c);
        boolean choseNoah = choseNoahRadioButton.isChecked();
        //question3
        EditText prophetName = findViewById(R.id.q3text);
        String name = prophetName.getText().toString();
        String q3correct = "Elijah";
        //question4
        CheckBox choseMalachiCheckbox = findViewById(R.id.q4a);
        boolean choseMalachi = choseMalachiCheckbox.isChecked();
        CheckBox choseZephaniahCheckbox = findViewById(R.id.q4b);
        boolean choseZephaniah = choseZephaniahCheckbox.isChecked();
        CheckBox choseHabakkukCheckbox = findViewById(R.id.q4d);
        boolean choseHabakkuk = choseHabakkukCheckbox.isChecked();
        //question5
        RadioButton choseFalseRadioButton = findViewById(R.id.q5f);
        boolean choseFalse = choseFalseRadioButton.isChecked();
        //question6
        EditText fatherName = findViewById(R.id.q6text);
        String name2 = fatherName.getText().toString();
        String q6correct = "Terah";

        //performs calculateScore method and creates message for score result
        int score = calculateScore(choseTrue, choseNoah, name, q3correct,
                choseMalachi, choseZephaniah, choseHabakkuk, choseFalse, name2, q6correct);
        String scoreMessage = getString(R.string.score_message) + "\b" + score;
        scoreMessage = scoreMessage + "\b" + getString(R.string.scoreMessage);

        // Text displayed to show scores
        TextView afterSubmitTextView = findViewById(R.id.scoreSet);
        afterSubmitTextView.setText(scoreMessage);

        //Disables the submit button
        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setEnabled(false);

        //Enables the answer button
        Button answerButton = findViewById(R.id.answerButton);
        answerButton.setEnabled(true);
    }

    /**
     * This methods calculates score based on the answer that has been selected
     *
     * @return returns score integer
     */
    private int calculateScore(boolean choseTrue, boolean choseNoah,
                               String name, String q3correct,
                               boolean choseMalachi, boolean choseZephaniah,
                               boolean choseHabakkuk,boolean choseFalse,
                               String name2, String q6correct) {
        if (choseTrue) {
            score = score + 1;
        }
        if (choseNoah) {
            score = score + 1;
        }

        if (name.equalsIgnoreCase(q3correct)) {
            score = score + 1;
        }

        if (choseMalachi && choseZephaniah && choseHabakkuk) {
            score = score + 1;
        }
        if (choseFalse){
            score = score + 1;
        }
        if (name2.equalsIgnoreCase(q6correct)) {
            score = score + 1;
        }
        return score;
    }

    /**
     * This method resets the entire quiz to be as it was when the app moved from the home screen
     */
    public void reset(View view) {
        Intent nextScreen = new Intent(getApplicationContext(), Questions.class);
        startActivity(nextScreen);
    }

    /**
     * This method opens the answer page
     */
    public void answers(View view){
        Intent nextScreen = new Intent(getApplicationContext(), Answers.class);
        startActivity(nextScreen);
    }
}
