package com.example.employeedatabaseusingsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBase_Handler dbh=new DataBase_Handler(this, "employeeDatabase",null,1);
        dbh.addEmployee(new Employee(1,"Himesh",3000000));
        dbh.getEmployee(1);
    }
}