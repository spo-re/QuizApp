package com.example.android.quizapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Score variables
    int noOfCorrectAnswers = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Calculates the number of correct answers to the given questions answered by the user
     * @param answer1 is whether the correct answer for question 1 was checked
     * @param answer2 is whether the correct answer for question 2 was checked
     * @param answer3 is whether the correct answer for question 3 was checked
     * @param answer4 is whether the correct answer for question 4 was checked
     * @param answer7 is whether the correct answer for question 7 was typed in by the user
     * @param answer8 is whether the correct answer for question 8 was typed in by the user
     * @param answer10 is whether the correct answer for question 10 was typed in by the user
     * @param answer5 is whether one or all the correct answers for question 5 were checked
     * @param answer6 is whether one or all the correct answers for question 6 were checked
     * @param answer9 is whether one or all the correct answers for question 9 were checked
     * @return the number of correct answers i.e the score
     */
    public int calculateScore(boolean answer1, boolean answer2, boolean answer3, boolean answer4,
                              String answer7, String answer8, String answer10,
                              boolean answer5, boolean answer6, boolean answer9) {

        if (answer1) {
            noOfCorrectAnswers += 1;
        }
        if (answer2) {
            noOfCorrectAnswers += 1;
        }
        if (answer3) {
            noOfCorrectAnswers += 1;
        }
        if (answer4) {
            noOfCorrectAnswers += 1;
        }
        if (answer7.trim().equalsIgnoreCase(getString(R.string.singapore))) {
            noOfCorrectAnswers += 1;
        }
        if (answer8.trim().equalsIgnoreCase(getString(R.string.france))) {
            noOfCorrectAnswers += 1;
        }
        if (answer10.trim().equalsIgnoreCase(getString(R.string.igtv))) {
            noOfCorrectAnswers += 1;
        }
        if (answer5) {
            noOfCorrectAnswers += 1;
        }
        if (answer6) {
            noOfCorrectAnswers += 1;
        }
        if (answer9) {
            noOfCorrectAnswers += 1;
        }
        return noOfCorrectAnswers;
    }

    private void resetVariablesAndQuestions(View view) {

        // Gets the id for all RadioGroups and clears all selection whether right or wrong
        RadioGroup radioGroup1 = findViewById(R.id.option_group_1);
        RadioGroup radioGroup2 = findViewById(R.id.option_group_2);
        RadioGroup radioGroup3 = findViewById(R.id.option_group_3);
        RadioGroup radioGroup4 = findViewById(R.id.option_group_4);
        radioGroup1.clearCheck();
        radioGroup2.clearCheck();
        radioGroup3.clearCheck();
        radioGroup4.clearCheck();

        // Gets the id for all EditText and clears the values
        EditText answerQ7 = findViewById(R.id.question_7_ans);
        EditText answerQ8 = findViewById(R.id.question_8_ans);
        EditText answerQ10 = findViewById(R.id.question_10_ans);
        answerQ7.getText().clear();
        answerQ8.getText().clear();
        answerQ10.getText().clear();

        // Gets the id for all CheckBoxes wrong or correct and clears their selection
        CheckBox answer1Q5 = findViewById(R.id.question_5_opt_4);
        CheckBox answer2Q5 = findViewById(R.id.question_5_opt_6);
        CheckBox answer1Q6 = findViewById(R.id.question_6_opt_1);
        CheckBox answer2Q6 = findViewById(R.id.question_6_opt_2);
        CheckBox answer1Q9 = findViewById(R.id.question_9_opt_2);
        CheckBox answer2Q9 = findViewById(R.id.question_9_opt_3);
        CheckBox answer3Q9 = findViewById(R.id.question_9_opt_5);
        CheckBox wrong1Q5 = findViewById(R.id.question_5_opt_1);
        CheckBox wrong2Q5 = findViewById(R.id.question_5_opt_2);
        CheckBox wrong3Q5 = findViewById(R.id.question_5_opt_3);
        CheckBox wrong4Q5 = findViewById(R.id.question_5_opt_5);
        CheckBox wrongQ6 = findViewById(R.id.question_6_opt_3);
        CheckBox wrong1Q9 = findViewById(R.id.question_9_opt_1);
        CheckBox wrong2Q9 = findViewById(R.id.question_9_opt_4);
        CheckBox wrong3Q9 = findViewById(R.id.question_9_opt_6);
        answer1Q5.setChecked(false);
        answer2Q5.setChecked(false);
        answer1Q6.setChecked(false);
        answer2Q6.setChecked(false);
        answer1Q9.setChecked(false);
        answer2Q9.setChecked(false);
        answer3Q9.setChecked(false);
        wrong1Q5.setChecked(false);
        wrong2Q5.setChecked(false);
        wrong3Q5.setChecked(false);
        wrong4Q5.setChecked(false);
        wrongQ6.setChecked(false);
        wrong1Q9.setChecked(false);
        wrong2Q9.setChecked(false);
        wrong3Q9.setChecked(false);

        // resets the score variables
        noOfCorrectAnswers = 0;
        score = 0;

    }

    /**
     * This method is called when the submit button is clicked
     */
    @SuppressLint("StringFormatInvalid")
    public void submitQuestions(View view) {

        // Finds the name of the user
        EditText nameField = findViewById(R.id.user_name);
        String name = nameField.getText().toString();

        // Gets the correct answers to the questions with RadioButtons,
        // checks if the user checked them and stores the values into boolean variables
        RadioButton answerQ1 = findViewById(R.id.question_1_opt_2);
        boolean answerIsCorrect1 = answerQ1.isChecked();

        RadioButton answerQ2 = findViewById(R.id.question_2_opt_2);
        boolean answerIsCorrect2 = answerQ2.isChecked();

        RadioButton answerQ3 = findViewById(R.id.question_3_opt_3);
        boolean answerIsCorrect3 = answerQ3.isChecked();

        RadioButton answerQ4 = findViewById(R.id.question_4_opt_3);
        boolean answerIsCorrect4 = answerQ4.isChecked();

        // Gets the user's answers to the questions with an EditText field
        // and stores them in string variables
        EditText answerQ7 = findViewById(R.id.question_7_ans);
        String answerIsCorrect7 = answerQ7.getText().toString();

        EditText answerQ8 = findViewById(R.id.question_8_ans);
        String answerIsCorrect8 = answerQ8.getText().toString();

        EditText answerQ10 = findViewById(R.id.question_10_ans);
        String answerIsCorrect10 = answerQ10.getText().toString();

        // Gets the correct answers to the questions with CheckBoxes,
        // checks if the user checked them and stores the values into boolean variables
        CheckBox answer1Q5 = findViewById(R.id.question_5_opt_4);
        CheckBox answer2Q5 = findViewById(R.id.question_5_opt_6);
        CheckBox wrong1Q5 = findViewById(R.id.question_5_opt_1);
        CheckBox wrong2Q5 = findViewById(R.id.question_5_opt_2);
        CheckBox wrong3Q5 = findViewById(R.id.question_5_opt_3);
        CheckBox wrong4Q5 = findViewById(R.id.question_5_opt_5);
        boolean answerIsCorrect5 = (answer1Q5.isChecked() || answer2Q5.isChecked())
                && (!wrong1Q5.isChecked() && !wrong2Q5.isChecked()
                && !wrong3Q5.isChecked() && !wrong4Q5.isChecked());

        CheckBox answer1Q6 = findViewById(R.id.question_6_opt_1);
        CheckBox answer2Q6 = findViewById(R.id.question_6_opt_2);
        CheckBox wrongQ6 = findViewById(R.id.question_6_opt_3);
        boolean answerIsCorrect6 = (answer1Q6.isChecked() || answer2Q6.isChecked())
                && (!wrongQ6.isChecked());

        CheckBox answer1Q9 = findViewById(R.id.question_9_opt_2);
        CheckBox answer2Q9 = findViewById(R.id.question_9_opt_3);
        CheckBox answer3Q9 = findViewById(R.id.question_9_opt_5);
        CheckBox wrong1Q9 = findViewById(R.id.question_9_opt_1);
        CheckBox wrong2Q9 = findViewById(R.id.question_9_opt_4);
        CheckBox wrong3Q9 = findViewById(R.id.question_9_opt_6);
        boolean answerIsCorrect9 = (answer1Q9.isChecked() || answer2Q9.isChecked()
                || answer3Q9.isChecked()) && (!wrong1Q9.isChecked() && !wrong2Q9.isChecked()
                && !wrong3Q9.isChecked());

        // Calculates the score of the user
        score = calculateScore(answerIsCorrect1, answerIsCorrect2, answerIsCorrect3,
                answerIsCorrect4, answerIsCorrect7, answerIsCorrect8, answerIsCorrect10,
                answerIsCorrect5, answerIsCorrect6, answerIsCorrect9);

        // Message informing the user of the score
        Toast scoreMessage;
        if(score > 5) {
            scoreMessage = Toast.makeText(this,
                    getString(R.string.score_message, name, score), Toast.LENGTH_LONG);
            scoreMessage.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
            scoreMessage.show();
        } else if (score == 5) {
            scoreMessage = Toast.makeText(this,
                    getString(R.string.score_message2, name, score), Toast.LENGTH_LONG);
            scoreMessage.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
            scoreMessage.show();
        } else {
            scoreMessage = Toast.makeText(this,
                    getString(R.string.score_message3, name, score), Toast.LENGTH_LONG);
            scoreMessage.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
            scoreMessage.show();
        }

        resetVariablesAndQuestions(findViewById(R.id.quiz_questions));
    }

}
