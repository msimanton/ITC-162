package com.example.matthewsimanton.truefalsequiz2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityQuiz extends Activity {

    private TextView mScoreView, mQuestion;
    private ImageView mImageView;
    private Button mTrueButton, mFalseButton;

    private Boolean mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScoreView = (TextView)findViewById(R.id.points);
        mImageView = (ImageView)findViewById(R.id.imageView);
        mQuestion = (TextView)findViewById(R.id.question);
        mTrueButton = (Button)findViewById(R.id.trueButton);
        mFalseButton = (Button)findViewById(R.id.falseButton);

        updateQuestion();

        //logic for true button
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mAnswer == true) {
                    mScore++; //updates score int variable
                    updateScore(mScore); //converts the int variable to a String and adds it to mScoreView

                    //perform this check before you update this question
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(ActivityQuiz.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        ActivityQuiz.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }


                else {
                    if (mQuestionNumber == QuizBook.questions.length){
                        Intent i = new Intent(ActivityQuiz.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        ActivityQuiz.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }

                }


            }
        });



        //logic for false button
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mAnswer == false) {
                    mScore++; //updates score int variable
                    updateScore(mScore); //converts the int variable to a String and adds it to mScoreView

                    //perform this check before you update this question
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(ActivityQuiz.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        ActivityQuiz.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }


                else {
                    if (mQuestionNumber == QuizBook.questions.length){
                        Intent i = new Intent(ActivityQuiz.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        ActivityQuiz.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }

                }


            }
        });






    }

    private void updateQuestion(){
        mImageView.setImageResource(QuizBook.images[mQuestionNumber]);
        mQuestion.setText(QuizBook.questions[mQuestionNumber]);
        mAnswer = QuizBook.answers[mQuestionNumber];
        mQuestionNumber++;
    }

    public void updateScore(int point){
        mScoreView.setText("" + mScore);
    }
}
