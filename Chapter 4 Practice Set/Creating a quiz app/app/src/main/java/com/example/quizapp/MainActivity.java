package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String [] questions={"1) Which state in India is at the top in monoculture system of Agriculture farming?",
    "2) Which of the following Indian cities has been ranked second in Global Traffic Congestion Ranking 2021?",
    "3) Which of the following cities is the world's fastest growing mature tech ecosystem since 2016?"
    };
    public String [] button1_options={"Punjab", "Delhi", "London"};
    public String [] button2_options={"West Bengal", "Mumbai", "Bengaluru"};
    public String [] answers={"Punjab","Mumbai","Bengaluru"};
    int score=0;
    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView question=findViewById(R.id.question);
        Button button1=findViewById(R.id.button1);
        Button button2=findViewById(R.id.button2);

        question.setText(questions[index]);
        button1.setText(button1_options[index]);
        button2.setText(button2_options[index]);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (index <= questions.length - 1) {
                    String text = button1.getText().toString();
                    if (text.equalsIgnoreCase(answers[index])) {
                        score += 1;
                    }
                    ++index;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                        button1.setText(button1_options[index]);
                        button2.setText(button2_options[index]);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Your score is: " + score + "/" + questions.length, Toast.LENGTH_LONG).show();
                    }
                }
            else{
//                Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                display_score();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (index <= questions.length - 1) {
                    String text = button2.getText().toString();
                    if (text.equalsIgnoreCase(answers[index])) {
                        score += 1;
                    }
                    ++index;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                        button1.setText(button1_options[index]);
                        button2.setText(button2_options[index]);
                    } else {
//                        Toast.makeText(MainActivity.this, "Your score is: " + score + "/" + questions.length, Toast.LENGTH_LONG).show();
                        display_score();
                    }
                }
            }
        });
    }

    public void display_score(){
        TextView welcome=findViewById(R.id.textView);
        TextView score_display_textView=findViewById(R.id.textView3);
        TextView question=findViewById(R.id.question);
        Button b1=findViewById(R.id.button1);
        Button b2=findViewById(R.id.button2);

        welcome.setVisibility(View.GONE);
        question.setVisibility(View.GONE);
        b1.setVisibility(View.GONE);
        b2.setVisibility(View.GONE);

        score_display_textView.setGravity(Gravity.CENTER);
        score_display_textView.setText("You have scored: "+score+" out of 3\n\nRestart the app to play again!");
    }
}