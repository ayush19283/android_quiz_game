package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class stage2 extends AppCompatActivity implements View.OnClickListener {

    Button b1=null, b2= null , b3=null;
    int win=1;
    int answer;
    int score=0;
    int j;
    String operators[] = {"+", "-"};
    CountDownTimer count;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage2);
        calc();
    }
    void calc(){
        j=0;
        mProgressBar=(ProgressBar)findViewById(R.id.bar1);
        mProgressBar.setProgress(j);
        TextView tv,tv2;

        tv = (TextView) findViewById(R.id.questionone);
        tv2= (TextView) findViewById(R.id.score);
        b1 = findViewById(R.id.firstone);
        b2 = findViewById(R.id.secondone);
        b3 = findViewById(R.id.thirdone);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

        int max=100;
        int min=11;
        int second;
        int first =(int) (Math.random()*(max-min+1)+min);
        answer = (int) (Math.random()*(max-min+1)+min);
        tv2.setText(String.format("%d",score));

        if(first>answer){
            second=first-answer;
            tv.setText(String.format("%d %s %d", first,operators[1],second));

        }
        else{
            second=answer-first;
            tv.setText(String.format("%d %s %d", first,operators[0],second));


        }
        String s = String.valueOf(answer);

        int a = 3;
        int b = 0;
        int temp=answer;
        temp++;
        String s1= String.valueOf(temp);
        temp++;
        String s2= String.valueOf(temp);
        int select = (int) (Math.random() * (a - b + 1) + b);
        if (select == 0) {
            b1.setText(s);
            b2.setText(s1);
            b3.setText(s2);
        } else if (select == 1) {
            b2.setText(s);
            b1.setText(s1);
            b3.setText(s2);

        } else {
            b3.setText(s);
            b1.setText(s1);
            b2.setText(s2);
        }
        count = new CountDownTimer(3000,300) {
            @Override
            public void onTick(long l) {
                Log.v("Log_tag", "Tick of Progress"+ j+ l);

                mProgressBar.setProgress((int)j*100/(3000/300));
                j++;

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(stage2.this, MainActivity2.class);
                startActivity(intent);


            }
        }.start();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        count.cancel();

        String s=String.valueOf(answer);

        Button clicked_button=findViewById(id);
        String ans = clicked_button.getText().toString();
        if(ans.matches(s)){
            win=1;
            score++;
            System.out.println(win);
            calc();
            // Intent intent = new Intent(MainActivity.this, MainActivity.class);
            //startActivity(intent);
        }
        else{
            win=0;

            //System.out.println(win);
            Intent intent = new Intent(stage2.this, MainActivity2.class);
            startActivity(intent);
        }


    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}