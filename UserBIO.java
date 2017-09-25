package com.example.joe.program1;

import android.content.Intent;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import static android.R.attr.checkedButton;

public class UserBIO extends AppCompatActivity {
    Button btnSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_bio);
        addListenerOnButton();
    }

    private void addListenerOnButton() {
        btnSub = (Button) findViewById(R.id.btnSubmit);
        btnSub.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
//                gets every spot that the user can have input and makes a variable for it
                EditText fname = (EditText)findViewById(R.id.strFirstName);
                EditText lname = (EditText)findViewById(R.id.strLastName);
                EditText school = (EditText)findViewById(R.id.strSchool);
                EditText graduation = (EditText)findViewById(R.id.intGraduation);
                Spinner degree = (Spinner)findViewById(R.id.strDegree);
                EditText major = (EditText)findViewById(R.id.strMajor);
                EditText hobbie = (EditText)findViewById(R.id.strHobbies);
                RadioButton yes = (RadioButton)findViewById(R.id.rbYes);
                RadioButton no = (RadioButton)findViewById(R.id.rbNo);

//Converts those variables into string variables
                String firstName = fname.getText().toString();
                String lastName = lname.getText().toString();
                String schoolName = school.getText().toString();
                String year = graduation.getText().toString();
                String degreeType = degree.getSelectedItem().toString();
                String majorType = major.getText().toString();
                String favHobbie = hobbie.getText().toString();
                String strYes = yes.getText().toString();
                String strNo = no.getText().toString();

//Makes sure that the user filled out the entire form
                if (firstName.matches("") || lastName.matches("") || schoolName.matches("") || year.matches("") || majorType.matches("") || favHobbie.matches("")){
                    Toast empty = Toast.makeText(getApplicationContext(),"You left something blank",Toast.LENGTH_SHORT);
                    empty.show();
                    return;
                }
//Creates and sends the intent to the other activity
                Intent myIntent = new Intent(view.getContext(),PrintScreen.class);
                myIntent.putExtra("fname",firstName);
                myIntent.putExtra("lname",lastName);
                myIntent.putExtra("degree",degreeType);
                myIntent.putExtra("major",majorType);
                myIntent.putExtra("school",schoolName);
                myIntent.putExtra("hobbies",favHobbie);
                myIntent.putExtra("year",year);

//Decides what radio button is selected
                if (yes.isChecked()){
                    myIntent.putExtra("extra", strYes.toLowerCase());
                }
                else {
                    myIntent.putExtra("extra", strNo.toLowerCase());
                }

                startActivity(myIntent);
            }
        });
    }
}
