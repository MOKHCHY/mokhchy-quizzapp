package com.example.mokhchy_quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz3 extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    Button bNext;
    int score;
    String RepCorrect="Non";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        rg=(RadioGroup) findViewById(R.id.Gpradio);
        bNext=(Button) findViewById(R.id.BtnRegister);
        Intent intent=getIntent();
        score=intent.getIntExtra("score",0) ;
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rg.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Merci de choisir une réponse S.V.P !", Toast.LENGTH_SHORT).show();
                } else {
                    rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                    //Toast.makeText(getApplicationContext(),rb.getText().toString(),Toast.LENGTH_SHORT).show();
                    if (rb.getText().toString().equals(RepCorrect)) {
                        score += 1;
                        //Toast.makeText(getApplicationContext(),score+"",Toast.LENGTH_SHORT).show();
                    }
                    Intent intent = new Intent(Quiz3.this, Quiz4.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }


            }
        });
    }
}