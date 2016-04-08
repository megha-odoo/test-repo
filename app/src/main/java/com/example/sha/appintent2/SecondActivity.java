package com.example.sha.appintent2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class    SecondActivity extends AppCompatActivity {
private Bundle bundle;
    private  String strname,strcouse,stryear;
    private TextView txtname,txtcourse,txtyr;
    private Button b1back;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bundle=getIntent().getExtras();

        strname=bundle.getString("name");
        strcouse=bundle.getString("course");
        stryear=bundle.getString("year");

        txtname=(TextView)findViewById(R.id.txtname);
        txtcourse=(TextView)findViewById(R.id.txtcourse);
        txtyr=(TextView)findViewById(R.id.txtyr);

        txtname.setText(strname);
        txtcourse.setText(strcouse);
        txtyr.setText(stryear);


        findViewById(R.id.btnback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(">>>>>","Worked");
                intent=new Intent(SecondActivity.this,FirstActivity.class);
                startActivity(intent);

            }
        });


    }
}
