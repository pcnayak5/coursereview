package com.example.prashanthc.coursereview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.content.Intent;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    EditText editText;
    ListView courseList;
    String[] courses = {"Materials and Design","Manufacturing Technology","Instrumentation and Control",
            "Strength of Materials","Differential Equations","Machine Drawing Practice","Physics Lab I",
            "Physics Lab II","Thermodynamics","Life Skills","Engineering Drawing"};

    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;


    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;

    public final static String EXTRA_MESSAGE= "com.example.prashanthc.coursereview.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListAdapter LA = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,courses);
        ListView courseList = (ListView) findViewById(R.id.courseList);
        courseList.setAdapter(LA);




        courseList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String courses = String.valueOf(parent.getItemAtPosition(position));
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        intent.putExtra(EXTRA_MESSAGE,courses);
                        startActivity(intent);

                    }
                }
        );


    }

    }









