package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button b1=null;
        b1 = findViewById(R.id.play);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        Button clicked_button=findViewById(id);
        String ans = clicked_button.getText().toString();
        if(ans.matches("PLAY AGAIN")){
            Intent intent=new Intent(MainActivity2.this,HomePage.class);
            startActivity(intent);
        }
    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}