package com.example.joe.program1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class PrintScreen extends AppCompatActivity {
    TextView print;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_screen);
        addListenerOnButton();

//        Recieves and prints out the intent sent by the other activity
        print = (TextView) findViewById(R.id.message);
        print.setText(getIntent().getStringExtra("fname"));
        print.append(" ");
        print.append(getIntent().getStringExtra("lname"));
        print.append(" holds a ");
        print.append(getIntent().getStringExtra("degree"));
        print.append(" in ");
        print.append(getIntent().getStringExtra("major"));
        print.append(" from ");
        print.append(getIntent().getStringExtra("school"));
        print.append(" in which they graduated from in the year ");
        print.append(getIntent().getStringExtra("year"));
        print.append(". Their interests include ");
        print.append(getIntent().getStringExtra("hobbies"));
        print.append(".");
        print.append(" When asked if they participated in clubs/sports they answered ");
        print.append(getIntent().getStringExtra("extra"));
        print.append(".");

    }

    private void addListenerOnButton() {
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
//Sends user back to previous screen
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(),UserBIO.class);

                startActivity(myIntent);
            }
        });
    }
}
