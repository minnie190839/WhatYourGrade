package com.example.win8.whatyourgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.R.attr.name;

public class Main2Activity extends AppCompatActivity {
    TextView t;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t = (TextView) findViewById(R.id.textView3);
        t1 =(TextView) findViewById(R.id.textView4);
        Intent Page = getIntent();
        String Name = Page.getStringExtra("name");
        String Score = Page.getStringExtra("score");
        t.setText(Name);
        t1.setText(Score);
    }
}
