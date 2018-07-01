package com.example.hacker.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;

        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.RadioGroup;
        import android.widget.Toast;

        import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    final int Q1_ANSWER = R.id.question_1_9_province;
    final int Q2_ANSWER = R.id.question_2_11_lang;
    final String Q3_ANSWER = "pretoria";
    final int Q4_ANSWER = R.id.question_4_third_mandela_radio;
    final String Q5_ANSWER = "7";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkQuiz(View v) {
        ArrayList<String> incorrectAnswersList = new ArrayList<String>();

        int numberOfQuestionsCorrect = 0;

        if( checkQuestion1() ){
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 1");
        }

        if( checkQuestion2() ){
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 2");
        }



        if( checkQuestion3() ){
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 3");
        }

        if( checkQuestion4() ){
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 4");
        }

        if( checkQuestion5() ){
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 5");
        }

        StringBuilder sb = new StringBuilder();
        for (String s : incorrectAnswersList)
        {
            sb.append(s);
            sb.append("\n");
        }

        Context context = getApplicationContext();
        CharSequence text = "You got " + numberOfQuestionsCorrect + "/5 answers right.\n\nRecheck the following:\n" + sb.toString();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private boolean checkQuestion1() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_1_radio_group);

        if( rg.getCheckedRadioButtonId() == Q1_ANSWER ) {
            return true;
        }

        return false;
    }

    private boolean checkQuestion2() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_2_radio_group);

        if( rg.getCheckedRadioButtonId() == Q2_ANSWER ) {
            return true;
        }

        return false;
    }



    private boolean checkQuestion3() {
        EditText et = (EditText)findViewById(R.id.question_4_edit_text);

        return et.getText().toString().equalsIgnoreCase(Q3_ANSWER);
    }

    private boolean checkQuestion4() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_4_radio_group);

        if( rg.getCheckedRadioButtonId() == Q4_ANSWER ) {
            return true;
        }

        return false;
    }

    private boolean checkQuestion5() {
        EditText et = (EditText)findViewById(R.id.question_5_edit_text);

        return et.getText().toString().equalsIgnoreCase(Q5_ANSWER);
    }


}
