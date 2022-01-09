package com.example.appd5_caps;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import ca.roumani.i2c.CountryDB;

public class MainActivity extends AppCompatActivity
{
    private Game game;
    private String question;
    private String answer;
    private int score;
    private int qNum;
    private String resultS = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
        question = "";
        answer = "";
        score = 0;
        qNum = 1;
        ask();
    }

    public void ask()
    {
        TextView ques = (TextView) findViewById(R.id.question);
        String qu = game.qa();
        String[] lines = qu.split("\\n");
        question = lines[0];
        answer = lines[1];
        ques.setText(question);
    }


    public void onDone(View v)
    {



        TextView ques = (TextView) findViewById(R.id.question);
        TextView qN = (TextView) findViewById(R.id.qNum);
        TextView result = (TextView) findViewById(R.id.log);
        TextView scoreO = (TextView) findViewById(R.id.score);
        String ansS;


        if(qNum == 10)
        {
            qN.setText("Game Over!");
            Button button1 = (Button) findViewById(R.id.button);
            button1.setEnabled(false);
            button1.setClickable(false);
            finish();

        }

        else
        {
            ansS = ((EditText) findViewById(R.id.answer)).getText().toString();
            resultS = "\nQ# " + qNum + ": " + question + "\nYour Answer: " + ansS + "\nCorrect Answer: " + answer + "\n" + resultS;
            qNum++;
            qN.setText("Q# " + qNum);
            result.setText(resultS);
            if(ansS.equalsIgnoreCase(answer))
            {
                score++;
                scoreO.setText("SCORE = " + score);
            }
            ask();
        }
        ((EditText) findViewById(R.id.answer)).setText("");
    }

}