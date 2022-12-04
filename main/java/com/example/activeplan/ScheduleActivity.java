package com.example.activeplan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity {

    private ListView scheduleView;
    private ArrayAdapter<String> myAdapter;
    private String[] dayList = {"Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag", "Söndag"};
    //En lista över veckodagarna.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        makeAdapter();
        setListener();
    }

    private void makeAdapter()
    {
        //Skapa en array adapter som använder schemalistan, tala om vilken design raden har = "schedule_list"
        myAdapter = new ArrayAdapter<String>(this, R.layout.schedule_list, dayList);

        //Hämta ListView från layouten och koppla samman.
        scheduleView = (ListView) findViewById(R.id.mainSList);
        scheduleView.setAdapter(myAdapter);

    }

    //Detta händer när man klickar på något i listan.
    private void setListener()
    {
        scheduleView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //OM man klickar på något av följande alternativ ska:
                if(position >= 0 && position <= 6)
                {
                    //Gå vidare till nästa sida genom att klicka på något av följande alternativ i lista.
                    //How to make a listview open a new activity when clicked: Android Rion.
                    //https://www.youtube.com/watch?v=KvpulitmjbM
                    Intent nextToAddWorkout = new Intent(view.getContext(), AddWorkoutActivity.class);

                    //Skickar med det alternativ man klickat på genom att den hämtar upp position ur listan.
                    nextToAddWorkout.putExtra("sendDay", dayList[position]);
                    startActivity(nextToAddWorkout); // Går vidare till nästa sida.

                }
            }
        });


    }

    //Knappar för att komma till aktivitetsvy, beroende på vilken veckodag man vill titta på.
    public void monBtn(View view) {
        Intent monday = new Intent(this, WorkoutActivity.class);
        monday.putExtra("sendDay", "Måndag"); //Om positionen = "Måndag", skickar med innehållet som finns sparat under måndag.
        startActivity(monday); // Går vidare till nästa sida.

    }

    public void tueBtn(View view) {
        Intent tuesday = new Intent(this, WorkoutActivity.class);
        tuesday.putExtra("sendDay", "Tisdag");
        startActivity(tuesday);

    }

    public void wedBtn(View view) {
        Intent wednesday = new Intent(this, WorkoutActivity.class);
        wednesday.putExtra("sendDay", "Onsdag");
        startActivity(wednesday);
    }

    public void thurBtn(View view) {
        Intent thursday = new Intent(this, WorkoutActivity.class);
        thursday.putExtra("sendDay", "Torsdag");
        startActivity(thursday);
    }

    public void friBtn(View view) {
        Intent friday = new Intent(this, WorkoutActivity.class);
        friday.putExtra("sendDay", "Fredag");
        startActivity(friday);
    }

    public void satBtn(View view) {
        Intent saturday = new Intent(this, WorkoutActivity.class);
        saturday.putExtra("sendDay", "Lördag");
        startActivity(saturday);
    }

    public void sunBtn(View view) {
        Intent sunday = new Intent(this, WorkoutActivity.class);
        sunday.putExtra("sendDay", "Söndag");
        startActivity(sunday);
    }

    //Knapp för att logga ut, tar användare tillbaka till inloggningssidan.
    public void LoggaUtButton(View view) {

        Intent nextTologgaUt = new Intent(this, MainActivity.class);
        startActivity(nextTologgaUt);

    }

    //Visar endast användare att den har klickat på knappen.
    public void addWorkoutbtn(View view) {
        Toast.makeText(ScheduleActivity.this, "Du klickade på SKAPA NYTT", Toast.LENGTH_SHORT).show();
    }
}
