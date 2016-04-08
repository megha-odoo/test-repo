package com.example.sha.validationemail;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText emailedt, passedt;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailedt = (EditText) findViewById(R.id.edttxtemail);
        passedt = (EditText) findViewById(R.id.edttxtpass);

        //toolbar setting
        toolbar= (Toolbar) findViewById(R.id.toolbr1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home Actvity");
        toolbar.setTitleTextColor(0xff0000ff);


        //button onclick code..
        findViewById(R.id.btn_signup).setOnClickListener(new View.OnClickListener() {
                                                             @Override
                                                             public void onClick(View v) {

                                                                 final String email = emailedt.getText().toString();

                                                                 /*if (!isValidEmail(email)) {
                                                                     emailedt.setError("Invalid Error");
                                                                 }*/

                                                                 if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

                                                                     emailedt.setError("Invalid mail address");
                                                                     emailedt.requestFocus();
                                                                     return;
                                                                 }


                                                                 final String pass = passedt.getText().toString();

                                                                 if (!isValidPassword(pass)) {
                                                                     passedt.setError("Invalid Password");
                                                                 }
                                                                 startActivity(new Intent(MainActivity.this,Main2Activity.class));

                                                             }
                                                         }

        );

        findViewById(R.id.btnsnake).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"This is snackbar",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    // validating email id
    /*private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }*/

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;

    }

    //code for list view(menu)

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        if(id== R.id.abtus)
        {
            startActivity(new  Intent(MainActivity.this,Aboutus.class));
        }
        else
        {
            startActivity(new Intent(MainActivity.this,Feedback.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
