package com.example.printingmultiplicationtableforanumber;

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
        Button button=findViewById(R.id.button);
        EditText number=findViewById(R.id.editTextNumber);
        TextView mul_table=findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String s=number.getText().toString();
                int number_int=Integer.parseInt(s);
                mul_table.setText("\n\n\nMultiplication Table is as follows: ");
                for(int i=1;i<=10;++i){
                    mul_table.append(number_int+" x "+i+" = "+number_int*i+"\n");
                }
            }
        });
    }
}