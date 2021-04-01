package com.example.customtemplateforstoringhighscoresinagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int highscore=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);
        TextView high_score_display=findViewById(R.id.textView);

        SharedPreferences pref=getSharedPreferences("Pref",MODE_PRIVATE);
        SharedPreferences.Editor ed=pref.edit();
        high_score_display.setText(pref.getString("name","No Highscore till now"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highscore+=1;
                high_score_display.setText(String.valueOf(highscore));
                ed.putString("name",String.valueOf(highscore));
                ed.apply();
            }
        });

    }
}