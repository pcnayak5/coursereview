package com.example.prashanthc.coursereview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    EditText buckysInput;
    TextView buckysText;
    MyBDHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buckysInput = (EditText) findViewById(R.id.buckysinput);
        buckysText = (TextView) findViewById(R.id.buckysText);
        dbHandler = new MyBDHandler(this, null);
        printDatabase();

        Intent i = getIntent();

        String course = i.getStringExtra(MainActivity.EXTRA_MESSAGE);

    }public void addButtonClicked(View view){
        Subjects subject = new Subjects(buckysInput.getText().toString());
        dbHandler.addSubject(subject);
        printDatabase();
    }


    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        buckysText.setText(dbString);
        buckysInput.setText("");


    }


    }

