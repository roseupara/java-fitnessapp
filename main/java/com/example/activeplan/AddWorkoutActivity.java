package com.example.activeplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddWorkoutActivity extends AppCompatActivity {
    Spinner daySpin;
    Spinner workoutSpin;
    String val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);
        LoadSpinner();

        //Hämta information från föregående sida mha bundle + nyckel som är relaterad till informationen som är överförd.
        Bundle extras = getIntent().getExtras();
        //Sparar informationen från nyckeln till stringen.
        String getDay = extras.getString("sendDay");

        //Skapar en spinner för veckodagarna.
        daySpin = (Spinner) findViewById(R.id.spinnerDay);
        //Listan som spinnern innehåller har ett innehåll från getDay.
        String[] weekdayList = {getDay};

        //Sätter spinners innehåll.
        ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, weekdayList);
        daySpin.setAdapter(dayAdapter);

    }

    private void LoadSpinner()
    {
        //Välj träningsplan som ska läggas till i schemalista under vald dag.
    workoutSpin = (Spinner) findViewById(R.id.spinnerWorkout);
    ArrayList<String> workoutArr = new ArrayList<String>();

    workoutArr.add("Ben");
    workoutArr.add("Armar");
    workoutArr.add("Rygg");
    workoutArr.add("Cardio");

    ArrayAdapter<String> workoutAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, workoutArr);
        workoutSpin.setAdapter(workoutAdapter);
    }


    public void SaveEditButton (View view) {

        //Hämtar veckodag som är skickat från ScheduleActivity.
        String getDay = getIntent().getStringExtra("sendDay");
        val = workoutSpin.getSelectedItem().toString(); //Sparar och läser av valt alternativ från spinner.
        Workout workout = new Workout(val, getDay); //Anropar konstruktor från klassen Workout, skickar med inparametrar.

        Toast.makeText(AddWorkoutActivity.this, "Du valde: " + val, Toast.LENGTH_SHORT).show();
        //Visar vad det är för alternativ som har valts och lagts till.

    }

    //Tillbaka knapp till Schema-vyn.
    public void BackButton(View view) {

        Intent backToPreviousPage= new Intent(this, ScheduleActivity.class);
        startActivity(backToPreviousPage);
    }

}

