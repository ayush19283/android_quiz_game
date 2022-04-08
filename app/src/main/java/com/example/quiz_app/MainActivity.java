package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    int answer;
    int win=1;
    int op;
    int j;
    int score=0;
    String operators[] = {"+", "-"};
    CountDownTimer count;
    ProgressDialog TempDialog;
    String s;
    ProgressBar mProgressBar;
    CountDownTimer mCountDownTimer;
    int i=0;
    Button b1=null, b2= null , b3=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc();




        }


     void calc(){


        TextView tv,tv1;
         ProgressBar mProgressBar;
         CountDownTimer mCountDownTimer;
         j=0;

         mProgressBar=(ProgressBar)findViewById(R.id.bar);
         mProgressBar.setProgress(j);
         tv = (TextView) findViewById(R.id.question);
         tv1=(TextView) findViewById(R.id.scor);
         b1 = findViewById(R.id.first);
         b2 = findViewById(R.id.second);
         b3 = findViewById(R.id.third);

         b1.setOnClickListener(this);
         b2.setOnClickListener(this);
         b3.setOnClickListener(this);

         int min = 0;
        int max = 9;

        int second = 0;


//                Scanner sc= new Scanner(System.in);


        //System.out.println("first value ");
        int first = (int) (Math.random() * (max - min + 1) + min);
        //System.out.println(first);

        int max3 = 1;
        //System.out.println("operator");
        op = (int) (Math.random() * (max3 - min + 1) + min);
        //System.out.println(operators[op]);

        if (op == 0) {
            int min1 = first;
            int max2 = 20;
            //System.out.println("answer");
            answer = (int) (Math.random() * (max2 - min1 + 1) + min1);
            //System.out.println(answer);

        } else {
            int max2 = first;
            //System.out.println("answer");
            answer = (int) (Math.random() * (max2 - min + 1) + min);
            //System.out.println(answer);


        }
         switch (op) {
             case 0:
                 //System.out.println("second value");
                 //System.out.println(answer-first);
                 second = answer - first;
                 break;
             case 1:
                 //System.out.println("second value");
                 //System.out.println(first-answer);
                 second = first - answer;
                 break;


         }


         String s = String.valueOf(answer);
         int temp=answer;
         temp++;
         String s1= String.valueOf(temp);
         temp++;
         String s2= String.valueOf(temp);
         System.out.println(String.format("%d %s %d", first, operators[op], second));
         tv.setText(String.format("%d %s %d", first, operators[op], second));
         tv1.setText(String.format("%d",score));
         int a = 3;
         int b = 0;
         int select = (int) (Math.random() * (a - b + 1) + b);
//                int select=0;
         if (select == 0) {
             b1.setText(s);
             b2.setText(s1);
             b3.setText(s2);
         } else if (select == 1) {
             b2.setText(s);
             b1.setText(s2);
             b3.setText(s1);

         } else {
             b3.setText(s);
             b1.setText(s1);
             b2.setText(s2);
         }


        count = new CountDownTimer(2500,250) {
            @Override
            public void onTick(long l) {

                Log.v("Log_tag", "Tick of Progress"+ j+ l);

                mProgressBar.setProgress((int)j*100/(2500/250));
                j++;
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
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
            System.out.println(win);
            calc();
            score++;
           // Intent intent = new Intent(MainActivity.this, MainActivity.class);
            //startActivity(intent);
        }
        else{
            win=0;

            //System.out.println(win);
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        }




    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}