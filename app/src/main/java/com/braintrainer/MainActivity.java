package com.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView result;
    TextView question;
    TextView scoreTextView;
    Button playagain;
    TextView timer;
    int a,numquestion,score,b;
    int gameState=0;

    int [] answers={-1,-1,-1,-1};
    public void start(View view)
    {
        Button goButton=(Button)view;
        goButton.setVisibility(View.INVISIBLE);
        gameState=1;
        button0.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        question.setVisibility(View.VISIBLE);
        timer.setVisibility(View.VISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
        Log.i("befor new queston","error");
           playAgain(view);
    }

    public void newQuestion()
    {

        Random rand =new Random();
         a=rand.nextInt(21);
        b=rand.nextInt(21);
        int hideCorrectAnswer=rand.nextInt(4);
        Log.i("error","before question");
        question.setText(Integer.toString(a)+"+"+Integer.toString(b));
        Log.i("error","before question");
        for(int i=0;i<4;i++)
        {
            int wrongAnswer=rand.nextInt(41);
            while(wrongAnswer==a+b)
            {
                wrongAnswer=rand.nextInt(41);
            }
            answers[i]=wrongAnswer;
        }
        Log.i("error","aftr for loop");
        answers[hideCorrectAnswer]=a+b;
        button0.setText(Integer.toString(answers[0]));
        button1.setText(Integer.toString(answers[1]));
        button2.setText(Integer.toString(answers[2]));
        button3.setText(Integer.toString(answers[3]));


    }
    public void chooseAnswer(View view)
    {
        if(gameState==1) {
            Button option = (Button) view;

            if (Integer.parseInt(option.getText().toString()) == a + b) {
                result.setText("sahi h");
                score++;

                numquestion++;
            } else {
                result.setText("galat jawab");

                numquestion++;

            }
            scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numquestion));
            result.setVisibility(View.VISIBLE);
            newQuestion();
        }
    }
    public void playAgain(View view)
    {
        score=0;
        numquestion=0;
        gameState=1;
        newQuestion();
        playagain.setVisibility(View.INVISIBLE);
        result.setText("Shru ho ja");
        new CountDownTimer(30100,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(millisUntilFinished/1000)+"s");

            }

            @Override
            public void onFinish() {
                playagain.setVisibility(View.VISIBLE);
                result.setText("smay khatm");
                gameState=0;

            }
        }.start();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         button0 =(Button)findViewById(R.id.button0);
        button1 =(Button)findViewById(R.id.button1);
        button2 =(Button)findViewById(R.id.button2);
         button3 =(Button)findViewById(R.id.button3);
         question =(TextView)findViewById(R.id.questonTextView);
        result=(TextView)findViewById(R.id.resultTextView);
        scoreTextView=(TextView)findViewById(R.id.scoreTextView);
        playagain=(Button) findViewById(R.id.button4);
        timer=(TextView) findViewById(R.id.timerTextView);

    }
}
