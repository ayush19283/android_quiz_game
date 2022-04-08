package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity implements View.OnClickListener{

    Button b1=null, b2= null , b3=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        b1 = findViewById(R.id.lone);
        b2 = findViewById(R.id.ltwo);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Button clicked_button = findViewById(id);
        String s = clicked_button.getText().toString();
        System.out.println(s+"222222222222222222222222222222222222");
        if(s.matches("EASY")){
            Intent intent=new Intent(HomePage.this,MainActivity.class);
            startActivity(intent);
        }
        else if(s.matches("HARD")){
            Intent intent =new Intent(HomePage.this, stage2.class);
            startActivity(intent);
        }
    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}