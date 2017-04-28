package com.example.android.geoquiz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.id;
import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    private int mAnimationDuration = 0;
    int correctAnswers = 0;
    int wrongAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // keyboard doesn't show when app starts
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        // change font of title "Geography quiz"
        TextView mainTitle = (TextView) findViewById(R.id.textview_title);
        Typeface sketchFont = Typeface.createFromAsset(getAssets(), "fonts/Sketch.otf");
        mainTitle.setTypeface(sketchFont);
    }

    /*
     *  ---- START QUIZ BUTTON IS PRESSED ----
     */

    public void startQuiz (View view) {
        // make edit text field a required field
        EditText userName = (EditText) findViewById(R.id.enter_your_name);
        String sUsername = userName.getText().toString();
        if (sUsername.matches("")) {
            Toast toast = Toast.makeText(this, getResources().getString(R.string.name_required), Toast.LENGTH_SHORT);
            toast.show();
            toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, -190);
            return;
        }
        else {
            final View startScreen = findViewById(R.id.linearlayout_start_screen);
            View showQuestionOne = findViewById(R.id.linearlayout_question1);
            showQuestionOne.setVisibility(View.GONE);
            mAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);

            // set the appearing view to 0% opacity but visible, so that it is visible (but fully transparent) during the animation
            showQuestionOne.setAlpha(0f);
            showQuestionOne.setVisibility(View.VISIBLE);

            // animate the appearing view to 100% opacity, and clear any animation listener set on the view
            showQuestionOne.animate().alpha(1f).setDuration(mAnimationDuration).setListener(null);

            // animate the disappearing view to 0% opacity and after the animation ends, set its visibility to GONE
            startScreen.animate().alpha(0f).setDuration(mAnimationDuration).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    startScreen.setVisibility(View.GONE);
                }
            });

            // hide keyboard
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(startScreen.getWindowToken(), 0);
        }
    }

    /*
     *  ---- CREDITS BUTTON IS PRESSED ----
     */

    public void credits (View view) {
        final View startScreen = findViewById(R.id.linearlayout_start_screen);
        View showCredits = findViewById(R.id.linearlayout_credits);
        showCredits.setVisibility(View.GONE);
        mAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);

        // set the appearing view to 0% opacity but visible, so that it is visible (but fully transparent) during the animation
        showCredits.setAlpha(0f);
        showCredits.setVisibility(View.VISIBLE);

        // animate the appearing view to 100% opacity, and clear any animation listener set on the view
        showCredits.animate().alpha(1f).setDuration(mAnimationDuration).setListener(null);

        // animate the disappearing view to 0% opacity and after the animation ends, set its visibility to GONE
        startScreen.animate().alpha(0f).setDuration(mAnimationDuration).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                startScreen.setVisibility(View.GONE);
            }
        });

        // hide keyboard
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(startScreen.getWindowToken(), 0);
    }

    /*
     *  ---- IN CREDITS - BACK BUTTON IS PRESSED ----
     */

    public void startScreen (View view) {
        final View showCredits = findViewById(R.id.linearlayout_credits);
        View startScreen = findViewById(R.id.linearlayout_start_screen);
        startScreen.setVisibility(View.GONE);
        mAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);

        // set the appearing view to 0% opacity but visible, so that it is visible (but fully transparent) during the animation
        startScreen.setAlpha(0f);
        startScreen.setVisibility(View.VISIBLE);

        // animate the appearing view to 100% opacity, and clear any animation listener set on the view
        startScreen.animate().alpha(1f).setDuration(mAnimationDuration).setListener(null);

        // animate the disappearing view to 0% opacity and after the animation ends, set its visibility to GONE
        showCredits.animate().alpha(0f).setDuration(mAnimationDuration).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                showCredits.setVisibility(View.GONE);
            }
        });
    }

    /*
     *  ---- QUESTION 1 ANSWERS ----
     */

    public void questionOneAnswer1 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question1_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question1_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question1_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question1_answer4); answer4.setEnabled(false);
        answer1.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question1);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    public void questionOneAnswer2 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question1_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question1_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question1_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question1_answer4); answer4.setEnabled(false);
        answer2.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question1);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    // the correct one
    public void questionOneAnswer3 (View view) {
        correctAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question1_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question1_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question1_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question1_answer4); answer4.setEnabled(false);
        answer3.setBackgroundResource(R.drawable.button_correct_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.correct_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question1);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    public void questionOneAnswer4 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question1_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question1_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question1_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question1_answer4); answer4.setEnabled(false);
        answer4.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question1);
        nextQuestion.setVisibility(View.VISIBLE);
    }

    /*
     *  ---- QUESTION 2 ANSWERS ----
     */

    public void questionTwoAnswer1 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question2_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question2_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question2_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question2_answer4); answer4.setEnabled(false);
        answer1.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question2);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    public void questionTwoAnswer2 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question2_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question2_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question2_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question2_answer4); answer4.setEnabled(false);
        answer2.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question2);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    // the correct one
    public void questionTwoAnswer3 (View view) {
        correctAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question2_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question2_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question2_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question2_answer4); answer4.setEnabled(false);
        answer3.setBackgroundResource(R.drawable.button_correct_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.correct_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question2);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    public void questionTwoAnswer4 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question2_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question2_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question2_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question2_answer4); answer4.setEnabled(false);
        answer4.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question2);
        nextQuestion.setVisibility(View.VISIBLE);
    }

    /*
     *  ---- QUESTION 3 ANSWERS ----
     */
    public void questionThreeAnswer1 (View view) {
        // make edit text field a required field
        EditText q3answer = (EditText) findViewById(R.id.edittext_question3);
        String question3answer = q3answer.getText().toString();
        if (question3answer.equals(getResources().getString(R.string.africa_sentence)) || question3answer.equals(getResources().getString(R.string.africa_lowcase)) || question3answer.equals(getResources().getString(R.string.africa_caps))) {
            correctAnswers += 1;

            Toast toast = Toast.makeText(this, getResources().getString(R.string.correct_answer), Toast.LENGTH_SHORT);
            toast.show();
            toast.setGravity(Gravity.CENTER, 0, 400);
        }
        else {
            wrongAnswers += 1;

            Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
            toast.show();
            toast.setGravity(Gravity.CENTER, 0, 400);
        }

        Button q3button = (Button) findViewById(R.id.button_submit_q3);
        q3button.setVisibility(View.INVISIBLE); q3answer.setEnabled(false);

        // hide keyboard
        final View question3 = findViewById(R.id.linearlayout_question3);
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(question3.getWindowToken(), 0);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question3);
        nextQuestion.setVisibility(View.VISIBLE);
    }

    /*
     *  ---- QUESTION 4 ANSWERS ----
     */

    public void questionFourAnswer1 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question4_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question4_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question4_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question4_answer4); answer4.setEnabled(false);
        answer1.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question4);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    // the correct one
    public void questionFourAnswer2 (View view) {
        correctAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question4_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question4_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question4_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question4_answer4); answer4.setEnabled(false);
        answer2.setBackgroundResource(R.drawable.button_correct_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.correct_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question4);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    public void questionFourAnswer3 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question4_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question4_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question4_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question4_answer4); answer4.setEnabled(false);
        answer3.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question4);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    public void questionFourAnswer4 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question4_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question4_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question4_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question4_answer4); answer4.setEnabled(false);
        answer4.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question4);
        nextQuestion.setVisibility(View.VISIBLE);
    }

    /*
     *  ---- QUESTION 5 ANSWERS ----
     */

    public void questionFiveAnswer1 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question5_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question5_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question5_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question5_answer4); answer4.setEnabled(false);
        answer1.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question5);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    // the correct one
    public void questionFiveAnswer2 (View view) {
        correctAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question5_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question5_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question5_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question5_answer4); answer4.setEnabled(false);
        answer2.setBackgroundResource(R.drawable.button_correct_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.correct_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question5);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    public void questionFiveAnswer3 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question5_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question5_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question5_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question5_answer4); answer4.setEnabled(false);
        answer3.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question5);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    public void questionFiveAnswer4 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question5_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question5_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question5_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question5_answer4); answer4.setEnabled(false);
        answer4.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question5);
        nextQuestion.setVisibility(View.VISIBLE);
    }

    /*
     *  ---- QUESTION 6 ANSWERS ----
     */

    // the correct one
    public void questionSixAnswer1 (View view) {
        correctAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question6_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question6_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question6_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question6_answer4); answer4.setEnabled(false);
        answer1.setBackgroundResource(R.drawable.button_correct_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.correct_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question6);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    public void questionSixAnswer2 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question6_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question6_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question6_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question6_answer4); answer4.setEnabled(false);
        answer2.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question6);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    public void questionSixAnswer3 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question6_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question6_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question6_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question6_answer4); answer4.setEnabled(false);
        answer3.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question6);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    public void questionSixAnswer4 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question6_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question6_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question6_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question6_answer4); answer4.setEnabled(false);
        answer4.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question6);
        nextQuestion.setVisibility(View.VISIBLE);
    }

    /*
     *  ---- QUESTION 7 ANSWERS ----
     */

    public void questionSevenAnswer1 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question7_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question7_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question7_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question7_answer4); answer4.setEnabled(false);
        answer1.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question7);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    public void questionSevenAnswer2 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question7_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question7_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question7_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question7_answer4); answer4.setEnabled(false);
        answer2.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question7);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    public void questionSevenAnswer3 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question7_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question7_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question7_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question7_answer4); answer4.setEnabled(false);
        answer3.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question7);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    // the correct one
    public void questionSevenAnswer4 (View view) {
        correctAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question7_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question7_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question7_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question7_answer4); answer4.setEnabled(false);
        answer4.setBackgroundResource(R.drawable.button_correct_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.correct_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question7);
        nextQuestion.setVisibility(View.VISIBLE);
    }

    /*
     *  ---- QUESTION 8 ANSWERS ----
     */

    public void questionEightAnswer1 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question8_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question8_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question8_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question8_answer4); answer4.setEnabled(false);
        answer1.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        Button finalResults = (Button) findViewById(R.id.button_finalResults);
        finalResults.setVisibility(View.VISIBLE);

        // dialog - quiz is finished
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle(getResources().getString(R.string.congratulations_dialog_title));
        alertDialog.setMessage(getResources().getString(R.string.dialog_message));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getResources().getString(R.string.results_button),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finalResults(null);
                    }
                });
        alertDialog.show();
    }
    public void questionEightAnswer2 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question8_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question8_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question8_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question8_answer4); answer4.setEnabled(false);
        answer2.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        Button finalResults = (Button) findViewById(R.id.button_finalResults);
        finalResults.setVisibility(View.VISIBLE);

        // dialog - quiz is finished
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle(getResources().getString(R.string.congratulations_dialog_title));
        alertDialog.setMessage(getResources().getString(R.string.dialog_message));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getResources().getString(R.string.results_button),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finalResults(null);
                    }
                });
        alertDialog.show();
    }
    // the correct one
    public void questionEightAnswer3 (View view) {
        correctAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question8_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question8_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question8_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question8_answer4); answer4.setEnabled(false);
        answer3.setBackgroundResource(R.drawable.button_correct_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.correct_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        Button finalResults = (Button) findViewById(R.id.button_finalResults);
        finalResults.setVisibility(View.VISIBLE);

        // dialog - quiz is finished
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle(getResources().getString(R.string.congratulations_dialog_title));
        alertDialog.setMessage(getResources().getString(R.string.dialog_message));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getResources().getString(R.string.results_button),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finalResults(null);
                    }
                });
        alertDialog.show();
    }
    public void questionEightAnswer4 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        Button answer1 = (Button) findViewById(R.id.button_question8_answer1); answer1.setEnabled(false);
        Button answer2 = (Button) findViewById(R.id.button_question8_answer2); answer2.setEnabled(false);
        Button answer3 = (Button) findViewById(R.id.button_question8_answer3); answer3.setEnabled(false);
        Button answer4 = (Button) findViewById(R.id.button_question8_answer4); answer4.setEnabled(false);
        answer4.setBackgroundResource(R.drawable.button_wrong_clicked);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        Button finalResults = (Button) findViewById(R.id.button_finalResults);
        finalResults.setVisibility(View.VISIBLE);

        // dialog - quiz is finished
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle(getResources().getString(R.string.congratulations_dialog_title));
        alertDialog.setMessage(getResources().getString(R.string.dialog_message));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getResources().getString(R.string.results_button),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finalResults(null);
                    }
                });
        alertDialog.show();
    }

    /*
     *  ---- QUESTION 9 ANSWERS ----
     */

    public void questionNineAnswer1 (View view) {
        wrongAnswers += 1;

        // disable buttons so you can't change your answer
        RadioButton answer1 = (RadioButton) findViewById(R.id.yes_radio_button); answer1.setEnabled(false);
        RadioButton answer2 = (RadioButton) findViewById(R.id.no_radio_button); answer2.setEnabled(false);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question9);
        nextQuestion.setVisibility(View.VISIBLE);
    }
    // the correct one
    public void questionNineAnswer2 (View view) {
        correctAnswers += 1;

        // disable buttons so you can't change your answer
        RadioButton answer1 = (RadioButton) findViewById(R.id.yes_radio_button); answer1.setEnabled(false);
        RadioButton answer2 = (RadioButton) findViewById(R.id.no_radio_button); answer2.setEnabled(false);

        Toast toast = Toast.makeText(this, getResources().getString(R.string.correct_answer), Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(Gravity.CENTER, 0, 400);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question9);
        nextQuestion.setVisibility(View.VISIBLE);
    }

    /*
     *  ---- QUESTION 10 ANSWERS ----
     */
    public void questionTenAnswers (View view) {
        CheckBox q10a1 = (CheckBox) findViewById(R.id.checkbox_question10_answer1);
        CheckBox q10a2 = (CheckBox) findViewById(R.id.checkbox_question10_answer2);
        CheckBox q10a3 = (CheckBox) findViewById(R.id.checkbox_question10_answer3);
        CheckBox q10a4 = (CheckBox) findViewById(R.id.checkbox_question10_answer4);
        if (q10a1.isChecked() && !(q10a2.isChecked()) && q10a3.isChecked() && !(q10a4.isChecked())) {
            correctAnswers += 1;

            Toast toast = Toast.makeText(this, getResources().getString(R.string.correct_answer), Toast.LENGTH_SHORT);
            toast.show();
            toast.setGravity(Gravity.CENTER, 0, 400);
            }
        else {
            wrongAnswers += 1;

            Toast toast = Toast.makeText(this, getResources().getString(R.string.wrong_answer), Toast.LENGTH_SHORT);
            toast.show();
            toast.setGravity(Gravity.CENTER, 0, 400);
        }

        Button q3button = (Button) findViewById(R.id.button_submit_q10);
        q3button.setVisibility(View.INVISIBLE);
        q10a1.setEnabled(false); q10a2.setEnabled(false); q10a3.setEnabled(false); q10a4.setEnabled(false);

        ImageButton nextQuestion = (ImageButton) findViewById(R.id.imagebutton_next_question10);
        nextQuestion.setVisibility(View.VISIBLE);
    }

    /*
     *  ---- CHANGE OF QUESTIONS ----
     */

    // q1 -> q2
    public void questionTwo(View view){
        final View hideQuestionOne = findViewById(R.id.linearlayout_question1);
        View showQuestionTwo = findViewById(R.id.linearlayout_question2);
        showQuestionTwo.setVisibility(View.GONE);
        mAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);

        // set the appearing view to 0% opacity but visible, so that it is visible (but fully transparent) during the animation
        showQuestionTwo.setAlpha(0f);
        showQuestionTwo.setVisibility(View.VISIBLE);

        // animate the appearing view to 100% opacity, and clear any animation listener set on the view
        showQuestionTwo.animate().alpha(1f).setDuration(mAnimationDuration).setListener(null);

        // animate the disappearing view to 0% opacity and after the animation ends, set its visibility to GONE
        hideQuestionOne.animate().alpha(0f).setDuration(mAnimationDuration).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                hideQuestionOne.setVisibility(View.GONE);
            }
        });
    }
    // q2 -> q3
    public void questionThree(View view){
        final View hideQuestionTwo = findViewById(R.id.linearlayout_question2);
        View showQuestionThree = findViewById(R.id.linearlayout_question3);
        showQuestionThree.setVisibility(View.GONE);
        mAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);

        // set the appearing view to 0% opacity but visible, so that it is visible (but fully transparent) during the animation
        showQuestionThree.setAlpha(0f);
        showQuestionThree.setVisibility(View.VISIBLE);

        // animate the appearing view to 100% opacity, and clear any animation listener set on the view
        showQuestionThree.animate().alpha(1f).setDuration(mAnimationDuration).setListener(null);

        // animate the disappearing view to 0% opacity and after the animation ends, set its visibility to GONE
        hideQuestionTwo.animate().alpha(0f).setDuration(mAnimationDuration).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                hideQuestionTwo.setVisibility(View.GONE);
            }
        });
    }
    // q3 -> q4
    public void questionFour(View view){
        final View hideQuestionThree = findViewById(R.id.linearlayout_question3);
        View showQuestionFour = findViewById(R.id.linearlayout_question4);
        showQuestionFour.setVisibility(View.GONE);
        mAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);

        // set the appearing view to 0% opacity but visible, so that it is visible (but fully transparent) during the animation
        showQuestionFour.setAlpha(0f);
        showQuestionFour.setVisibility(View.VISIBLE);

        // animate the appearing view to 100% opacity, and clear any animation listener set on the view
        showQuestionFour.animate().alpha(1f).setDuration(mAnimationDuration).setListener(null);

        // animate the disappearing view to 0% opacity and after the animation ends, set its visibility to GONE
        hideQuestionThree.animate().alpha(0f).setDuration(mAnimationDuration).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                hideQuestionThree.setVisibility(View.GONE);
            }
        });
    }
    // q4 -> q10
    public void questionFive(View view){
        final View hideQuestionFour = findViewById(R.id.linearlayout_question4);
        View showQuestionTen = findViewById(R.id.linearlayout_question10);
        showQuestionTen.setVisibility(View.GONE);
        mAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);

        // set the appearing view to 0% opacity but visible, so that it is visible (but fully transparent) during the animation
        showQuestionTen.setAlpha(0f);
        showQuestionTen.setVisibility(View.VISIBLE);

        // animate the appearing view to 100% opacity, and clear any animation listener set on the view
        showQuestionTen.animate().alpha(1f).setDuration(mAnimationDuration).setListener(null);

        // animate the disappearing view to 0% opacity and after the animation ends, set its visibility to GONE
        hideQuestionFour.animate().alpha(0f).setDuration(mAnimationDuration).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                hideQuestionFour.setVisibility(View.GONE);
            }
        });
    }
    // q10 -> q5
    public void questionTen(View view){
        final View hideQuestionTen = findViewById(R.id.linearlayout_question10);
        View showQuestionFive = findViewById(R.id.linearlayout_question5);
        showQuestionFive.setVisibility(View.GONE);
        mAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);

        // set the appearing view to 0% opacity but visible, so that it is visible (but fully transparent) during the animation
        showQuestionFive.setAlpha(0f);
        showQuestionFive.setVisibility(View.VISIBLE);

        // animate the appearing view to 100% opacity, and clear any animation listener set on the view
        showQuestionFive.animate().alpha(1f).setDuration(mAnimationDuration).setListener(null);

        // animate the disappearing view to 0% opacity and after the animation ends, set its visibility to GONE
        hideQuestionTen.animate().alpha(0f).setDuration(mAnimationDuration).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                hideQuestionTen.setVisibility(View.GONE);
            }
        });
    }
    // q5 -> q6
    public void questionSix(View view){
        final View hideQuestionFive = findViewById(R.id.linearlayout_question5);
        View showQuestionSix = findViewById(R.id.linearlayout_question6);
        showQuestionSix.setVisibility(View.GONE);
        mAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);

        // set the appearing view to 0% opacity but visible, so that it is visible (but fully transparent) during the animation
        showQuestionSix.setAlpha(0f);
        showQuestionSix.setVisibility(View.VISIBLE);

        // animate the appearing view to 100% opacity, and clear any animation listener set on the view
        showQuestionSix.animate().alpha(1f).setDuration(mAnimationDuration).setListener(null);

        // animate the disappearing view to 0% opacity and after the animation ends, set its visibility to GONE
        hideQuestionFive.animate().alpha(0f).setDuration(mAnimationDuration).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                hideQuestionFive.setVisibility(View.GONE);
            }
        });
    }
    // q6 -> q7
    public void questionSeven(View view){
        final View hideQuestionSix = findViewById(R.id.linearlayout_question6);
        View showQuestionSeven = findViewById(R.id.linearlayout_question7);
        showQuestionSeven.setVisibility(View.GONE);
        mAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);

        // set the appearing view to 0% opacity but visible, so that it is visible (but fully transparent) during the animation
        showQuestionSeven.setAlpha(0f);
        showQuestionSeven.setVisibility(View.VISIBLE);

        // animate the appearing view to 100% opacity, and clear any animation listener set on the view
        showQuestionSeven.animate().alpha(1f).setDuration(mAnimationDuration).setListener(null);

        // animate the disappearing view to 0% opacity and after the animation ends, set its visibility to GONE
        hideQuestionSix.animate().alpha(0f).setDuration(mAnimationDuration).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                hideQuestionSix.setVisibility(View.GONE);
            }
        });
    }
    // q7 -> q9
    public void questionEight(View view){
        final View hideQuestionSeven = findViewById(R.id.linearlayout_question7);
        View showQuestionNine = findViewById(R.id.linearlayout_question9);
        showQuestionNine.setVisibility(View.GONE);
        mAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);

        // set the appearing view to 0% opacity but visible, so that it is visible (but fully transparent) during the animation
        showQuestionNine.setAlpha(0f);
        showQuestionNine.setVisibility(View.VISIBLE);

        // animate the appearing view to 100% opacity, and clear any animation listener set on the view
        showQuestionNine.animate().alpha(1f).setDuration(mAnimationDuration).setListener(null);

        // animate the disappearing view to 0% opacity and after the animation ends, set its visibility to GONE
        hideQuestionSeven.animate().alpha(0f).setDuration(mAnimationDuration).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                hideQuestionSeven.setVisibility(View.GONE);
            }
        });
    }
    // q9 -> q8
    public void questionNine(View view){
        final View hideQuestionNine = findViewById(R.id.linearlayout_question9);
        View showQuestionEight = findViewById(R.id.linearlayout_question8);
        showQuestionEight.setVisibility(View.GONE);
        mAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);

        // set the appearing view to 0% opacity but visible, so that it is visible (but fully transparent) during the animation
        showQuestionEight.setAlpha(0f);
        showQuestionEight.setVisibility(View.VISIBLE);

        // animate the appearing view to 100% opacity, and clear any animation listener set on the view
        showQuestionEight.animate().alpha(1f).setDuration(mAnimationDuration).setListener(null);

        // animate the disappearing view to 0% opacity and after the animation ends, set its visibility to GONE
        hideQuestionNine.animate().alpha(0f).setDuration(mAnimationDuration).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                hideQuestionNine.setVisibility(View.GONE);
            }
        });
    }

    /*
     *  ---- FINAL RESULT ----
     */

    public void finalResults(View view){
        View hideQuestionEight = findViewById(R.id.linearlayout_question8);
        View finalResult = findViewById(R.id.linearlayout_finalResult);
        hideQuestionEight.setVisibility(View.GONE);
        finalResult.setVisibility(View.VISIBLE);

        // edit text - get the entered value
        EditText enteredValue = (EditText) findViewById(R.id.enter_your_name);
        String enteredName = enteredValue.getText().toString();

        // change font of title "Congratulations!"
        TextView congratulationsText = (TextView) findViewById(R.id.textview_congratulations);
        Typeface alexBrushFont = Typeface.createFromAsset(getAssets(), "fonts/AlexBrushRegular.ttf");
        congratulationsText.setTypeface(alexBrushFont);

        TextView scoreCorrect = (TextView) findViewById(R.id.textview_yourScore);
        TextView scoreIncorrect = (TextView) findViewById(R.id.textview_yourScore1);
        scoreCorrect.setText(getResources().getString(R.string.correct_answers) + " " + correctAnswers);
        scoreIncorrect.setText(getResources().getString(R.string.incorrect_answers) + " " + wrongAnswers);

        // low score 0,1,2,3
        if (correctAnswers >= 0 && correctAnswers < 4) {
            // dialog
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle(getResources().getString(R.string.low_score));
            alertDialog.setMessage("\n" + enteredName + getResources().getString(R.string.low_score_description));
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getResources().getString(R.string.thank_you),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
        // medium score 4,5,6,7
        else if (correctAnswers > 3 && correctAnswers < 8) {
            // dialog
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle(getResources().getString(R.string.medium_score));
            alertDialog.setMessage("\n" + enteredName + getResources().getString(R.string.medium_score_description));
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getResources().getString(R.string.thank_you),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
        // high score 8,9,10
        else if (correctAnswers > 7 && correctAnswers <= 10) {
            // dialog
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle(getResources().getString(R.string.high_score));
            alertDialog.setMessage("\n" + enteredName + getResources().getString(R.string.high_score_description));
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getResources().getString(R.string.thank_you),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
        else {}
    }

    /*
     *  ---- IMAGE BUTTON - SHARE YOUR RESULTS ON VARIOUS APPS ----
     */

    public void shareIntent(View view){
        // get information about the user's name
        EditText userName = (EditText) findViewById(R.id.enter_your_name);
        String sUsername = userName.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String quizResults = getResources().getString(R.string.share_text_hey) + " " + sUsername + " " +
                getResources().getString(R.string.share_text_results) + "\n\n" +
                getResources().getString(R.string.correct_answers) + " " + correctAnswers + "/" + (correctAnswers+wrongAnswers) + "\n" +
                getResources().getString(R.string.incorrect_answers) + " " + wrongAnswers + "/" + (correctAnswers+wrongAnswers) + "\n\n" +
                getResources().getString(R.string.share_text_bye);
        intent.putExtra(Intent.EXTRA_TEXT, quizResults);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, getResources().getString(R.string.share_title)));
        }
    }

    /*
     *  ---- BUTTON - REPLAY APP ----
     */

    public void replayApp(View view){
        correctAnswers = 0;
        wrongAnswers = 0;
        setContentView(R.layout.activity_main);

        // change font of title "Geography quiz"
        TextView mainTitle = (TextView) findViewById(R.id.textview_title);
        Typeface sketchFont = Typeface.createFromAsset(getAssets(), "fonts/Sketch.otf");
        mainTitle.setTypeface(sketchFont);
    }

    /*
     *  ---- BUTTON - EXIT APP ----
     */

    public void exitApp(View view){
        finish();
        System.exit(0);
    }

}
