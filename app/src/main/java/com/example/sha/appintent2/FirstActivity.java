package com.example.sha.appintent2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {
      private   EditText edtname,edtcourse,edtyr;
    private Button buttonnext, buttonclear;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        edtname=(EditText)findViewById(R.id.txtviewname);
        edtcourse=(EditText)findViewById(R.id.txtviewcourse);
        edtyr=(EditText)findViewById(R.id.txtviewyear);
        findViewById(R.id.btnnext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent=new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("name",edtname.getText().toString());
                intent.putExtra("course",edtcourse.getText().toString());
                intent.putExtra("year",edtyr.getText().toString());
                startActivity(intent);
            }
        });
       findViewById(R.id.btnclear).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               edtname.setText("");
               edtcourse.setText("");
               edtyr.setText("");

           }
       });
    }
}
