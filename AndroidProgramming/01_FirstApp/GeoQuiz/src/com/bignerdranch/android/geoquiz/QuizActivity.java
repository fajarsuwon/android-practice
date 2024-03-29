package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private int mCurrentIndex = 0;
    private static final String TAG = "QuizActivity";
    
    
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
    	new TrueFalse(R.string.question_africa, true),
    	new TrueFalse(R.string.question_asia, true),
    	new TrueFalse(R.string.question_mideast, true),
    	new TrueFalse(R.string.question_oceans, true),
    };
    
    
    private void updateQuestion() {
    	int question = mQuestionBank[mCurrentIndex].getQuestion();
    	mQuestionTextView.setText(question);
    }
    
    
    private void checkAnswer(boolean userPressedTrue) {
    	boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
    	int messageResId = 0;
    	
    	if(userPressedTrue == answerIsTrue) {
    		messageResId = R.string.correct_toast;
    	} else {
    		messageResId= R.string.incorrect_toast;
    	}
    	
    	Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Log.d(TAG, "onCreate(Bundle) called");
        
        
        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
        updateQuestion();

        mTrueButton = (Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	checkAnswer(true);
            }
        });

        mFalseButton = (Button)findViewById(R.id.false_button);		
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	checkAnswer(false);            
            }
        });

        mNextButton = (Button)findViewById(R.id.next_button);		
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
            	updateQuestion();
            }
        });
    
    }


    @Override
    public void onStart() {
    	super.onStart();
    	Log.d(TAG, "onStart called");
    }
    
    @Override
    public void onPause() {
    	super.onPause();
    	Log.d(TAG, "onPause called");
    }
    
    @Override
    public void onResume() {
    	super.onResume();
    	Log.d(TAG, "onResume called");
    }
    
    @Override
    public void onStop() {
    	super.onStop();
    	Log.d(TAG, "onStop called");
    }

    @Override
    public void onDestroy() {
    	super.onDestroy();
    	Log.d(TAG, "onDestroy called");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }

}
