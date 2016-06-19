package com.jessicauelmen.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Count of correct answers
    int correctCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the "Grade My Quiz" button is clicked.
     * It calculates the total number of correct answers from the user's selections.
     */
    public void gradeQuiz(View view) {
        // Check if the first question is correct
        RadioButton correctAnswer1 = (RadioButton) findViewById(R.id.q1_option2);
        if (correctAnswer1.isChecked()) {
            correctCount++;
        }

        // Check if the second question is correct
        RadioButton correctAnswer2 = (RadioButton) findViewById(R.id.q2_option1);
        if (correctAnswer2.isChecked()) {
            correctCount++;
        }

        // Check if the third question is correct
        CheckBox correctAnswer3_1 = (CheckBox) findViewById(R.id.q3_option1);
        CheckBox correctAnswer3_2 = (CheckBox) findViewById(R.id.q3_option3);
        CheckBox correctAnswer3_3 = (CheckBox) findViewById(R.id.q3_option5);
        if (correctAnswer3_1.isChecked() && correctAnswer3_2.isChecked() && correctAnswer3_3.isChecked()) {
            correctCount++;
        }

        // Check if the fourth question is correct
        RadioButton correctAnswer4 = (RadioButton) findViewById(R.id.q4_option3);
        if (correctAnswer4.isChecked()) {
            correctCount++;
        }

        // Check if fifth question is correct
        RadioButton correctAnswer5 = (RadioButton) findViewById(R.id.q5_option4);
        if (correctAnswer5.isChecked()) {
            correctCount++;
        }

        // Check if sixth question has text
        EditText correctAnswer6 = (EditText) findViewById(R.id.q6_answer);
        String sCorrectAnswer6 = correctAnswer6.getText().toString();
        if (!sCorrectAnswer6.matches("")) {
            correctCount++;
        }

        // Questions all graded; display number of correct answers
        displayCorrect();
    }

    public void displayCorrect() {
        // Setup toast messages
        Context context = getApplicationContext();
        CharSequence morePracticeText = String.format("Study harder! Only %2d / 6 correct.", correctCount);
        CharSequence congratsText = String.format("Congratulations! All Questions Correct!");
        int duration = Toast.LENGTH_SHORT;

        if (correctCount == 6) {
            Toast toast = Toast.makeText(context, congratsText, duration);
            toast.show();
        } else {
            Toast toast = Toast.makeText(context, morePracticeText, duration);
            toast.show();
        }

        // Reset count so user can try again.
        correctCount = 0;
    }

}
