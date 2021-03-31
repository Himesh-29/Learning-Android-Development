package com.example.contactdetailsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView rc;

    Contact_Details CD1=new Contact_Details(1,"David",1234567);
    Contact_Details CD2=new Contact_Details(2,"Lewis",1234667);
    Contact_Details CD3=new Contact_Details(3,"Rick",1234568);
    Contact_Details CD4=new Contact_Details(4,"Samuel",1224567);
    Contact_Details CD5=new Contact_Details(5,"John",1234367);
    Contact_Details CD6=new Contact_Details(6,"Doug",1254567);
    Contact_Details CD7=new Contact_Details(7,"Nealson",1934567);
    Contact_Details CD8=new Contact_Details(8,"Mark",1934568);
    Contact_Details CD9=new Contact_Details(9,"Joe",1934569);
    Contact_Details CD10=new Contact_Details(10,"Himesh",1944567);
    Contact_Details CD11=new Contact_Details(11,"Ram",1934577);
    Contact_Details CD12=new Contact_Details(12,"Shyam",2934567);
    Contact_Details CD13=new Contact_Details(13,"Baburao",3934567);
    Contact_Details CD14=new Contact_Details(14,"Ankit",1944667);
    Contact_Details CD15=new Contact_Details(15,"Srujan",2944567);
    Contact_Details CD16=new Contact_Details(16,"Kanha",2844567);
    Contact_Details CD17=new Contact_Details(17,"Pankaj",2544567);
    Contact_Details CD18=new Contact_Details(18,"Ashish",2644567);
    Contact_Details CD19=new Contact_Details(19,"Ajay",5944567);
    Contact_Details CD20=new Contact_Details(20,"Aakash",6944567);


    Contact_Details [] CD={CD1,CD2,CD3,CD4,CD5,CD6,CD7,CD8,CD9,CD10,CD11,CD12,CD13,CD14,CD15,CD16,CD17,CD18,CD19,CD20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rc=findViewById(R.id.recyclerView);
        rc.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapter adapter=new CustomAdapter(CD);
        rc.setAdapter(adapter);
        rc.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}