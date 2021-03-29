package com.example.basicoperationontwonumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText number1=findViewById(R.id.editTextTextPersonName);
        EditText number2=findViewById(R.id.editTextTextPersonName3);;
        Button button=findViewById(R.id.button);
        TextView sum_res=findViewById(R.id.textView3);
        TextView diff_res=findViewById(R.id.textView4);
        TextView mul_res=findViewById(R.id.textView5);
        TextView div_res=findViewById(R.id.textView6);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Toast.makeText(MainActivity.this, "Converting....", Toast.LENGTH_SHORT).show();
                String s1=number1.getText().toString();
                String s2=number2.getText().toString();
                float number1=Float.parseFloat(s1);
                float number2=Float.parseFloat(s2);
                float sum=number1+number2;
                float difference=number1-number2;
                float multiplication=number1*number2;
                float division=number1/number2;
                sum_res.setText("Sum of the two numbers is "+sum);
                diff_res.setText("Difference of number 1 by number 2 is "+difference);
                mul_res.setText("Multiplication of the two numbers is "+multiplication);
                div_res.setText("Division of number 1 by number 2 is "+division);
            }
        });
    }
}