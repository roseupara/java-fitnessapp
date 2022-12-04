package com.example.activeplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WorkoutActivity extends AppCompatActivity {

    //Hämtar lista från klassen Workout
ArrayList<Workout> workoutList = Workout.getWorkoutList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        changeContent();

    }

    //Ändrar innehållet på sidan.
    private void changeContent() {

        //Hämtar vald veckodag.
        String getDay = getIntent().getStringExtra("sendDay");

        //Hämtar textvyn för rubriken.
        TextView headtitle = (TextView) findViewById(R.id.changeTitle);

        //Hämtar textvyn för träning.
        TextView txtPlan = (TextView) findViewById(R.id.exPlan);

        //Hämtar edittextvyn för anteckningar.
        EditText txtNotes = findViewById(R.id.editNotes1);

        //Går igenom alla workouts i programmet.
        for(Workout w: Workout.getWorkoutList())
        {
            if(w.getWeekday().equals(getDay))  //Om workout är på vald dag...
            {
                Workout workout = w;  // Hämtar vald dag.
                headtitle.setText(workout.getName()); //Ändrar textheader till vald aktivitet.
                txtNotes.setText(workout.getNotes()); //Hämtar workout anteckningar.
                txtPlan.setText(workout.getInstructions()); //Lägger till innehåll som finns hårdkodade i klassen Workout.
            }

        }

    }

    public void SaveNotesButton(View view) {

        //Hämta värden från inmatning, låter användare skriva text.
        EditText txtNotes = findViewById(R.id.editNotes1);
        String notes = txtNotes.getText().toString();

        //Tar emot innehållet som finns sparat under vald veckodag.
        String getDay = getIntent().getStringExtra("sendDay");

        //En foreach loop som anropar innehållet som finns i workoutlist.
        for(Workout w: Workout.getWorkoutList())
        {

            if(w.getWeekday().equals(getDay)) //Om workout är på vald dag...
            {
                Workout workout = w; //Hämtar vald dag.
                workout.setNotes(notes); //Sparar ändringar temporärt i objektet.
                Toast.makeText(WorkoutActivity.this, "Ändringar har sparats", Toast.LENGTH_SHORT).show();
                //Informerar användare..
            }

        }

    }

    //Knapp för att gå tillbaka till föregående sida.
    public void BackButton(View view) {
        Intent backButton= new Intent(this, ScheduleActivity.class);
        startActivity(backButton);
    }
}